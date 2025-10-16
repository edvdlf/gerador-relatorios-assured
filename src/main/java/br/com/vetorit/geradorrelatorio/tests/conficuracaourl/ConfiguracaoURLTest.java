package br.com.vetorit.geradorrelatorio.tests.conficuracaourl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.vetorit.fasttax.core.BaseTests;
import io.restassured.http.ContentType;

	public class ConfiguracaoURLTest extends BaseTests {

	    String TOKEN = TOKEN_TEMP; // herdado do BaseTests ou substitua pelo seu token válido

	    @Test
	    void deveCriarNovaConfiguracaoURL() {
	        // Monta payload
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
	        given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)
	            .header("Authorization", "Bearer " + TOKEN)
	            .body(payload)
	            .log().all()
	        .when()
	            .post("/api/configuracao-url")
	        .then()
	            .log().all()
	            .statusCode(200)
	            .body("id", greaterThan(0))
	            .body("sistema", equalTo("ELR - NFe Produção"))
	            .body("url", equalTo("https://api.elr.avalara.com/v1/documents/nfe/do"))
	            .body("ativo", equalTo(true));
	    }
	    
	    @Test
	    void deveCriarNovaConfiguracaoURL2() {
	        // Monta payload
	        Map<String, Object> coluna = new HashMap<>();
	        coluna.put("id", 0);
	        coluna.put("nome", "chaveAcesso");
	        coluna.put("tipo", "string");
	        coluna.put("descricao", "Chave de acesso da NFe");
	        coluna.put("valores", "44 dígitos");
	        coluna.put("caminho", "/NFe/infNFe/ide");

	        Map<String, Object> tipoDocumento = new HashMap<>();
	        tipoDocumento.put("id", 2);
	        tipoDocumento.put("dataCadastro", "2025-09-13T09:00:00.000Z");
	        tipoDocumento.put("titulo", "DFe TiposBasicos v1.00");
	        tipoDocumento.put("descricao", "Nota Fiscal Eletrônica versão 4.00");
	        tipoDocumento.put("nomeArquivo", "DFeTiposBasicos_v1.00.xsd");
	        tipoDocumento.put("ativo", true);
	        tipoDocumento.put("colunas", List.of(coluna));
	        tipoDocumento.put("tagsMultiOcorrs", "tagDuplicada");
	        tipoDocumento.put("tagsMulti", List.of());
	        tipoDocumento.put("quantidadeCampos", 12);

	        Map<String, Object> payload = new HashMap<>();
	        payload.put("id", 0);
	        payload.put("dataCadastro", "2025-09-13T10:00:00.000Z");
	        payload.put("sistema", "TaxDocs Monitor 2.0 - CTe");
	        payload.put("tipoDocumento", tipoDocumento);
	        payload.put("url", "https://api.taxdocs.avalara.com/v2/transport/");
	        payload.put("ativo", true);
	        payload.put("numDownloads", 15);
	        payload.put("ultimaExecucao", "2025-09-13T11:00:00.000Z");

	        // Requisição
	        given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)
	            .header("Authorization", "Bearer " + TOKEN)
	            .body(payload)
	            .log().all()
	        .when()
	            .post("/api/configuracao-url")
	        .then()
	            .log().all()
	            .statusCode(200)
	            .body("id", greaterThan(0))
	            .body("sistema", equalTo("TaxDocs Monitor 2.0 - CTe"))
	            .body("url", equalTo("https://api.taxdocs.avalara.com/v2/transport/"))
	            .body("ativo", equalTo(true));
	    }
	    
	    @Test
	    void deveCriarNovaConfiguracaoURL3() {
	        // Monta payload
	        Map<String, Object> coluna = new HashMap<>();
	        coluna.put("id", 0);
	        coluna.put("nome", "chaveAcesso");
	        coluna.put("tipo", "string");
	        coluna.put("descricao", "Chave de acesso da NFe");
	        coluna.put("valores", "44 dígitos");
	        coluna.put("caminho", "/NFe/infNFe/ide");

	        Map<String, Object> tipoDocumento = new HashMap<>();
	        tipoDocumento.put("id", 3);
	        tipoDocumento.put("dataCadastro", "2025-09-13T09:00:00.000Z");
	        tipoDocumento.put("titulo", "DFe TiposBasicos v1.00");
	        tipoDocumento.put("descricao", "Nota Fiscal Eletrônica versão 4.00");
	        tipoDocumento.put("nomeArquivo", "DFeTiposBasicos_v1.00.xsd");
	        tipoDocumento.put("ativo", true);
	        tipoDocumento.put("colunas", List.of(coluna));
	        tipoDocumento.put("tagsMultiOcorrs", "tagDuplicada");
	        tipoDocumento.put("tagsMulti", List.of());
	        tipoDocumento.put("quantidadeCampos", 12);

	        Map<String, Object> payload = new HashMap<>();
	        payload.put("id", 0);
	        payload.put("dataCadastro", "2025-09-13T10:00:00.000Z");
	        payload.put("sistema", "TaxDocs Monitor 1.0 - NFSe");
	        payload.put("tipoDocumento", tipoDocumento);
	        payload.put("url", "https://legacy.taxdocs.avalara.com/v1/service");
	        payload.put("ativo", true);
	        payload.put("numDownloads", 15);
	        payload.put("ultimaExecucao", "2025-09-13T11:00:00.000Z");

	        // Requisição
	        given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)
	            .header("Authorization", "Bearer " + TOKEN)
	            .body(payload)
	            .log().all()
	        .when()
	            .post("/api/configuracao-url")
	        .then()
	            .log().all()
	            .statusCode(200)
	            .body("id", greaterThan(0))
	            .body("sistema", equalTo("TaxDocs Monitor 1.0 - NFSe"))
	            .body("url", equalTo("https://legacy.taxdocs.avalara.com/v1/service"))
	            .body("ativo", equalTo(true));
	    }



}