package com.vitoria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="oco_ocorrencia")
public class Ocorrencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date dataOcorrencia;
	private Funcionario funcionario;
	private TipoOcorrencia ocorrencia;
	private String observacao;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	@ManyToOne
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@Enumerated(EnumType.STRING)
	public TipoOcorrencia getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(TipoOcorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	@Column(length=1000)
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
 	

}
