package com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jornada.models.Passageiro;
import com.jornada.services.PassageiroService;

@CrossOrigin(origins = "http://localhost:3000/")


@RestController
@RequestMapping("/passageiro")
public class PassageiroController {
	
	@Autowired
	private PassageiroService ps;

	@PostMapping("/savepassageiro")
	public Passageiro createPassageiro(@RequestBody Passageiro passageiro) {

		return ps.savePassageiro(passageiro);
	}

	@GetMapping("/allpassageiros")
	public List<Passageiro> getAllPassageiros() {

		return ps.getAllPassageiros();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Passageiro> getPassageiroById(@PathVariable Long id) {
		Passageiro passageiro = ps.getPassageiroById(id);

		return ResponseEntity.ok(passageiro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Passageiro> updatePassageiro(@PathVariable Long id, @RequestBody Passageiro passageiroUpdated) {
		Passageiro passageiro = ps.getPassageiroById(id);

		passageiro.setNome(passageiroUpdated.getNome());

		ps.savePassageiro(passageiro);

		return ResponseEntity.ok(passageiro);
	}

	@DeleteMapping("/{id}")
	public void deletePassageiro(@PathVariable Long id) {
		ps.deleteById(id);
	}



}
