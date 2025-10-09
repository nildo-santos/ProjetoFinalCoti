package br.com.nildoSantos.application.controllers;
import br.com.nildoSantos.domain.dtos.request.ClienteRequest;
import br.com.nildoSantos.domain.dtos.response.ClienteResponse;


import br.com.nildoSantos.domain.interfaces.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    private final ClienteService clienteService;


    @GetMapping
	public ResponseEntity<List<ClienteResponse>> get() {
       List<ClienteResponse> response = clienteService.readAll();
	   return ResponseEntity.status(HttpStatus.OK).body(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> getId(@PathVariable UUID id) {
        ClienteResponse response = clienteService.readById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<ClienteResponse> post(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.create(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponse> put(@PathVariable UUID id, @Valid @RequestBody ClienteRequest clienteRequest) {
         clienteService.update(id, clienteRequest);

      return ResponseEntity.status(HttpStatus.OK).body(clienteService.readById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteResponse> delete(@PathVariable UUID id) {
    clienteService.delete(id);

    return ResponseEntity.status(HttpStatus.OK).body(clienteService.readById(id));
	}

}
