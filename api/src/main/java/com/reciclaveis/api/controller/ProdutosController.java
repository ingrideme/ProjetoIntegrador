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

import com.reciclaveis.api.model.Produtos;
import com.reciclaveis.api.model.Usuarios;
import com.reciclaveis.api.repository.ProdutosRepository;
import com.reciclaveis.api.repository.UsuariosRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutosController {

		//Importar o repositorio Jpa criado
		@Autowired
		private ProdutosRepository produtosRepository;
		
		@GetMapping
		public ResponseEntity<List<Produtos>> pegarProdutos(){
			return ResponseEntity.ok(produtosRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Produtos> GetById(@PathVariable Long id){
			return produtosRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping
		public ResponseEntity<Produtos> post (@RequestBody Produtos produto)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
		}

		@PutMapping
		public ResponseEntity<Produtos> put (@RequestBody Produtos produto)
		{
			return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			produtosRepository.deleteById(id);
		}
}
