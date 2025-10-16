package br.com.vetorit.fasttax.tests.integracao.test.login;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.vetorit.fasttax.core.BaseTests;
import br.com.vetorit.fasttax.integracao.model.AccountDTO;

public class LoginTest extends BaseTests {

private String TOKEN;

private String URL_AUTH = "http://localhost:8090";


	@BeforeEach
	public void login() {
		AccountDTO dto = new AccountDTO("usu1@usu.com","Teste@123");
		TOKEN =	given()
			.body(dto)
		.when()
			.post(URL_AUTH + "/auth/signin")
		.then()
			.statusCode(200)
			.extract()
			.path("accessToken");
	}

	@Test
	public void deveRetornarUsuariosAll() {
//		given()
//		.header("Authorization", "Bearer " + TOKEN)
//		.when().get("/api/v1/usuarios")
//		.then()
//		.statusCode(200);
	}

	
	//@Test
	public void deveRetornarUsuariosById() {
		given()
		.header("Authorization", "Bearer " + TOKEN)
		.when().get("/api/v1/usuarios/8def924f-bc6d-4c72-a28a-e7cf32ee6c9b")
		.then()
		.statusCode(200);
	}
	//@Test
	public void deveRetornarExceptionIdNaoEncontrado() {
		given()
		.header("Authorization", "Bearer " + TOKEN)
		.when().get("/api/v1/usuarios/1c145d2f-7ad6-48c3-a8a7-b57fe252f953")
		.then()
		.statusCode(404);
	}
	


}	