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
import modelo.ControlEmpresa;

/**
 *
 * @author benja
 */
public class ControlEmpresaDAO {
      private ControlEmpresa p;
    private EntityManager em;
    EntityManagerFactory factory;
    
    static String nombre = "botsociety2PU";
     
    public boolean Crear(ControlEmpresa controlEmpresa) {      
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(controlEmpresa);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public ControlEmpresa Leer(int id) {
      factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        p = em.find(ControlEmpresa.class, id);

        if (p.getIdControlE()== null) {
            return null;
        } else {
            return p;
        }
    }

    public boolean Eliminar(int id) {
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        try{           
            em = factory.createEntityManager();
            p = em.find(ControlEmpresa.class, id);
            em.remove(p);
            em.flush();
            em.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    public ArrayList<ControlEmpresa> Listar(){           
        factory = Persistence.createEntityManagerFactory(nombre, System.getProperties());
        em = factory.createEntityManager();
        
        javax.persistence.Query q = em.createQuery("SELECT c FROM ControlEmpresa c");
        ArrayList<ControlEmpresa> controlEmpresas =  new ArrayList<>(q.getResultList());        
        return controlEmpresas;
    }
}
