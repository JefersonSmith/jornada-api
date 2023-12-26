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

import com.jornada.models.Destino;
import com.jornada.services.DestinoService;

@CrossOrigin(origins = "http://localhost:3000/")


@RestController
@RequestMapping("/destino")
public class DestinoController {
	
	@Autowired
	private DestinoService ps;

	@PostMapping("/savedestino")
	public Destino createDestino(@RequestBody Destino destino) {

		return ps.saveDestino(destino);
	}

	@GetMapping("/alldestinos")
	public List<Destino> getAllDestinos() {

		return ps.getAllDestinos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = ps.getDestinoById(id);

		return ResponseEntity.ok(destino);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoUpdated) {
		Destino destino = ps.getDestinoById(id);

		destino.setCidade(destinoUpdated.getCidade());

		ps.saveDestino(destino);

		return ResponseEntity.ok(destino);
	}

	@DeleteMapping("/{id}")
	public void deleteDestino(@PathVariable Long id) {
		ps.deleteById(id);
	}


	

}
