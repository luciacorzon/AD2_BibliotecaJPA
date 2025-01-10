package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    public static final String UNIDAD_PERSISTENCIA = "Biblioteca-JPA";

    private static EntityManagerUtil entityManagerUtil;
    private EntityManagerFactory enFactory;

    private EntityManagerUtil(EntityManagerFactory enFactory) {
        this.enFactory = enFactory;
    }

    public static EntityManagerUtil getEnFactory(String unidadPersistencia) {
        if (entityManagerUtil == null) {
            synchronized (EntityManagerFactory.class){
                if(entityManagerUtil == null) {
                    EntityManagerFactory enFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
                    entityManagerUtil = new EntityManagerUtil(enFactory);
                }
            }
        }
        return entityManagerUtil;
    }
}
