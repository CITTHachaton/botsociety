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
import modelo.Persona;

/**
 *
 * @author benja
 */
public class PersonaDAO {
     private Persona p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsocietyPU";
     
    public boolean Crear(Persona persona) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public Persona Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(Persona.class, id);

        if (p.getIdPersona()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(Persona.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<Persona> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT p FROM Persona p");
        ArrayList<Persona> personas =  new ArrayList<>(q.getResultList());        
        return personas;
    }
}
