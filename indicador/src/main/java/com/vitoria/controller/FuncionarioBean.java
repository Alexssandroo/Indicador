package com.vitoria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;

import com.vitoria.dao.FuncaoDao;
import com.vitoria.dao.FuncionarioDao;
import com.vitoria.dao.GrupoDao;
import com.vitoria.model.Funcao;
import com.vitoria.model.Funcionario;
import com.vitoria.model.Grupo;
import com.vitoria.util.FacesUtils;


@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Funcao> funcoes;
	private List<Grupo> grupos;
	
	public void novo(){
		funcionario = new Funcionario();
	}
		
	public void adiciona(){
		FuncionarioDao dao = new FuncionarioDao();
		try{
			dao.adiciona(this.funcionario);
			new FacesUtils().adcionaMensagemSucesso("Funcionario adicionado com sucesso !");
			this.limpar();			
		}catch(HibernateException e){
			new FacesUtils().adcionaMensagemErro("Erro ao adicionar");
		}		
	}
	@PostConstruct
	public void init() {
		this.funcionario = new Funcionario();
		this.funcionario.setFuncao(new Funcao());
		this.funcionario.setGrupo(new Grupo());
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public void limpar(){
		this.funcionario = new Funcionario();
		this.funcionario.setFuncao(new Funcao());
		this.funcionario.setGrupo(new Grupo());
		this.funcionarios = new ArrayList<Funcionario>();
		
	}
	
	public void lista(){
		FuncionarioDao dao = new FuncionarioDao();
		this.funcionarios = dao.lista();
	}
	
	public void remover(Funcionario funcionario){
		FuncionarioDao dao = new FuncionarioDao();
		try{
		dao.remove(funcionario);
		this.funcionarios = dao.lista();
		new FacesUtils().adcionaMensagemSucesso("Funcionario removido com sucesso !");
		}catch(HibernateException e){
			new FacesUtils().adcionaMensagemErro("Erro ao remover");
		}
		
	}
	
	public void edita(){
		FuncionarioDao dao = new FuncionarioDao();
		dao.atualiza(funcionario);
		new FacesUtils().adcionaMensagemSucesso("Função atualizada com sucesso !");		
		
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Funcao> getFuncoes() {
		if(funcoes==null){
			FuncaoDao funcaoDao= new FuncaoDao();
			this.funcoes = funcaoDao.lista();
		}
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

	public List<Grupo> getGrupos() {
		if(grupos==null){
			GrupoDao grupoDao = new GrupoDao();
			this.grupos = grupoDao.lista();
		}
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
    

	

}
