/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.NivelEstudio;

/**
 *
 * @author benja
 */
public class NivelEstudioDAO {
      private NivelEstudio p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsocietyPU";
     
    public boolean Crear(NivelEstudio nivelEstudio) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nivelEstudio);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public NivelEstudio Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(NivelEstudio.class, id);

        if (p.getIdNivelE()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(NivelEstudio.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<NivelEstudio> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT n FROM NivelEstudio n");
        ArrayList<NivelEstudio> nivelEstudios =  new ArrayList<>(q.getResultList());        
        return nivelEstudios;
    }
}
