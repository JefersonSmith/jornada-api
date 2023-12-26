package com.jornada.services;

import java.util.List;

import com.jornada.models.Destino;

public interface DestinoService {
	
	List<Destino> getAllDestinos();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino destino);
	
	Destino updateDestino(Long id, Destino destinoUpdated);
	
	void deleteById(Long id);

}
