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
import modelo.LikeGeneral;

/**
 *
 * @author benja
 */
public class LikeGeneralDAO {
      private LikeGeneral p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsocietyPU";
     
    public boolean Crear(LikeGeneral likeGeneral) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(likeGeneral);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public LikeGeneral Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(LikeGeneral.class, id);

        if (p.getIdLikeG()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(LikeGeneral.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<LikeGeneral> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT l FROM LikeGeneral l");
        ArrayList<LikeGeneral> likeGenerals =  new ArrayList<>(q.getResultList());        
        return likeGenerals;
    }
}
