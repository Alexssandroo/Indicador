package com.vitoria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.HibernateException;

import com.vitoria.dao.IndicadorDao;
import com.vitoria.model.Indicador;
import com.vitoria.model.TipoAplicacaoIndicador;
import com.vitoria.model.TipoIndicador;
import com.vitoria.util.FacesUtils;

@ManagedBean
@ViewScoped
public class IndicadorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Indicador indicador;
	

	private List<Indicador> indicadores;
	
	@PostConstruct
	public void init(){
		this.indicador = new Indicador();
		this.indicadores = new ArrayList<Indicador>();
	}
	
	public void limpa(){
		this.indicador = new Indicador();
	}
	
	public void adiciona(){
		IndicadorDao dao = new IndicadorDao();
		dao.adiciona(this.indicador);
		this.limpa();
	}
	
	public void edita(Indicador indicador){
		IndicadorDao dao = new IndicadorDao();
		try{
			dao.atualiza(indicador);
			new FacesUtils().adcionaMensagemSucesso("Indicador atualizado com sucesso !");	
			
		}catch(HibernateException e ){
			new FacesUtils().adcionaMensagemErro("Erro ao atualizar, verificar log");
		}
		
		
	}
	
	public void remove(Indicador indicador){
		IndicadorDao dao = new IndicadorDao();
		dao.remove(indicador);
		this.indicadores = dao.lista();
		this.limpa();
	}
	
	public void lista(){
		IndicadorDao dao = new IndicadorDao();
		this.indicadores = dao.lista();
	}
	
	public List<TipoIndicador> getTipoIndicador() {
		return Arrays.asList(TipoIndicador.values());
	}
	public List<TipoAplicacaoIndicador> getTipoAplicaIndicador() {
		return Arrays.asList(TipoAplicacaoIndicador.values());
	}


	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	
	
}
