package com.vitoria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import com.vitoria.model.IndicadorPorGrupo;
import com.vitoria.util.JPAUtil;

public class IndicadorPorGrupoDao {
	
	public List<IndicadorPorGrupo> lista() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.createQuery("select u from IndicadorPorGrupo u", IndicadorPorGrupo.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}
	
	public void adiciona(IndicadorPorGrupo indicadorPorGrupo) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(indicadorPorGrupo);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void atualiza(IndicadorPorGrupo indicadorPorGrupo) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(indicadorPorGrupo);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void remove(IndicadorPorGrupo indicadorPorGrupo) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(manager.merge(indicadorPorGrupo));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public IndicadorPorGrupo busca(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.find(IndicadorPorGrupo.class, id);
		} finally {
			manager.close();
		}
	}
	
	public IndicadorPorGrupo buscaPor(String nome, String funcao) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select u from IndicadorPorGrupo u "
									+ "where u.nome = :nome and u.funcao = :funcao", IndicadorPorGrupo.class)
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
