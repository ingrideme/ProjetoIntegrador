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

	public Usuarios CadastrarUsuario(Usuarios usuarios) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuarios.getSenha());
		usuarios.setSenha(senhaEncoder);

		return repository.save(usuarios);
	}

	public Optional<UsuariosLogin> Logar(Optional<UsuariosLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuarios> usuario = repository.findByCpfOuCnpj(user.get().getCpfOuCnpj());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getCpfOuCnpj() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);				
				user.get().setNomeFisOuJuri(usuario.get().getNomeFisOuJuri());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			}
		}
		return null;
	}

}