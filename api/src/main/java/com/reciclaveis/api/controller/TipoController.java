package com.reciclaveis.api.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reciclaveis.api.model.Tipo;
import com.reciclaveis.api.repository.TipoRepository;



@RestController
@RequestMapping("/tipo")
@CrossOrigin("*")
public class TipoController {

	@Autowired
	private TipoRepository tipoRepository;
	
	@GetMapping
	public List<Tipo> listar(){
		return tipoRepository.findAll();	
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Tipo adicionarTipo(@RequestBody Tipo tipo)
	{
		return tipoRepository.save(tipo); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo> GetById(@PathVariable Long id)
	{
		return tipoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping()
	public ResponseEntity<Tipo> put (@RequestBody Tipo tipo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(tipoRepository.save(tipo));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		tipoRepository.deleteById(id);
	}
}