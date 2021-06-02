package com.reciclaveis.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reciclaveis.api.model.Usuarios;

//Jpa é responsavel pela interação com o banco. Utilizando os verbos do CRUD 
// CRUD = create, read, update, delete
@Repository
//Tudo que a gente vai colocar é o modelo (Usuarios e o tipo do ID)
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	public Optional<Usuarios> findByCooperativa(String cooperativa);
	public Optional<Usuarios> findByCpfOuCnpj(String cpfOuCnpj);
}
