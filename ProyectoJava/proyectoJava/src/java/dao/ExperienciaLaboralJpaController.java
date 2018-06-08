/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import modelo.ExperienciaLaboral;

/**
 *
 * @author benja
 */
public class ExperienciaLaboralJpaController implements Serializable {

    public ExperienciaLaboralJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ExperienciaLaboral experienciaLaboral) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(experienciaLaboral);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ExperienciaLaboral experienciaLaboral) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            experienciaLaboral = em.merge(experienciaLaboral);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = experienciaLaboral.getIdExperienciaLaboral();
                if (findExperienciaLaboral(id) == null) {
                    throw new NonexistentEntityException("The experienciaLaboral with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ExperienciaLaboral experienciaLaboral;
            try {
                experienciaLaboral = em.getReference(ExperienciaLaboral.class, id);
                experienciaLaboral.getIdExperienciaLaboral();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The experienciaLaboral with id " + id + " no longer exists.", enfe);
            }
            em.remove(experienciaLaboral);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ExperienciaLaboral> findExperienciaLaboralEntities() {
        return findExperienciaLaboralEntities(true, -1, -1);
    }

    public List<ExperienciaLaboral> findExperienciaLaboralEntities(int maxResults, int firstResult) {
        return findExperienciaLaboralEntities(false, maxResults, firstResult);
    }

    private List<ExperienciaLaboral> findExperienciaLaboralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ExperienciaLaboral.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ExperienciaLaboral findExperienciaLaboral(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ExperienciaLaboral.class, id);
        } finally {
            em.close();
        }
    }

    public int getExperienciaLaboralCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ExperienciaLaboral> rt = cq.from(ExperienciaLaboral.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}