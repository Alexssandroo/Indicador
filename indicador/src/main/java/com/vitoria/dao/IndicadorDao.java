package com.vitoria.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import com.vitoria.model.Indicador;
import com.vitoria.util.JPAUtil;

public class IndicadorDao {
	public List<Indicador> lista() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.createQuery("select u from Indicador u", Indicador.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}
	
	public void adiciona(Indicador indicador) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(indicador);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void atualiza(Indicador indicador) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(indicador);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void remove(Indicador indicador) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(manager.merge(indicador));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public Indicador busca(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.find(Indicador.class, id);
		} finally {
			manager.close();
		}
	}
	
	public Indicador buscaPor(String nome, String funcao) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select u from Indicador u "
									+ "where u.nome = :nome and u.funcao = :funcao", Indicador.class)
					.setParameter("nome", nome)
					.setParameter("funcao", funcao)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			manager.close();
		}
	}



}
