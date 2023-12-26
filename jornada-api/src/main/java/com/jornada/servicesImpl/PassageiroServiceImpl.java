package com.jornada.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jornada.models.Passageiro;

import com.jornada.repositories.PassageiroRepository;
import com.jornada.services.PassageiroService;

@Service
public class PassageiroServiceImpl implements PassageiroService{
	
	@Autowired
	private PassageiroRepository pr;

	@Override
	public List<Passageiro> getAllPassageiros() {

		return pr.findAll();
	}

	@Override
	public Passageiro getPassageiroById(Long id) {

		return pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Passageiro savePassageiro(Passageiro passageiro) {

		return pr.save(passageiro);
	}

	@Override
	public Passageiro updatePassageiro(Long id, Passageiro passageiroUpdated) {
		Passageiro passageiroExists = pr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		passageiroExists.setNome(passageiroUpdated.getNome());

		return pr.save(passageiroExists);
	}

	@Override
	public void deleteById(Long id) {
		pr.deleteById(id);

	}


}
