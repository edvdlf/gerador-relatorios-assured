package br.com.vetorit.fasttax.autenticador.licenca.usuarios;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import br.com.vetorit.fasttax.core.BaseTests;
import br.com.vetorit.fasttax.integracao.model.AccountDTO;

public class PostGerarLicencaTest extends BaseTests {
	
	private String TOKEN;
	
	//private String URL_AUTH = "http://localhost:8099";
	private String URL_AUTH = "http://server44.integrator.com.br:3482";

	@BeforeEach
	public void login() {
		AccountDTO dto = new AccountDTO("master@master.com", "Master@123");
		TOKEN = given()
				.body(dto)
				.when()
				.post(URL_AUTH + "/auth/signin")
				.then()
				.statusCode(200)
				.extract()
				.path("accessToken");

	}
	

	//@Test
	@Order(1)
	public void deveGerarLicenca() {
		
			Map<String, Object> dto = new HashMap<>();
			dto.put("id",null);
			dto.put("idTennant","7cfaa4c6-9eea-4b93-84aa-353ef7d5e27d");
			dto.put("idProduto","eaa38668-9cb6-41d5-bedb-8b1747eaa6ce");
			dto.put("idPlano","8234d849-8a03-4c1e-aa9b-773789cead97");
			dto.put("licenca","");
			
		given().
			log()
			.all()
			.contentType("application/json")
			.header("Authorization", "Bearer " + TOKEN)
			.body(dto)
			.when()
			.post(URL_AUTH + "/api/v1/produto-licenca")
			.then()
			.log()
			.all()
			.statusCode(201);
	}
	
//	@Test
//	@Order(3) //Obtem todos os Tennants e gera licenca para cada um empresa para cada
//	public void teste3() {
//		ArrayList<TennantResponseDTO> tennants = given()
//				.header("Authorization", "Bearer " + TOKEN)
//				.when()
//				.get(URL_AUTH + "/api/v1/tennant/sempaginacao")
//				.then()
//				.statusCode(200)
//				.extract()
//				.body()
//				.as(new TypeRef<ArrayList<TennantResponseDTO>>() {
//				});
//
//		
//		assertNotNull(tennants);
//		assertTrue(tennants.size() > 0);
//
//		int cont = 0;
//		for (TennantResponseDTO tennant : tennants) {
//			
//			cont ++;
//			String sidTennant = tennant.getId();
//			UUID idTennant = UUID.fromString(sidTennant);
//
//			//System.out.println("idTennant: " + idTennant);
//			System.out.println("idPlano: " + idTennant);
//			System.out.println("sequencia: " + cont);
//
//			
//			
//
//			Map<String, Object> dto = new HashMap<>();
//			
//			dto.put("idTennant",idTennant);
//			dto.put("idProduto","eaa38668-9cb6-41d5-bedb-8b1747eaa6ce");
//			dto.put("idPlano", getRandomId());
//			System.out.println("idPlano: " + getRandomId());
//			dto.put("licenca","");
//			
//			if(cont < 50) {
//				given().
//				log()
//				.all()
//				.contentType("application/json")
//				.header("Authorization", "Bearer " + TOKEN)
//				.body(dto)
//				.when()
//				.post(URL_AUTH + "/api/v1/produto-licenca")
//				.then()
//				.log()
//				.all()
//				.statusCode(201);
//				
//			}
//		}
//	}
	
	private static final List<String> IDS = List.of(
	        "4d598fb2-6e2a-4275-9292-68ddcb4829a3",
	        "12cf0611-0973-4127-8515-19e569bbca93",
	        "baa327b3-18b7-4d14-8ef9-8eb2ebaeda1b",
	        "26fe4289-e84a-4ec6-b2a9-eb65d3b11145",
	        "8234d849-8a03-4c1e-aa9b-773789cead97",
	        "1559dae8-efc1-440e-8682-4342c23057ec"
	    );
	
	private static final Random RANDOM = new Random();

    /**
     * Retorna um ID aleatório da lista de IDs.
     * @return Um ID aleatório como String.
     */
    public static String getRandomId() {
        int randomIndex = RANDOM.nextInt(IDS.size()); // Gera um índice aleatório
        return IDS.get(randomIndex); // Retorna o ID correspondente
    }



}
