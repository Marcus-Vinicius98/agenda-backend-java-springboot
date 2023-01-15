package com.api.backend.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.dto.PessoaDTO;
import com.api.backend.service.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/agenda")
public class PessoaResource {

	@Autowired
	private PessoaService service;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ResponseEntity<PessoaDTO> salvar(@RequestBody @Valid PessoaDTO obj) {
		return ResponseEntity.ok().body(mapper.map(service.salvar(obj), PessoaDTO.class));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> ListarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(mapper.map(service.listarPorId(id), PessoaDTO.class));

	}

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listar() {
		return ResponseEntity.ok()
				.body(service.listar().stream().map(x -> mapper.map(x, PessoaDTO.class)).collect(Collectors.toList()));

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PessoaDTO obj) {
		obj.setId(id);

		return ResponseEntity.ok().body(mapper.map(service.atualizar(obj), PessoaDTO.class));

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> apagar(@PathVariable Long id) {
		service.apaga(id);
		return ResponseEntity.noContent().build();

	}

}
