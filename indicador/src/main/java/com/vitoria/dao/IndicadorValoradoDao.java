package com.vitoria.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import com.vitoria.model.IndicadorValorado;
import com.vitoria.util.JPAUtil;

public class IndicadorValoradoDao {
		
		public List<IndicadorValorado> lista() {
			EntityManager manager = new JPAUtil().getEntityManager();
			try {
				return manager.createQuery("select u from IndicadorValorado u", IndicadorValorado.class)
						.getResultList();
			} finally {
				manager.close();
			}
		}
		
		public void adiciona(IndicadorValorado indicadorValorado) {
			EntityManager manager = new JPAUtil().getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(indicadorValorado);
				transaction.commit();
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} finally {
				manager.close();
			}
		}
		
		public void atualiza(IndicadorValorado indicadorValorado) {
			EntityManager manager = new JPAUtil().getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.merge(indicadorValorado);
				transaction.commit();
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} finally {
				manager.close();
			}
		}
		
		public void remove(IndicadorValorado indicadorValorado) {
			EntityManager manager = new JPAUtil().getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.remove(manager.merge(indicadorValorado));
				transaction.commit();
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
			} finally {
				manager.close();
			}
		}
		
		public IndicadorValorado busca(Integer id) {
			EntityManager manager = new JPAUtil().getEntityManager();
			try {
				return manager.find(IndicadorValorado.class, id);
			} finally {
				manager.close();
			}
		}
		
		public IndicadorValorado buscaPor(String nome, String funcao) {
			EntityManager manager = new JPAUtil().getEntityManager();
			try {
				return manager
						.createQuery(
								"select u from IndicadorValorado u "
										+ "where u.nome = :nome and u.funcao = :funcao", IndicadorValorado.class)
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
	
	

