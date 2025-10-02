package br.com.nildoSantos.application.controllers;
import br.com.nildoSantos.domain.dtos.ClienteRequest;
import br.com.nildoSantos.domain.dtos.ClienteResponse;
import br.com.nildoSantos.domain.services.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    private ClienteServiceImpl clienteService;;

	@GetMapping
	public void get() {

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> getId(UUID id) {
        ClienteResponse response = clienteService.readById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClienteResponse> post(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.create(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping
	public void put() {

	}

	@DeleteMapping
	public void delete() {

	}

}
