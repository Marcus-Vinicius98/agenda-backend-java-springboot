package com.api.backend.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.backend.dto.PessoaDTO;
import com.api.backend.entity.Pessoa;
import com.api.backend.repository.PessoaRepository;
import com.api.backend.service.exceptions.DataIntegrityViolationException;
import com.api.backend.service.exceptions.ObjectNotFoundException;

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
		listarPorCpf(obj);
		return repository.save(mapper.map(obj, Pessoa.class));

	}

	public void apaga(Long id) {
		var obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		repository.delete(obj);
	}

	public void listarPorCpf(PessoaDTO obj) {
		Optional<Pessoa> user = repository.listarPorCpf(obj.getCpf());
		if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
			throw new DataIntegrityViolationException("Objeto já cadastrado");
		}
	}

}
