package br.com.nildoSantos.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {


	@GetMapping
	public void get() {

	}

	@GetMapping("/{Id}")
	public void getId() {

	}

	@PostMapping
	public void post() {

	}

	@PutMapping
	public void put() {

	}

	@DeleteMapping
	public void delete() {

	}

}
