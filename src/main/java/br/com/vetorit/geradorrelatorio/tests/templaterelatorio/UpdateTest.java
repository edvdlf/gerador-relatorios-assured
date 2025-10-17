package br.com.vetorit.geradorrelatorio.tests.templaterelatorio;

import static io.restassured.RestAssured.given;
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
	@Order(20)
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
	@Order(21)
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
	@Order(22)
	void deveAtualizarComSucesso() {
	    long id = 1;
	    Map<String, Object> body = new HashMap<>();
	    body.put("id", id);
	    body.put("nome", "Relatório Atualizado");
	    body.put("descricao", "Template atualizado com dois campos de teste");
	    List<Map<String, Object>> campos = List.of(
	            Map.of("id", 7),
	            Map.of("id", 13),
	            Map.of("id", 18)
	        );
	    body.put("campos", campos);
	    given()
	        .header("Authorization", "Bearer " + TOKEN_TEMP)
	        .contentType(ContentType.JSON)
	        .body(body)
	    .when()
	        .put("api/template-relatorio/{id}", id)
	    .then()
	        .statusCode(200)
	        .body("id", equalTo((int) id))
	        .body("nome", equalTo("Relatório Atualizado"))
	        .body("$", notNullValue());
	}

	

}
