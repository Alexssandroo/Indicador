package com.vitoria.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ind_indicador")
public class Indicador implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private TipoIndicador tipoIndicador;
	private TipoAplicacaoIndicador tipoAplicacaoIndicador;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Enumerated(EnumType.STRING)
	public TipoIndicador getTipoIndicador() {
		return tipoIndicador;
	}
	public void setTipoIndicador(TipoIndicador tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}
	@Enumerated(EnumType.STRING)
	public TipoAplicacaoIndicador getTipoAplicacaoIndicador() {
		return tipoAplicacaoIndicador;
	}
	public void setTipoAplicacaoIndicador(TipoAplicacaoIndicador tipoAplicacaoIndicador) {
		this.tipoAplicacaoIndicador = tipoAplicacaoIndicador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Indicador other = (Indicador) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
