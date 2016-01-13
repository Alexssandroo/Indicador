package com.vitoria.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.vitoria.dao.GrupoDao;
import com.vitoria.dao.IndicadorDao;
import com.vitoria.dao.IndicadorPorGrupoDao;
import com.vitoria.model.Grupo;
import com.vitoria.model.Indicador;
import com.vitoria.model.IndicadorPorGrupo;

@ManagedBean
@ViewScoped
public class RelacionaGrupoIndicadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Grupo> grupos;
	private List<Indicador> indicadores;
	private IndicadorPorGrupo indicadorPorGrupo;
	
	@PostConstruct
	public void init(){
		this.indicadorPorGrupo = new IndicadorPorGrupo();
		this.indicadorPorGrupo.setGrupo(new Grupo());
		this.indicadorPorGrupo.setIndicador(new Indicador());
	}
	
	public void adiciona(){
		IndicadorPorGrupoDao dao = new IndicadorPorGrupoDao();
		dao.adiciona(indicadorPorGrupo);		
	}
	public List<Grupo> getGrupos() {
		if(grupos==null){
			GrupoDao grupoDao = new GrupoDao();
			this.grupos = grupoDao.lista();
		}
		return grupos;
	}
	
	public List<Indicador> getIndicadores() {
		if(indicadores==null){
			IndicadorDao dao = new IndicadorDao();
			this.indicadores = dao.lista();
		}
		return indicadores;
	}
	public IndicadorPorGrupo getIndicadorPorGrupo() {
		return indicadorPorGrupo;
	}
	
	
	

}
