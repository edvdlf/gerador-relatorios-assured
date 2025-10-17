package br.com.vetorit.geradorrelatorio.tests.templaterelatorio;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.vetorit.fasttax.core.BaseTests;
import io.restassured.http.ContentType;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateTest extends BaseTests {

	
	private Map<String, Object> bodyTemplate(long id, String nome) {
        Map<String, Object> b = new HashMap<>();
        b.put("id", id);                     // precisa bater com o {id} no path
        b.put("nome", nome);                 // ajuste campos que seu service valida
        b.put("descricao", "Novo texto");    // exemplo
        // Se tiver mais campos obrigatórios, inclua-os aqui:
        // b.put("ativo", true);
        // b.put("campos", List.of(...));
        return b;
    }

	@Test
	@Order(1)
	public void deveRetornarTemplateAgrupadoNFse() {

		String filtro="NFSe";
		
		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
		.get("/api/template-relatorio/campos/agrupado?texto=" + filtro)
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(2)
	public void deveRetornarTemplateBuscar() {

		String filtro="NFSe";
		
		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
		.get("/api/template-relatorio/buscar?texto=NFSe")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
    @Order(3)
    @DisplayName("Deve atualizar os campos de um template existente com sucesso (200 OK)")
    void deveAtualizarCamposComSucesso() {
        long templateId = 1L;

        String requestBody = """
            {
              "id": 1,
              "camposIds": [10, 11, 12]
            }
            """.formatted(templateId);

        given()
            .header("Authorization", "Bearer " + TOKEN_TEMP) // remova se não precisar de autenticação
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/api/template-relatorio/update-campos/{id}", 1)
        .then()
            .statusCode(200)
            .body("id", equalTo((int) templateId))
            //.body("campos", not(empty())) // valida que retornou lista de campos
            .body("campos.size()", greaterThan(0))
            .body("$", notNullValue());
    }

    @Test
    @Order(4)
    @DisplayName("Não deve permitir update com lista de campos vazia (400 BAD REQUEST)")
    void naoDevePermitirCamposVazios() {
        long templateId = 1L;

        String requestBody = """
            {
              "id": %d,
              "camposIds": []
            }
            """.formatted(templateId);

        given()
            .header("Authorization", "Bearer " + TOKEN_TEMP)
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/api/templates/{id}/updateCampos", templateId)
        .then()
            .statusCode(400)
            .body("message", containsString("deve conter pelo menos um campo"));
    }

	
	

}
