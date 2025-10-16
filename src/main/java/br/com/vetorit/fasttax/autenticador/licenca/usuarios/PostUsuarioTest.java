package br.com.vetorit.fasttax.autenticador.licenca.usuarios;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import br.com.vetorit.fasttax.core.BaseTests;

public class PostUsuarioTest extends BaseTests {
	
	private String TOKEN;
	
	private String URL_AUTH = "http://localhost:8099";
	//private String URL_AUTH = "http://server44.integrator.com.br:3482";

	

	@Test
	@Order(1)
	public void deveIncluirUsuarioQuandoAindaNaoForCadastrado() {
		
			Map<String, Object> dto = new HashMap<>();

			dto.put("name","Usuario Teste 1");
			dto.put("firstName","Usuario");
			dto.put("lastName","Teste ");
			dto.put("email","usu@usu.com");
			dto.put("password","Teste@123");
			dto.put("tipoUsuario","CLIENTE");
			dto.put("cpfCnpj","12903165000152");
			dto.put("cep","07713250");
			dto.put("endereco","Avenida Marcelino Bressiane 875");
			dto.put("cidade","Caieiras");
			dto.put("estado","São Paulo");
			dto.put("accountNonLocked","true");
			dto.put("uf","SP");
			dto.put("role","CLIENTE");
		given().
			log()
			.all()
			.contentType("application/json")
			.body(dto)
			.when()
			.post(URL_AUTH +    "/auth/register")
			.then()
			.log()
			.all()
				.statusCode(201);
	}


}
