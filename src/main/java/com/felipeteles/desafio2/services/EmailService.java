package com.felipeteles.desafio2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeteles.desafio2.domain.Email;
import com.felipeteles.desafio2.repositories.EmailRepository;

@Service
public class EmailService {
	@Autowired
	private EmailRepository emailRepository;
	
	public List<Email> findAll( ) {
		return emailRepository.findAll();
	}
}
