package com.jornada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jornada.models.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{

}
