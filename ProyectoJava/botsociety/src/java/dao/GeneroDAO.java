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
import modelo.Genero;

/**
 *
 * @author benja
 */
public class GeneroDAO {
      private Genero p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsocietyPU";
     
    public boolean Crear(Genero genero) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(genero);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public Genero Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(Genero.class, id);

        if (p.getIdGenero()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(Genero.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<Genero> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT g FROM Genero g");
        ArrayList<Genero> generos =  new ArrayList<>(q.getResultList());        
        return generos;
    }
}
