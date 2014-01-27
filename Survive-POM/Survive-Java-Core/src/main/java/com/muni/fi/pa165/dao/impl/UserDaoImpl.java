package com.muni.fi.pa165.dao.impl;

import com.muni.fi.pa165.dao.UserDao;
import com.muni.fi.pa165.dao.gen.GenericDaoAbs;
import com.muni.fi.pa165.entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * Typed JpaDao objects extending the GenericDaoAbs abstract class and implementing a Type specific interface. This Dao
 * object will be used to perform all operations within the business layer.
 *
 * @author Maria
 */
@Repository
public class UserDaoImpl extends GenericDaoAbs<Users, Long> implements UserDao {

    /**
     *
     */
    public UserDaoImpl() {
        super(Users.class);
    }

//
//    @Override
//    public List<Users> findByUsername(String username) {
//        EntityManager em = this.getEntityManagerFactory().createEntityManager();
//        Query query = em.createNamedQuery("Users.findByUsername").setParameter("username", username);
//        EntityTransaction tx = em.getTransaction();
//        List<Users> list = new ArrayList();
//        try {
//            tx.begin();
//            list = query.getResultList();
//            tx.commit();
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
//        return list;
//    }
//    
//    
//
// 
//    @Override
//    public List<Users> findAll() {
//        EntityManager em = this.getEntityManagerFactory().createEntityManager();
//        Query query = em.createNamedQuery("Users.findAll");
//        EntityTransaction tx = em.getTransaction();
//        List<Users> list = new ArrayList();
//        try {
//            tx.begin();
//            list = query.getResultList();
//            tx.commit();
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
//        return list;
//    }
//    
    
//    /**
//     *
//     * @param pk
//     */
//    @Override
//    public void delete(Users pk) {
//        EntityManager em = this.getEntityManagerFactory().createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        Query query = em.createNamedQuery("Users.findById");
//        query.setParameter("monsterweaponPK", pk);
//        SystemUser obj = null;
//        try {
//            tx.begin();
//            obj = (Users) query.getSingleResult();
//            //em.merge(pk);
//            em.merge(obj);
//            em.remove(obj);
//            tx.commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public List<Users> findAll() {
//        EntityManager em = this.getEntityManagerFactory().createEntityManager();
//        Query query = em.createNamedQuery("Users.findAll");
//        EntityTransaction tx = em.getTransaction();
//        List<Users> list = new ArrayList();
//        try {
//            tx.begin();
//            list = query.getResultList();
//            tx.commit();
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
//        return list;
//    }
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public SystemUser findById(Users id) {
//        EntityManager em = this.getEntityManagerFactory().createEntityManager();
//        Query query = em.createNamedQuery("SystemUser.findById");
//        query.setParameter("monsterweaponPK", id);
//        EntityTransaction tx = em.getTransaction();
//        SystemUser obj = null;
//        try {
//            tx.begin();
//            obj = (SystemUser) query.getSingleResult();
//            tx.commit();
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
//        return obj;
//
//    }
}
