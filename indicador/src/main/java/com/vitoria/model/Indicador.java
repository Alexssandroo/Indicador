package com.vitoria.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ind_indicador")
public class Indicador implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nome;	
	private Date dataValidade;
	private TipoIndicador tipoIndicador;
	private TipoAplicacaoIndicador tipoAplicacaoIndicador;
	
	
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
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public TipoIndicador getTipoIndicador() {
		return tipoIndicador;
	}
	public void setTipoIndicador(TipoIndicador tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}
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
		result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoAplicacaoIndicador == null) ? 0 : tipoAplicacaoIndicador.hashCode());
		result = prime * result + ((tipoIndicador == null) ? 0 : tipoIndicador.hashCode());
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
		if (dataValidade == null) {
			if (other.dataValidade != null)
				return false;
		} else if (!dataValidade.equals(other.dataValidade))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoAplicacaoIndicador != other.tipoAplicacaoIndicador)
			return false;
		if (tipoIndicador != other.tipoIndicador)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
