package br.com.vetorit.fasttax.autenticador.licenca.usuarios;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

import br.com.vetorit.fasttax.core.BaseTests;
import br.com.vetorit.fasttax.integracao.enums.TipoUsuario;
import br.com.vetorit.fasttax.integracao.excel.ExcelReader;
import br.com.vetorit.fasttax.integracao.model.AccountDTO;
import br.com.vetorit.fasttax.integracao.model.UsuarioRequestAuthDTO;
import br.com.vetorit.fasttax.integracao.model.UsuarioRequestRegisterDTO;
import br.com.vetorit.fasttax.integracao.model.excel.Empresa;
import io.restassured.parsing.Parser;

public class CargaDeDadosUsuarioTennant extends BaseTests {

	private String TOKEN;

	@Value("${diretorio.arquivo.empresas}")
	private String diretorioArquivoEmpresas;

	private String URL_AUTH = "http://localhost:8099";
	//private String URL_AUTH = "http://server44.integrator.com.br:3482";

	@BeforeEach
	public void login() {
		AccountDTO dto = new AccountDTO("master@master.com", "Master@123");
		TOKEN = given().body(dto).when().post(URL_AUTH + "/auth/signin").then().statusCode(200).extract()
				.path("accessToken");

	}
	
	

	//@Test //Inclui Tennant e Usuario
	@Order(1)
	public void teste1() throws IOException {
		
		ClassPathResource resource = new ClassPathResource("planilhaExcel/EMPRESAS.xlsx");
		File file = resource.getFile();
		ExcelReader excelReader = new ExcelReader();
		List<Empresa> listaEmpresas = excelReader.lerEmpresasMatriz(file.getAbsolutePath());
		int count = listaEmpresas.size()-1;
		UsuarioRequestRegisterDTO dto = null;

		for (int i = 1; i <= count; i++) {

			dto = new UsuarioRequestRegisterDTO();
			dto.setName("Admin " + listaEmpresas.get(i).getNome().substring(0,10));
			dto.setFirstName("Administrador");
			dto.setLastName(listaEmpresas.get(i).getNome().substring(0,10));
			dto.setCpfCnpj(listaEmpresas.get(i).getCnpj());
			dto.setPassword("Teste@123");
			dto.setTipoUsuario(TipoUsuario.CLIENTE);
			dto.setEndereco(listaEmpresas.get(i).getEndereco());
			dto.setEstado(listaEmpresas.get(i).getEstado());
			dto.setCidade(listaEmpresas.get(i).getCidade());
			dto.setUf(listaEmpresas.get(i).getUf());
			dto.setEmail(listaEmpresas.get(i).getEmail());
			dto.setOnPremise(true);
			

			given()
			.log()
			.all()
			.contentType("application/json")
			.body(dto)
			.when()
			.post(URL_AUTH + "/auth/register")
					.then()
					.log()
					.all()
					.statusCode(200);

		}


	}

	@Test //Testa o Login dos Usuarios Obs: Apenas Admin e Master retornan 200 porque os demais estão bloqueados.
	@Order(2)
	public void teste2() throws IOException {

		ClassPathResource resource = new ClassPathResource("planilhaExcel/EMPRESAS.xlsx");
		File file = resource.getFile();
		ExcelReader excelReader = new ExcelReader();
		List<Empresa> listaEmpresas = excelReader.lerEmpresasMatriz(file.getAbsolutePath());
		int count = listaEmpresas.size() - 1;

		//int limite = 2;
		int limite = count;
		
		
		
		for (int i = 1; i <= count; i++) {
			
			if(i <=limite) {
				UsuarioRequestAuthDTO dto = new UsuarioRequestAuthDTO();
				dto.setUserName(listaEmpresas.get(i).getEmail());
				dto.setPassword("Teste@123");
				int statusCod = 0;
							
				
				given()
				.log()
				.all()
				.contentType("application/json")
				.body(dto)
				.when()
				.post(URL_AUTH + "/auth/signin")
				.then()
				.log().all().statusCode(200);
			}
			
			

		}
	}

