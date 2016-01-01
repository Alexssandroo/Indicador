package com.vitoria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.vitoria.dao.GrupoDao;
import com.vitoria.model.Grupo;
import com.vitoria.util.FacesUtils;

@ManagedBean
@ViewScoped
public class GrupoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Grupo grupo ;

	private List<Grupo> grupos ;
	
	
	public void novo(){
		grupo = new Grupo();
	}
	
	public GrupoBean() {
		this.grupo = new Grupo();
		this.grupos = new ArrayList<Grupo>();
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	

	
	public void adiciona(){
		GrupoDao dao = new GrupoDao();
		dao.adiciona(this.grupo);
		this.grupo = new Grupo();
		new FacesUtils().adcionaMensagemSucesso("Grupo adicionado com sucesso !");
		
	}
	public void lista(){
		GrupoDao dao = new GrupoDao();
		this.grupos = dao.lista();
	}
	
	public void remover(Grupo grupo){
		GrupoDao dao = new GrupoDao();
		dao.remove(grupo);
		this.grupos = dao.lista();
		new FacesUtils().adcionaMensagemSucesso("Grupo removido com sucesso !");
		
	}
	
	public void edita(){
		GrupoDao dao = new GrupoDao();
		dao.atualiza(grupo);
		new FacesUtils().adcionaMensagemSucesso("Grupo atualizado com sucesso !");		
		
	}
	

}
