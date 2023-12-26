package com.jornada.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jornada.models.Destino;
import com.jornada.repositories.DestinoRepository;
import com.jornada.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {
	
	@Autowired
	private DestinoRepository pr;

	@Override
	public List<Destino> getAllDestinos() {

		return pr.findAll();
	}

	@Override
	public Destino getDestinoById(Long id) {

		return pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Destino saveDestino(Destino destino) {

		return pr.save(destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino destinoUpdated) {
		Destino destinoExists = pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		destinoExists.setCidade(destinoUpdated.getCidade());

		return pr.save(destinoExists);
	}

	@Override
	public void deleteById(Long id) {
		pr.deleteById(id);

	}


}
