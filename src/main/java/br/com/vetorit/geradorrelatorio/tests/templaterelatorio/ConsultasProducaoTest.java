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
public class ConsultasProducaoTest extends BaseTests {

	
	
	
	String urlProducao = "https://qa-relatorios-taxdocs.vetorit-solucoes.com.br/taxdocs";
	
	
	
	// INICIO Consultas TIPO DOCUMENTO
	 @Test
	public void deveRetornarTiposDocumentoAll() {

		given().log().all().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
				.get(urlProducao + "/api/tipo-documento").then().log().all().statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarTiposDocumentoById() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/tipo-documento/2152")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarTiposDocumentoComDefinicaoColuna() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/tipo-documento/2152/with-definicao-coluna")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarTiposDocumentoAtivos() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/tipo-documento/ativos")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}

	// FIM Consultas TIPO DOCUMENTO
	
	// INICIO Consultas STATUS PROCESSAMENTO
	
	@Test
	public void deveRetornarStatusProcessamento() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/acompanhamento-status")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarStatusProcessamentoUltimaAtualizacao() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/acompanhamento-status/ultima-atualizacao")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	
	// FIM Consultas STATUS PROCESSAMENTO
	 
	// INICIO Consultas REQUISICAO RELATORIO
	
	@Test
	public void deveRetornarRequisicaoRelatorioTipoDocumento() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/requsicao-relatorio/tipos-documentos"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarRequisicaoRelatorioTemplateRelatorio() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/requsicao-relatorio/templates-relatorios?tipoDocumentoId=1"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	public void deveRetornarRequisicaoRelatorioFonteDeDadosURL() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/requsicao-relatorio/fonte-dados-urls?tipoDocumentoId=1"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	
	// FIM Consultas REQUISICAO RELATORIO
	
	
	// INICIO Consultas DASHBOARD
	@Test
	public void deveRetornarDashboard() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/dashboard"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	
	// FIM Consultas DASHBOARD
	
	// INICIO Consultas FILIAIS
	
	@Test
	public void deveRetornarFiliais() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/filiais"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	// FIM Consultas FILIAIS
	
	// INICIO Consultas CONFIGURAÇAO URL
	@Test
	public void deveRetornarConfiguracaoURL() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/configuracao-url"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	
	// FIM Consultas CONFIGURAÇAO URL
	
	
	// INICIO Consultas TEMPLATESL
	
	@Test
		public void deveRetornarTemplateRelatorio() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
	
	@Test
	public void deveRetornarTemplateRelatorioIdCampos() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
		.get(urlProducao + "/api/template-relatorio/52/campos")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}

	@Test
		public void deveRetornarTemplateRelatorioNodes_2152() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio/campos/nodes/2152")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
	
	@Test
	
		public void deveRetornarTemplateRelatorioNodes_2153() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio/campos/nodes/2153")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		
		public void deveRetornarTemplateRelatorioNodes_2154() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio/campos/nodes/2154")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		public void deveRetornarTemplateRelatorioNodes_2852() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio/campos/nodes/2852")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		public void deveRetornarTemplateRelatorioList_2852() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get(urlProducao + "/api/template-relatorio/campos/list/2852")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		
	
	
	// FIM Consultas TEMPLATES
	
	
	
	
	
	
	
	
	
	
		
	
	
}
