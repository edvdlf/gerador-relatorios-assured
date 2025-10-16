package br.com.vetorit.fasttax.integracao.model;

import br.com.vetorit.fasttax.integracao.enums.TipoUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestRegisterDTO {
	
	private String name;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private String cpfCnpj;
	private String cep;
	private String endereco;
	private String cidade;
	private String estado;
	private String accountNonLocked;
	private String uf;
	Boolean onPremise;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(String accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getOnPremise() {
		return onPremise;
	}
	public void setOnPremise(Boolean onPremise) {
		this.onPremise = onPremise;
	}

	
}
