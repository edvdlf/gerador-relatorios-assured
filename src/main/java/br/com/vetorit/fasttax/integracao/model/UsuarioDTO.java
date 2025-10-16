package br.com.vetorit.fasttax.integracao.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private UUID id;
	private UUID idTennant;
	private UUID idPerfil;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;
	private  OffsetDateTime ultimoAcesso;
	
	
}


