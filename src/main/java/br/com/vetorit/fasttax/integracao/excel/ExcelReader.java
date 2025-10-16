package br.com.vetorit.fasttax.integracao.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.vetorit.fasttax.integracao.model.excel.Empresa;
import br.com.vetorit.fasttax.integracao.model.excel.Estabelecimento;

public class ExcelReader {

	public List<Empresa> lerEmpresasMatriz(String filePath) {
		List<Empresa> empresas = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			// Acessa a planilha chamada "empresas"
			Sheet sheet = workbook.getSheet("empresas");
			int totLinhasPlanilha = sheet.getLastRowNum();
			// Itera sobre as linhas (iniciando na linha 1 para ignorar o cabeçalho)
			for (int i = 0; i <= 115; i++) {

				Row row = sheet.getRow(i);
				Empresa empresa = new Empresa();
				String cpfCnpj = row.getCell(0).getStringCellValue();
				if (row.getCell(0).getStringCellValue().length() == 18) {

					cpfCnpj = cpfCnpj.replace(".", "").replace("/", "").replace("-", "");

					empresa.setCnpj(cpfCnpj);
					empresa.setEndereco(row.getCell(1).getStringCellValue());
					empresa.setNome(row.getCell(2).getStringCellValue());
					empresa.setCidade(row.getCell(3).getStringCellValue());
					empresa.setEstado(row.getCell(4).getStringCellValue());
					empresa.setUf(row.getCell(5).getStringCellValue());
					empresa.setEmail("usu" + i + "@usu.com");

					System.out.println(empresa.getCnpj() + "-" + empresa.getEmail());
					;

				}

				if (row.getCell(0).getStringCellValue().length() == 14) {
					empresa.setEmail("usu" + i + "@usu.com");
					cpfCnpj = cpfCnpj.replace(".", "").replace("-", "");

					empresa.setCnpj(cpfCnpj);
					System.out.println(empresa.getCnpj() + "-" + empresa.getEmail());
					;

				}
				empresas.add(empresa);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return empresas;
	}

	public List<Estabelecimento> lerEmpresasEstabelecimentos(String filePath) {
		List<Estabelecimento> estabelecimentos = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			// Acessa a planilha chamada "empresas"
			Sheet sheet = workbook.getSheet("estabelecimentos");
			int totLinhasPlanilha = sheet.getLastRowNum();
			// Itera sobre as linhas (iniciando na linha 1 para ignorar o cabeçalho)
			for (int i = 0; i <= 86; i++) {

				Row row = sheet.getRow(i);
				Estabelecimento estabelecimento = new Estabelecimento();
				String cpfCnpj = row.getCell(0).getStringCellValue();
				String cpfCnpjEmpresa = row.getCell(1).getStringCellValue();

				if (row.getCell(0).getStringCellValue().length() == 18) {

					cpfCnpj = cpfCnpj.replace(".", "").replace("/", "").replace("-", "");
					cpfCnpjEmpresa = cpfCnpjEmpresa.replace(".", "").replace("/", "").replace("-", "");

					estabelecimento.setCnpjEstabelecimento(cpfCnpj);
					estabelecimento.setCnpjEmpresa(cpfCnpjEmpresa);
					estabelecimento.setNomeFantasiaEstabelecimento(row.getCell(3).getStringCellValue());
					estabelecimento.setRazaoSocialEstabelecimento(row.getCell(3).getStringCellValue());
					estabelecimento.setUf(row.getCell(6).getStringCellValue());

					// System.out.println(empresa.getnpj() + "-" + empresa.getEmail()); ;

				}

				estabelecimentos.add(estabelecimento);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return estabelecimentos;
	}

}
