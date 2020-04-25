package br.com.iss53.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.iss53.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo, Long>{

}