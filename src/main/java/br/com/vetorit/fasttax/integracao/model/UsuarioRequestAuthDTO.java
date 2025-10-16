package br.com.vetorit.fasttax.integracao.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestAuthDTO {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
