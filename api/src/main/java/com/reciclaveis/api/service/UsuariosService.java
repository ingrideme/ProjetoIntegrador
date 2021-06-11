package com.reciclaveis.api.service;
import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reciclaveis.api.model.Usuarios;
import com.reciclaveis.api.model.UsuariosLogin;
import com.reciclaveis.api.repository.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository repository;

	
	//Método para encriptar a senhar antes de salvá-la
	public Optional<Usuarios> CadastraUsuario(Usuarios usuario) {
		
		Optional<Usuarios> usuarioExistente = repository.findByCpfOuCnpj(usuario.getCpfOuCnpj());
		
		
		if(usuarioExistente.isPresent()) {
			return Optional.empty();
		}else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEnconder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEnconder);
			
			return Optional.ofNullable(repository.save(usuario));
		}
		
	}
	
	public Optional<UsuariosLogin>Logar(Optional<UsuariosLogin>user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuarios> usuario = repository.findByCpfOuCnpj(user.get().getCpfOuCnpj());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(),usuario.get().getSenha())) {
				//Se as duas senhas forem iguais ele retorna elas
				
				String auth = user.get().getCpfOuCnpj()+":"+user.get().getSenha();
				byte[] encondeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic "+new String(encondeAuth);
				
				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				user.get().setCpfOuCnpj(usuario.get().getCpfOuCnpj());
				user.get().setNomeFisOuJuri(usuario.get().getNomeFisOuJuri());

				
				return user;
			}
		}
		return null;
	}
}