package com.vitoria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("indicador_pu");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
