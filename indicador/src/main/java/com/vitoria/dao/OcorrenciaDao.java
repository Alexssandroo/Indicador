package com.vitoria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import com.vitoria.model.Ocorrencia;
import com.vitoria.util.JPAUtil;

public class OcorrenciaDao {
	
	public List<Ocorrencia> lista() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.createQuery("select u from Ocorrencia u", Ocorrencia.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}
	
	public void adiciona(Ocorrencia Ocorrencia) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(Ocorrencia);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void atualiza(Ocorrencia Ocorrencia) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(Ocorrencia);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public void remove(Ocorrencia Ocorrencia) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(manager.merge(Ocorrencia));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}
	
	public Ocorrencia busca(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.find(Ocorrencia.class, id);
		} finally {
			manager.close();
		}
	}
	
	public Ocorrencia buscaPor(String nome, String funcao) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select u from Ocorrencia u "
									+ "where u.nome = :nome and u.funcao = :funcao", Ocorrencia.class)
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
