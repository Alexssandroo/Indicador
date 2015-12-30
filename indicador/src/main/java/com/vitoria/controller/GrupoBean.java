package com.vitoria.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vitoria.dao.GrupoDao;
import com.vitoria.model.Grupo;

@ManagedBean
@SessionScoped
public class GrupoBean {

	private Grupo grupo ;

	private List<Grupo> grupos ;
	
	
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
		dao.adiciona(grupo);
		this.grupo = new Grupo();
		
	}
	
	
	

}
