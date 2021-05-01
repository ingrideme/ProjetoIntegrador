package com.reciclaveis.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclaveis.api.model.Usuarios;
import com.reciclaveis.api.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {
	
	//Importar o repositorio Jpa criado
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> pegarUsuarios(){
		return ResponseEntity.ok(usuariosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> GetById(@PathVariable Long id){
		return usuariosRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> post (@RequestBody Usuarios usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosRepository.save(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuarios> put (@RequestBody Usuarios usuario)
	{
		return ResponseEntity.status(HttpStatus.OK).body(usuariosRepository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		usuariosRepository.deleteById(id);
	}
	
	
	
}
