package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
