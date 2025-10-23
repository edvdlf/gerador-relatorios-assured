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
public class ConsultasDevLocalTest extends BaseTests {

	
	
	
	
	
	
	
	// INICIO Consultas TIPO DOCUMENTO
	 @Test
	 @Order(1)
	public void deveRetornarTiposDocumentoAll() {

		given().log().all().header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
				.get("/api/tipo-documento").then().log().all().statusCode(200)
		
		;
	}
	
	@Test
	 @Order(2)
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
	 @Order(3)
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
	 @Order(4)
	public void deveRetornarTiposDocumentoAtivos() {

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

	// FIM Consultas TIPO DOCUMENTO
	
	// INICIO Consultas STATUS PROCESSAMENTO
	
	@Test
	 @Order(5)
	public void deveRetornarStatusProcessamento() {

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
	 @Order(6)
	public void deveRetornarStatusProcessamentoUltimaAtualizacao() {

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
	
	
	// FIM Consultas STATUS PROCESSAMENTO
	 
	// INICIO Consultas REQUISICAO RELATORIO
	
	@Test
	 @Order(7)
	public void deveRetornarRequisicaoRelatorioTipoDocumento() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/tipos-documentos"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	 @Order(8)
	public void deveRetornarRequisicaoRelatorioTemplateRelatorio() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/templates-relatorios?tipoDocumentoId=1"
				+ "	")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	@Test
	 @Order(9)
	public void deveRetornarRequisicaoRelatorioFonteDeDadosURL() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/requsicao-relatorio/fonte-dados-urls?tipoDocumentoId=1"
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
	 @Order(10)
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
	
	
	// FIM Consultas DASHBOARD
	
	// INICIO Consultas FILIAIS
	
	@Test
	 @Order(11)
	public void deveRetornarFiliais() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get( "/api/filiais")
		.then()
		.log()
		.all()
		.statusCode(500)
		
		;
	}
	
	// FIM Consultas FILIAIS
	
	// INICIO Consultas CONFIGURAÇAO URL
	@Test
	@Order(12)
	public void deveRetornarConfiguracaoURL() {

		given()
		.log()
		.all()
		.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
		.get("/api/configuracao-url")
		.then()
		.log()
		.all()
		.statusCode(200)
		
		;
	}
	
	
	// FIM Consultas CONFIGURAÇAO URL
	
	
	// INICIO Consultas TEMPLATESL
	
	@Test
	@Order(13)
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
	@Order(14)
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
	@Order(15)
		public void deveRetornarTemplateRelatorioNodes_2152() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/campos/nodes/1")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
	
	@Test
	@Order(16)
	
		public void deveRetornarTemplateRelatorioNodes_2153() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/campos/nodes/2")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		@Order(17)
		
		public void deveRetornarTemplateRelatorioNodes_2154() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/campos/nodes/3")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		@Order(18)
		public void deveRetornarTemplateRelatorioNodes_2852() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/campos/nodes/1")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		@Test
		@Order(19)
		public void deveRetornarTemplateRelatorioList_2852() {

			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP_ADMIN).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/campos/list/1")
			.then()
			.log()
			.all()
			.statusCode(200)
			
			;
		}
		
		
	
	
	// FIM Consultas TEMPLATES
	
	
		
		
		
		
		@Test
		@Order(24)
		public void deveRetornarTemplatePrefixo_NFe() {

			String filtro="NFe";
			
			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/filtro/prefixo?texto=" + filtro)
			.then()
			.log()
			.all()
			.statusCode(200)
			.body("size()", equalTo(1512));
			
			
		}
		
		@Test
		@Order(24)
		public void deveRetornarTemplatePrefixo_NFSe() {

			String filtro="NFSe";
			
			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/filtro/prefixo?texto=" + filtro)
			.then()
			.log()
			.all()
			.statusCode(200)
			.body("size()", equalTo(202));
			
			
		}
		@Test
		@Order(24)
		public void deveRetornarTemplatePrefixo_CTe() {

			String filtro="CTe";
			
			given()
			.log()
			.all()
			.header("Authorization", "Bearer " + TOKEN_TEMP).accept(ContentType.JSON).when()
			.get("/api/template-relatorio/filtro/prefixo?texto=" + filtro)
			.then()
			.log()
			.all()
			.statusCode(200)
			.body("size()", equalTo(319));
			
			
		}
		
	
	
	
	
	
	
	
		
	
	
}
