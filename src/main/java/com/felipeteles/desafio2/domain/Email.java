package com.felipeteles.desafio2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateMail;
	
	private String origemMail;
	private String assuntoMail;
	
	public Email() {
		
	}
	
	public Email(Date dateMail, String origemMail, String assuntoMail) {
		super();
		this.dateMail = dateMail;
		this.origemMail = origemMail;
		this.assuntoMail = assuntoMail;
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

	public String getOrigem() {
		return origemMail;
	}

	public void setOrigem(String origemMail) {
		this.origemMail = origemMail;
	}

	public String getAssunto() {
		return assuntoMail;
	}

	public void setAssunto(String assuntoMail) {
		this.assuntoMail = assuntoMail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [dateMail=");
		builder.append(dateMail);
		builder.append(", origemMail=");
		builder.append(origemMail);
		builder.append(", assuntoMail=");
		builder.append(assuntoMail);
		builder.append("]");
		return builder.toString();
	}
	
}
