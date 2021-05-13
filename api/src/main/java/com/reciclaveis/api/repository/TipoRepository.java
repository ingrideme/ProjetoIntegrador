package com.reciclaveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reciclaveis.api.model.Tipo;

//Jpa é responsavel pela interação com o banco. Utilizando os verbos do CRUD 
//CRUD = create, read, update, delete
@Repository
//Tudo que a gente vai colocar é o modelo (Tipo e o tipo do ID)
public interface TipoRepository extends JpaRepository<Tipo, Long>{

	//Fazer um buscar por categoria(tipo)
}
