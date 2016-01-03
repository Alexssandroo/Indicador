package com.vitoria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.vitoria.dao.FuncaoDao;
import com.vitoria.model.Funcao;
import com.vitoria.util.FacesUtils;

@ManagedBean
@ViewScoped
public class FuncaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Funcao funcao;
	private List<Funcao> funcoes;
	
	
	public void novo(){
		funcao = new Funcao();
	}
	
	public FuncaoBean() {
		this.funcao = new Funcao();
		this.funcoes = new ArrayList<Funcao>();
	}
	
	public void adiciona(){
		FuncaoDao dao = new FuncaoDao();
		dao.adiciona(this.funcao);
		this.funcao = new Funcao();
		new FacesUtils().adcionaMensagemSucesso("Função adicionada com sucesso !");
		
	}
	public void lista(){
		FuncaoDao dao = new FuncaoDao();
		this.funcoes = dao.lista();
	}
	
	public void remover(Funcao funcao){
		FuncaoDao dao = new FuncaoDao();
		dao.remove(funcao);
		this.funcoes = dao.lista();
		new FacesUtils().adcionaMensagemSucesso("Função removida com sucesso !");
		
	}
	
	public void edita(){
		FuncaoDao dao = new FuncaoDao();
		dao.atualiza(funcao);
		new FacesUtils().adcionaMensagemSucesso("Função atualizada com sucesso !");		
		
	}

	public Funcao getFuncao() {
		return funcao;
		
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	
	

	
	

}
