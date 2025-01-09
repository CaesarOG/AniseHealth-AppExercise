package com.anisehealth.exercise.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anisehealth.exercise.server.models.Client;
import com.anisehealth.exercise.server.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@GetMapping("/client/all")
	public List<Client> getAll() {
		return clientService.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/client/create")
	public ResponseEntity<Client> postMethodName(@RequestBody Client client) {
		try { 
			clientService.save(client); 
		} catch (org.springframework.dao.DataIntegrityViolationException e) { 
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/client/login")
	public ResponseEntity<Client> login(@RequestBody LoginRequest loginRequest) {
		Client c = clientService.login(loginRequest.getUsername());
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (!c.verifyPassword(loginRequest.getPassword())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);

	}

}
