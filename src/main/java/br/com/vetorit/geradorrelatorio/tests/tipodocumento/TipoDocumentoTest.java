package br.com.vetorit.geradorrelatorio.tests.tipodocumento;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import br.com.vetorit.fasttax.core.BaseTests;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.junit.jupiter.api.*;

import io.restassured.http.ContentType;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TipoDocumentoTest extends BaseTests {

	String TOKEN = TOKEN_TEMP;
	
	private Map<String, Object> payloadMinimo(long id) {
        Map<String, Object> p = new HashMap<>();
        p.put("id", id);
        return p;
    }

    private Map<String, Object> payloadCompleto() {
        Map<String, Object> p = new HashMap<>();
        p.put("id", 2L);
        p.put("titulo", "NFe v4.00");
        p.put("descricao", "para exclusão de teste");
        p.put("ativo", true);
        p.put("nomeArquivo", "nfe_v4.xsd");
        // demais campos ignorados no delete, mas úteis para cobrir binding
        return p;
    }

	@Test @Order(1)
	void deveCriarTipoDocumento_DFeTiposBasicos_v1() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "DFe TiposBasicos v1.00");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "DFeTiposBasicos_v1.00.xsd");
		payload.put("ativo", true);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.post("/api/tipo-documento")
				.then()
				.log()
				.all()
				.statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("DFe TiposBasicos v1.00"))
				.body("ativo", equalTo(true));
	}
	
	@Test @Order(2)
	void deveCriarTipoDocumento_leiauteNFe_v4() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "Leiaute NFe v4.00");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "leiauteNFe_v4.00.xsd");
		payload.put("ativo", true);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.post("/api/tipo-documento")
				.then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("Leiaute NFe v4.00"))
				.body("ativo", equalTo(true));
	}
	
	@Test @Order(3)
	void deveCriarTipoDocumento_tiposBasico_v4() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "Tipos Basico v4");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "tiposBasico_v4.00.xsd");
		payload.put("ativo", true);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.post("/api/tipo-documento")
				.then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("Tipos Basico v4"))
				.body("ativo", equalTo(true));
	}
	
	@Test @Order(4)
	void deveCriarTipoDocumento_xmldsig_core_schema_v1() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "XMLdsig core schema v1");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "xmldsig-core-schema_v1.01.xsd");
		payload.put("ativo", true);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.post("/api/tipo-documento")
				.then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("XMLdsig core schema v1"))
				.body("ativo", equalTo(true));
	}
	
	@Test @Order(5)
	void deveCriarTipoDocumento_nfe_v4() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "NFe v4.00");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "nfe_v4.00.xsd");
		payload.put("ativo", true);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.post("/api/tipo-documento")
				.then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("NFe v4.00"))
				.body("ativo", equalTo(true));
	}

	@Test @Order(6)
	void deveAtualizarTipoDocumento_tiposBasico_v4() {

		// Arrays vazios conforme contrato
		List<Map<String, Object>> colunas = new ArrayList<>(); // [] (vazio)
		List<String> tagsMulti = new ArrayList<>(); // [] (vazio)

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 1);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "Tipos Basico v4");
		payload.put("descricao", "Este é apenas um cadastro de teste");
		payload.put("nomeArquivo", "tiposBasico_v4.00.xsd");
		payload.put("ativo", false);
		payload.put("colunas", colunas); // []
		payload.put("tagsMultiOcorrs", ""); // ""
		payload.put("tagsMulti", tagsMulti); // []
		payload.put("quantidadeCampos", 99); // incluído conforme exemplo do anexo

		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON).header("Authorization", "Bearer " + TOKEN)
				.body(payload)
				.log()
				.all()
				.when()
				.put("/api/tipo-documento/1")
				.then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue())
				.body("titulo", equalTo("Tipos Basico v4"))
				.body("ativo", equalTo(false));
	}

	@Test @Order(6)
	public void deveRetornar6TiposDocumento() {

	    given()
	        .log().all()
	        .header("Authorization", "Bearer " + TOKEN)
	        .accept(ContentType.JSON)
	    .when()
	        .get("/api/tipo-documento")
	    .then()
	        .log().all()
	        .statusCode(200)
	        // valida que retornou exatamente 5 registros (ajuste conforme esperado)
	        //.body("size()", equalTo(6))
	        ;
	}
	
	@Test @Order(7)
    @DisplayName("200 OK — body JSON completo")
    void deveExcluirComBodyCompleto() {
        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .header("Authorization", "Bearer " + TOKEN)
            .body(payloadCompleto())
            .log().all()
        .when()
            .delete("/api/tipo-documento")
        .then()
            .log().all()
            .statusCode(200);
    }
	
	@Test @Order(8)
	public void deveRetornar5TiposDocumento() {

	    given()
	        .log().all()
	        .header("Authorization", "Bearer " + TOKEN)
	        .accept(ContentType.JSON)
	    .when()
	        .get("/api/tipo-documento")
	    .then()
	        .log().all()
	        .statusCode(200)
	        // valida que retornou exatamente 5 registros (ajuste conforme esperado)
	        //.body("size()", equalTo(5))
	        ;
	}

}