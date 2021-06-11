package com.reciclaveis.api.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reciclaveis.api.model.Usuarios;
import com.reciclaveis.api.repository.UsuariosRepository;

@Service
	public class UserDetailsServiceImpl implements UserDetailsService {
		
		 
		@Autowired
		private UsuariosRepository usuarioRepository;
		
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			Optional<Usuarios> user = usuarioRepository.findByCpfOuCnpj(userName);
			user.orElseThrow(()-> new UsernameNotFoundException(userName + "not found."));
			
			return user.map(UserDetailsImpl:: new ).get();
		}

	}
