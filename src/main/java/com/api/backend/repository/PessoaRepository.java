package com.api.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Optional<Pessoa> listarPorCpf(String cpf);

}
