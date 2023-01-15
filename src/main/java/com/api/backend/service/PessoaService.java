package com.api.backend.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.backend.dto.PessoaDTO;
import com.api.backend.entity.Pessoa;
import com.api.backend.repository.PessoaRepository;
import com.api.backend.service.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private ModelMapper mapper;

	public Pessoa salvar(PessoaDTO obj) {
		return repository.save(mapper.map(obj, Pessoa.class));

	}

	public Pessoa listarPorId(Long id) {
		var obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return obj;

	}

	public List<Pessoa> listar() {
		return repository.findAll();
	}

	public Pessoa atualizar(PessoaDTO obj) {
		
		return repository.save(mapper.map(obj, Pessoa.class));

	}

	public void apaga(Long id) {
		var obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		repository.delete(obj);
	}

}
