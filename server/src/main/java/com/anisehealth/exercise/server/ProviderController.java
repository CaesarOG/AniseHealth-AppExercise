package com.anisehealth.exercise.server;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anisehealth.exercise.server.models.Provider;
import com.anisehealth.exercise.server.services.ProviderService;

@RestController
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	private static final String GREETING_TPL = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@GetMapping("/provider/greet")
	public String index(@RequestParam(value = "name", defaultValue="Neeraj") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(GREETING_TPL, name)).toString();
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@GetMapping("/provider/all")
	public List<Provider> getAllProviders() {
		return providerService.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/provider/search")
	public List<Provider> getProvidersByName(@RequestBody Provider provider) {
		return providerService.findByFields(provider);
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/provider/create")
	public ResponseEntity<Provider> postMethodName(@RequestBody Provider provider) {
		try {
			providerService.save(provider); 
		} catch (org.springframework.dao.DataIntegrityViolationException e) { 
			return new ResponseEntity<>(provider, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(provider, HttpStatus.OK);
	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/provider/login")
	public ResponseEntity<Provider> login(@RequestBody LoginRequest loginRequest) {
		Provider p = providerService.login(loginRequest.getUsername());
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (!p.verifyPassword(loginRequest.getPassword())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);

	}

	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80"})
	@PostMapping("/provider/filter")
	public List<Provider> filter(@RequestBody Provider provider) {
		return providerService.filterByFields(provider);
	}
	

	// @GetMapping("/provider/search")
	// public List<Provider> getProvidersByName(@RequestParam(value = "name") String name) {
	// 	return providerService.findByName(name);
	// }

}

class LoginRequest {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
