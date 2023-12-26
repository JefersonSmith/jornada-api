package com.jornada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jornada.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}
