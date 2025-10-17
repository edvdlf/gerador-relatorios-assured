package br.com.vetorit.geradorrelatorio.tests.carga;

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
public class CargaGeralTest extends BaseTests {

	private Map<String, Object> payloadMinimo(long id) {
		Map<String, Object> p = new HashMap<>();
		p.put("id", id);
		return p;
	}

	private Map<String, Object> payloadCompleto() {
		Map<String, Object> p = new HashMap<>();
		p.put("id", 2L);
		p.put("titulo", "NFSe");
		p.put("descricao", "NF Eletrônica de Serviços");
		p.put("ativo", true);
		p.put("nomeArquivo", "tiposComplexos_v1.00.xsd");
		return p;
	}
	
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
	void deveCriarTipoDocumento_NFSe() {
		List<Map<String, Object>> colunas = new ArrayList<>(); 
		List<String> tagsMulti = new ArrayList<>(); 

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "NFSe");
		payload.put("descricao", "NF Eletrônica de Serviços");
		payload.put("nomeArquivo", "NFSe_v1.00_ajustado.xsd");
		payload.put("ativo", false);
		payload.put("colunas", colunas); 
		payload.put("tagsMultiOcorrs", ""); 
		payload.put("tagsMulti", tagsMulti); 
		payload.put("quantidadeCampos", 99); 

		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).body(payload).log().all().when()
				.post("/api/tipo-documento").then().log().all().statusCode(200)
				// asserções básicas úteis (ajuste conforme seu response)
				.body("id", notNullValue()).body("titulo", equalTo("NFSe")).body("ativo", equalTo(true));
	}

	@Test
	@Order(2)
	void deveCriarTipoDocumento_CTe() {
		
		List<Map<String, Object>> colunas = new ArrayList<>(); 
		List<String> tagsMulti = new ArrayList<>(); 

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "CTe");
		payload.put("descricao", "Conhecimento de Transporte Eletrônico");
		payload.put("nomeArquivo", "cte_v4.00_ajustado.xsd");
		payload.put("ativo", false);
		payload.put("colunas", colunas); 
		payload.put("tagsMultiOcorrs", ""); 
		payload.put("tagsMulti", tagsMulti); 
		payload.put("quantidadeCampos", 99); 

		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).body(payload).log().all().when()
				.post("/api/tipo-documento").then().log().all().statusCode(200)
				.body("id", notNullValue()).body("titulo", equalTo("CTe")).body("ativo", equalTo(true));
	}

	@Test
	@Order(3)
	void deveCriarTipoDocumento_NFe() {
		
		List<Map<String, Object>> colunas = new ArrayList<>(); 
		List<String> tagsMulti = new ArrayList<>(); 

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "NFe");
		payload.put("descricao", "Nota Fiscal Eletrônica de Mercadoria");
		payload.put("nomeArquivo", "nfe_v4.00_ajustado.xsd");
		payload.put("ativo", false);
		payload.put("colunas", colunas); 
		payload.put("tagsMultiOcorrs", ""); 
		payload.put("tagsMulti", tagsMulti); 
		payload.put("quantidadeCampos", 99); 

		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).body(payload).log().all().when()
				.post("/api/tipo-documento").then().log().all().statusCode(200)
				.body("id", notNullValue()).body("titulo", equalTo("NFe")).body("ativo", equalTo(true));
	}

	@Test
	@Order(4)
	void deveCriarTipoDocumento_NFE() {
		
		List<Map<String, Object>> colunas = new ArrayList<>(); 
		List<String> tagsMulti = new ArrayList<>(); 

		Map<String, Object> payload = new LinkedHashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-11T22:36:33.938Z");
		payload.put("titulo", "NFe v4.00");
		payload.put("descricao", "Nota Fiscal Eletronica Layout 4.00");
		payload.put("nomeArquivo", "nfe_v4.00_ajustado.xsd");
		payload.put("ativo", false);
		payload.put("colunas", colunas); 
		payload.put("tagsMultiOcorrs", ""); 
		payload.put("tagsMulti", tagsMulti); 
		payload.put("quantidadeCampos", 99); 

		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).body(payload).log().all().when()
				.post("/api/tipo-documento").then().log().all().statusCode(200)
				
				.body("id", notNullValue()).body("titulo", equalTo("NFe v4.00")).body("ativo", equalTo(true));
	}

	@Test
	@Order(5)
	public void deveRetornarTiposDocumento() {

		given().log().all().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
				.get("/api/tipo-documento").then().log().all().statusCode(200)
		
		;
	}


	@Test
	@Order(6)
	void deveCriarNovaConfiguracaoURL() {
		
		Map<String, Object> coluna = new HashMap<>();
		coluna.put("id", 0);
		coluna.put("nome", "chaveAcesso");
		coluna.put("tipo", "string");
		coluna.put("descricao", "Chave de acesso da NFe");
		coluna.put("valores", "44 dígitos");
		coluna.put("caminho", "/NFe/infNFe/ide");

		Map<String, Object> tipoDocumento = new HashMap<>();
		tipoDocumento.put("id", 1);
		tipoDocumento.put("dataCadastro", "2025-09-13T09:00:00.000Z");
		tipoDocumento.put("titulo", "NFe v4.00");
		tipoDocumento.put("descricao", "Nota Fiscal Eletrônica versão 4.00");
		tipoDocumento.put("nomeArquivo", "nfe_v4.00.xsd");
		tipoDocumento.put("ativo", true);
		tipoDocumento.put("colunas", List.of(coluna));
		tipoDocumento.put("tagsMultiOcorrs", "tagDuplicada");
		tipoDocumento.put("tagsMulti", List.of());
		tipoDocumento.put("quantidadeCampos", 12);

		Map<String, Object> payload = new HashMap<>();
		payload.put("id", 0);
		payload.put("dataCadastro", "2025-09-13T10:00:00.000Z");
		payload.put("sistema", "ELR - NFe Produção");
		payload.put("tipoDocumento", tipoDocumento);
		payload.put("url", "https://api.elr.avalara.com/v1/documents/nfe/do");
		payload.put("ativo", true);
		payload.put("numDownloads", 5);
		payload.put("ultimaExecucao", "2025-09-13T11:00:00.000Z");

		// Requisição
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).body(payload).log().all().when()
				.post("/api/configuracao-url").then().log().all().statusCode(200).body("id", greaterThan(0))
				.body("sistema", equalTo("ELR - NFe Produção"))
				.body("url", equalTo("https://api.elr.avalara.com/v1/documents/nfe/do")).body("ativo", equalTo(true));
	}

	@Test
	@Order(7)
	@DisplayName("Deve realizar upload de arquivo XSD com sucesso")
	void deveFazerUpload_NFSe_v1_ajustado() {
		File file = new File("src\\main\\resources\\PL_010b_NT2025_002_v1.21\\NFSe_v1.00_ajustado.xsd");
		if (!file.exists()) {
			throw new RuntimeException("Arquivo de teste não encontrado: " + file.getAbsolutePath());
		}

		given().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).contentType("multipart/form-data")
				.multiPart("file", file).when().post("/api/tipo-documento/upload/{id}", 1).then().log()
				.ifValidationFails().statusCode(200).contentType(ContentType.JSON).body("id", notNullValue());

	}

	@Test
	@Order(8)
	@DisplayName("Deve realizar upload de arquivo XSD com sucesso")
	void deveFazerUpload_CTe_v4_ajustado() {
		File file = new File("src\\main\\resources\\PL_010b_NT2025_002_v1.21\\cte_v4.00_ajustado.xsd");
		if (!file.exists()) {
			throw new RuntimeException("Arquivo de teste não encontrado: " + file.getAbsolutePath());
		}

		given().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).contentType("multipart/form-data")
				.multiPart("file", file).when().post("/api/tipo-documento/upload/{id}", 2).then().log()
				.ifValidationFails().statusCode(200).contentType(ContentType.JSON).body("id", notNullValue());

	}

	@Test
	@Order(9)
	@DisplayName("Deve realizar upload de arquivo XSD com sucesso")
	void deveFazerUpload_NFe_v4_ajustado() {
		File file = new File("src\\main\\resources\\PL_010b_NT2025_002_v1.21\\nfe_v4.00_ajustado.xsd");
		if (!file.exists()) {
			throw new RuntimeException("Arquivo de teste não encontrado: " + file.getAbsolutePath());
		}

		given().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).contentType("multipart/form-data")
				.multiPart("file", file).when().post("/api/tipo-documento/upload/{id}", 3).then().log()
				.ifValidationFails().statusCode(200).contentType(ContentType.JSON).body("id", notNullValue());

	}
	
	@Test
	@Order(10)
	public void deveRetornarTiposDocumentoById() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/tipo-documento/1")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(11)
	public void deveRetornarTiposDocumentoComDefinicaoColuna() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/tipo-documento/1/with-definicao-coluna")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(12)
	public void deveRetornarTiposDocumentoAtivo() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/tipo-documento/ativos")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(13)
	public void deveRetornarAcompanhamentoStatus() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/acompanhamento-status")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(14)
	public void deveRetornarAcompanhamentoStatusUltimaAtualizacao() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/acompanhamento-status/ultima-atualizacao")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(15)
	void deveCriarTemplateRelatorioTipoDocumentoNFSe() {
	    Map<String, Object> tipoDocumento = new LinkedHashMap<>();
	    tipoDocumento.put("id", 1);
	    
	    List<Map<String, Object>> campos = List.of(
	            Map.of("id", 7),
	            Map.of("id", 13),
	            Map.of("id", 18)
	        );

	    Map<String, Object> payload = new LinkedHashMap<>();
	    payload.put("nome", "Template-Nfse");
	    payload.put("descricao", "Template de teste para Nfse");
	    payload.put("tipoDocumento", tipoDocumento);
	    payload.put("campos", campos); // []
	    
	    given()
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization", "Bearer " + TOKEN_TEMP)
	        .body(payload)
	        .log().all()
	    .when()
	        .post("/api/template-relatorio")
	    .then()
	        .log().all()
	        .statusCode(200)
	        .body("nome", equalTo("Template-Nfse"))
	        .body("tipoDocumento.id", equalTo(1));
	}
	
	@Test
	@Order(16)
	void deveCriarTemplateRelatorioTipoDocumentoCTE() {
	    Map<String, Object> tipoDocumento = new LinkedHashMap<>();
	    tipoDocumento.put("id", 2);
	   	    
	    List<Map<String, Object>> campos = List.of(
	            Map.of("id", 208),
	            Map.of("id", 218),
	            Map.of("id", 300),
	            Map.of("id", 303)
	        );

	    Map<String, Object> payload = new LinkedHashMap<>();
	    payload.put("nome", "Template-CTE");
	    payload.put("descricao", "Template de teste para CTE");
	    payload.put("tipoDocumento", tipoDocumento);
	    payload.put("campos", campos); // []
	   

	    given()
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization", "Bearer " + TOKEN_TEMP)
	        .body(payload)
	        .log().all()
	    .when()
	        .post("/api/template-relatorio")
	    .then()
	        .log().all()
	        .statusCode(200)
	        .body("nome", equalTo("Template-CTE"))
	        .body("tipoDocumento.id", equalTo(2));
	}



	
	
	
	@Test
	@Order(15)
	public void deveRetornarRequisicaoRelatorioTipoDocumento() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/tipos-documentos")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(16)
	public void deveRetornarRequisicaoRelatorioTemplateRelatorio() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/templates-relatorios?tipoDocumentoId=1")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(17)
	public void deveRetornarRequisicaoFonteDadosRelatorio() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/fonte-dados-urls?tipoDocumentoId=1")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(18)
	public void deveRetornarDashboard() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/dashboard")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(19)
	public void deveRetornarTemplateRelatorio() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/template-relatorio")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	@Order(19)
	public void deveRetornarTemplateRelatorioIdCampos() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
		.get("/api/template-relatorio/1/campos")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
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
	
	
}
