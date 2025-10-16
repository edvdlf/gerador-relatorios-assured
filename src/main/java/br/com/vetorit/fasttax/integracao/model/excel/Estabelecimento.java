package br.com.vetorit.fasttax.integracao.model.excel;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class Estabelecimento {

	
	private UUID id;
	
	
	private UUID idEmpresa;
	
	private String codigoEmpresa;
	private String codigoEstabelecimento;
	private String cnpjEmpresa;
	private String cnpjEstabelecimento;
	private String razaoSocialEstabelecimento;
	private String nomeFantasiaEstabelecimento;
	private String uf;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(UUID idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public String getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(String codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCnpjEstabelecimento() {
		return cnpjEstabelecimento;
	}
	public void setCnpjEstabelecimento(String cnpjEstabelecimento) {
		this.cnpjEstabelecimento = cnpjEstabelecimento;
	}
	public String getRazaoSocialEstabelecimento() {
		return razaoSocialEstabelecimento;
	}
	public void setRazaoSocialEstabelecimento(String razaoSocialEstabelecimento) {
		this.razaoSocialEstabelecimento = razaoSocialEstabelecimento;
	}
	public String getNomeFantasiaEstabelecimento() {
		return nomeFantasiaEstabelecimento;
	}
	public void setNomeFantasiaEstabelecimento(String nomeFantasiaEstabelecimento) {
		this.nomeFantasiaEstabelecimento = nomeFantasiaEstabelecimento;
	}
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
	
	
	
}