	//@Test
	@Order(3) //Obtem todos os Tennants e Cadastra uma empresa para cada
//	public void teste3() {
//		ArrayList<TennantResponseDTO> tennants = given().header("Authorization", "Bearer " + TOKEN).when()
//				.get(URL_AUTH + "/api/v1/tennant/sempaginacao").then()
////		            .log()
////		            .all()
//				.statusCode(200).extract().body().as(new TypeRef<ArrayList<TennantResponseDTO>>() {
//				});
//
//		// Agora você pode usar a lista de Tennants para asserções ou outras operações
//		assertNotNull(tennants);
//		assertTrue(tennants.size() > 0);
//		
//
//		for (TennantResponseDTO tennant : tennants) {
//			String sidTennant = tennant.getId();
//			UUID idTennant = UUID.fromString(sidTennant);
//
//			System.out.println("idTennant: " + idTennant);
//
//			EmpresaDTO dto = new EmpresaDTO();
//			
//			if(tennant.getCnpj()!="28389084000116") {
//				dto.setCnpjEmpresa(tennant.getCnpj());
//				dto.setCodigo(null);
//				dto.setId(null);
//				dto.setIdTennant(idTennant);
//				dto.setLicenca("");
//				dto.setNomeFantasiaEmpresa("");
//				dto.setRazaoSocialEmpresa(tennant.getNome());
//
//				given().log().all().header("Authorization", "Bearer " + TOKEN).contentType("application/json").body(dto)
//						.when().post(URL_AUTH + "/api/v1/empresas").then().log().all().statusCode(201);
//			}
//
//			
//
//		}
////		for (TennantResponseDTO tennant : tennants) {
////			String sidTennant = tennant.getId();
////			UUID idTennant = UUID.fromString(sidTennant);
////
////			System.out.println("idTennant: " + idTennant);
////
////			EmpresaDTO dto = new EmpresaDTO();
////
////			dto.setCnpjEmpresa(tennant.getCnpj());
////			dto.setCodigo(null);
////			dto.setId(null);
////			dto.setIdTennant(idTennant);
////			dto.setLicenca("");
////			dto.setNomeFantasiaEmpresa("");
////			dto.setRazaoSocialEmpresa(tennant.getNome());
////
////			given().log().all().header("Authorization", "Bearer " + TOKEN).contentType("application/json").body(dto)
////					.when().post(URL_AUTH + "/api/v1/empresas").then().log().all().statusCode(403);
////
////		}
//
//	}
//	 
//	 	//@Test //Cadastra estabelecimentos consultando empresas
//		@Order(4)
//		public void teste4() throws IOException {
//	 		
//
//			ClassPathResource resource = new ClassPathResource("planilhaExcel/EMPRESAS.xlsx");
//			File file = resource.getFile();
//			ExcelReader excelReader = new ExcelReader();
//			List<Estabelecimento> listaEstabelecimento = excelReader.lerEmpresasEstabelecimentos(file.getAbsolutePath());
//			int count = listaEstabelecimento.size() - 1;
//			EstabelecimentoDTO dto = null;
//
//			for (int i = 1; i <= count; i++) {
//
//				String cnpjEmpresa = listaEstabelecimento.get(i).getCnpjEmpresa().toString();
//				
//				//String IdEmpresa = ObtemIdEmpresaByCnpj(cnpjEmpresa);
//				
//				EmpresaResponseDTO empresa = ObtemIdEmpresaAndIdTennantByCnpj(cnpjEmpresa);
//				
//				String idEmpresa = empresa.getId();
//				UUID idEmp = UUID.fromString(idEmpresa);
//				
//				String idTennant = empresa.getIdTennant();
//				UUID idTenn = UUID.fromString(idTennant);
//				
//				
//				
//				dto = new EstabelecimentoDTO();
//				dto.setCnpjEstabelecimento(listaEstabelecimento.get(i).getCnpjEstabelecimento());
//				dto.setIdEmpresa(idEmp);
//				dto.setIdTennant(idTenn);
//				dto.setRazaoSocialEstabelecimento(listaEstabelecimento.get(i).getRazaoSocialEstabelecimento());
//				dto.setUf(listaEstabelecimento.get(i).getUf());
//				
//				given()
//				.log()
//				.all()
//				.header("Authorization", "Bearer " + TOKEN)
//				.contentType("application/json")
//				.body(dto)
//				.when()
//				.post(URL_AUTH + "/api/v1/estabelecimentos")
//				.then()
//				.log()
//				.all()
//				.statusCode(201);
//			}
//
//
//		}


//	public void obterIdTennantDeCadaLinha(List<TennantResponseDTO> tennants) {
//
//		for (TennantResponseDTO tennant : tennants) {
//			String sidTennant = tennant.getId();
//			UUID idTennant = UUID.fromString(sidTennant);
//
//			System.out.println("idTennant: " + idTennant);
//
//			EmpresaDTO dto = new EmpresaDTO();
//
//			dto.setCnpjEmpresa(tennant.getCnpj());
//			dto.setCodigo(null);
//			dto.setId(null);
//			dto.setIdTennant(idTennant);
//			dto.setLicenca("");
//			dto.setNomeFantasiaEmpresa("");
//			dto.setRazaoSocialEmpresa(tennant.getNome());
//
//			given().log().all().header("Authorization", "Bearer " + TOKEN).contentType("application/json").body(dto)
//					.when().post(URL_AUTH + "/api/v1/empresas").then().log().all().statusCode(201);
//
//		}
//	}
//	
	private String ObtemIdEmpresaByCnpj(String cnpj) {

		String result = given()
		        .header("Authorization", "Bearer " + TOKEN)
		        .when()
		        .get(URL_AUTH + "/api/v1/empresas/cnpj/" + cnpj)
		        .then()
		        .log()
		        .all()
		        .statusCode(200)
		        // Define o parser JSON para a resposta
		        .defaultParser(Parser.JSON)
		        .extract()
		        
		        .path("id");

		    return result;
	}
	
	

	private String ObtemCNPJ(String cnpj) {

		String result = given().header("Authorization", "Bearer " + TOKEN).when().get("/api/v1/tennant/cnpj/" + cnpj)
				.then().extract().path("cnpjEmpresa");
		return result;
	}

}
