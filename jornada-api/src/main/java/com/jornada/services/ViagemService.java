package com.jornada.services;

import java.util.List;

import com.jornada.models.Viagem;

public interface ViagemService {
    Viagem salvarViagem(Viagem viagem);
    List<Viagem> listarViagens();
    Viagem obterViagemPorId(Long id);
	Viagem editarViagem(Long id, Viagem viagemUpdated);

    void excluirViagem(Long id);
}

