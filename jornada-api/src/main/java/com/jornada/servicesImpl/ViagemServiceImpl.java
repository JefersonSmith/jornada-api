package com.jornada.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jornada.models.Passageiro;
import com.jornada.models.Viagem;
import com.jornada.repositories.ViagemRepository;
import com.jornada.services.ViagemService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ViagemServiceImpl implements ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;
    
    @Override
    public List<Viagem> listarViagens() {
        return viagemRepository.findAll();
    }
    
    @Override
    public Viagem obterViagemPorId(Long id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viagem não encontrada com o ID: " + id));
    }


    @Override
    public Viagem salvarViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }


	@Override
	public Viagem editarViagem(Long id, Viagem viagemUpdated) {
		Viagem viagemExists = viagemRepository.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		viagemExists.setId(viagemUpdated.getId());

		return viagemRepository.save(viagemExists);
	}
    
    @Override
    public void excluirViagem(Long id) {
        viagemRepository.deleteById(id);
    }
}
