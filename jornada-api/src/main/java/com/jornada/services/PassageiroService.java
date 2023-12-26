package com.jornada.services;

import java.util.List;

import com.jornada.models.Passageiro;

public interface PassageiroService {
	
	List<Passageiro> getAllPassageiros();
	
	Passageiro getPassageiroById(Long id);
	
	Passageiro savePassageiro(Passageiro passageiro);
	
	Passageiro updatePassageiro(Long id, Passageiro passageiroUpdated);
	
	void deleteById(Long id);

}
