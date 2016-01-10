package com.vitoria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.vitoria.dao.FuncionarioDao;
import com.vitoria.dao.OcorrenciaDao;
import com.vitoria.model.Funcionario;
import com.vitoria.model.Ocorrencia;
import com.vitoria.model.TipoOcorrencia;

@ManagedBean
@ViewScoped
public class OcorrenciaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Ocorrencia ocorrencia;
	private List<Ocorrencia> ocorrencias;
	private List<Funcionario> funcionarios;
	
	@PostConstruct
	public void init(){
		this.ocorrencia = new Ocorrencia();
		this.ocorrencia.setFuncionario(new Funcionario());
	}
	
	public void limpar(){
		this.ocorrencia = new Ocorrencia();
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public void lista(){
		OcorrenciaDao dao = new OcorrenciaDao();
		this.ocorrencias = dao.lista();
	}
	
	public List<TipoOcorrencia> getTodoTipo() {
		return Arrays.asList(TipoOcorrencia.values());
	}
	public void adiciona(){
		OcorrenciaDao dao = new OcorrenciaDao();
		dao.adiciona(this.ocorrencia);
		this.limpar();
	}
	
	public void remover(Ocorrencia ocorrencia){
		OcorrenciaDao dao = new OcorrenciaDao();
		dao.remove(ocorrencia);
		this.ocorrencias = dao.lista();
		this.limpar();
	}
	
	public List<Funcionario> getFuncionarios() {
		if(funcionarios==null){
			FuncionarioDao dao= new FuncionarioDao();
			this.funcionarios = dao.lista();
		}
		return funcionarios;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	
	
	
	

}
