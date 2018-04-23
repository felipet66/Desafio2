package com.felipeteles.desafio2.dto;

import java.io.Serializable;
import java.util.Date;

import com.felipeteles.desafio2.domain.Email;

public class EmailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Date dateMail;
	private String origemMail;
	private String assuntoMail;
	
	public EmailDTO() {
		
	}
	
	public EmailDTO(Email obj) {
		id = obj.getId();
		dateMail = obj.getDateMail();
		origemMail = obj.getOrigem();
		assuntoMail = obj.getAssunto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateMail() {
		return dateMail;
	}

	public void setDateMail(Date dateMail) {
		this.dateMail = dateMail;
	}

	public String getOrigemMail() {
		return origemMail;
	}

	public void setOrigemMail(String origemMail) {
		this.origemMail = origemMail;
	}

	public String getAssuntoMail() {
		return assuntoMail;
	}

	public void setAssuntoMail(String assuntoMail) {
		this.assuntoMail = assuntoMail;
	}
	
}
