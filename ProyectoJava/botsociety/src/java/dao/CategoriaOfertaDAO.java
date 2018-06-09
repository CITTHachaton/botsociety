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
import modelo.CategoriaOferta;

/**
 *
 * @author benja
 */
public class CategoriaOfertaDAO {
     private CategoriaOferta p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsocietyPU";
     
    public boolean Crear(CategoriaOferta categoriaOferta) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoriaOferta);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public CategoriaOferta Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(CategoriaOferta.class, id);

        if (p.getIdCategoria()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(CategoriaOferta.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<CategoriaOferta> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT c FROM CategoriaOferta c");
        ArrayList<CategoriaOferta> categoriaOfertas =  new ArrayList<>(q.getResultList());        
        return categoriaOfertas;
    }
}
