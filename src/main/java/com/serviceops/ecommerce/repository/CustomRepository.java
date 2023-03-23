package com.serviceops.ecommerce.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomRepository {

    @Autowired
    EntityManager em;

    CriteriaBuilder criteriaBuilder;

    @Autowired
    Session session;


    @PostConstruct
    void init(){
        this.criteriaBuilder = em.getCriteriaBuilder();
    }


    public CustomRepository() {
    }




    public <T> T findByColumn(final String column, final String email,final Class<T> clazz){
        T singleResult = null;
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);
        query.select(from).where(criteriaBuilder.equal(from.get(column), criteriaBuilder.parameter(String.class,column)));
             return em.createQuery(query).setParameter(column, email).getSingleResult();

    }

    public <T> List<T> findAll(final Class<T> clazz){
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);
        query.select(from);
        return em.createQuery(query).getResultList();
    }
    public <T> List<T> findAllByColumnName(final Class<T> clazz,String foreignColumn,String foreignKey , String columnValue){
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);
        query.select(from).where(criteriaBuilder.equal(from.get(foreignColumn).get(foreignKey),criteriaBuilder.parameter(String.class,foreignKey)));
        return em.createQuery(query).setParameter(foreignKey,columnValue).getResultList();
    }
    @Transactional
    public <T> void  save(T t ){
        if (!em.contains(t)) {
            // persist object - add to entity manager
            em.persist(t);
            // flush em - save to DB
            em.flush();
        }
        // commit transaction at all



    }
    @jakarta.transaction.Transactional
    public <T>  void updateColumn(final Class<T> clazz,String columnName,String columnValue){
        CriteriaUpdate<T> query = criteriaBuilder.createCriteriaUpdate(clazz);
        Root<T> from = query.from(clazz);
        query.set(from.get(columnName),columnValue);
        em.createQuery(query).executeUpdate();
    }

    @Transactional
    public <T> void deleteById(final Class<T> clazz,Long id,String columnName){
        CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(clazz);
        Root<T> from = query.from(clazz);
        query.where(criteriaBuilder.equal(from.get(columnName),criteriaBuilder.parameter(Long.class,columnName)));
        em.createQuery(query).setParameter(columnName,id).executeUpdate();
    }




}
