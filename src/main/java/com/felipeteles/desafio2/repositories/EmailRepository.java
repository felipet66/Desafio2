package com.felipeteles.desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipeteles.desafio2.domain.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{
	
}
