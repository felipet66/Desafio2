package com.felipeteles.desafio2.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeteles.desafio2.domain.Email;
import com.felipeteles.desafio2.repositories.EmailRepository;

@Service
public class DBService {
	
	@Autowired
	private EmailRepository emailRepository;

	public void instantiateDatabase() throws ParseException, IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Email email1 = new Email(sdf.parse("18/02/2018 17:00"), "MANUAL", "Testando inserção");
		Email email2 = new Email(sdf.parse("15/04/2018 16:00"), "MANUAL", "Testando Novamente");
		Email email3 = new Email(sdf.parse("15/04/2018 16:00"), "MANUAL", "Mais testes");
		
		//GmailApiQuickStart gmail = new GmailApiQuickStart();
		//gmail.buscar();
		
		emailRepository.saveAll(Arrays.asList(email1, email2, email3));
	}
	
}
