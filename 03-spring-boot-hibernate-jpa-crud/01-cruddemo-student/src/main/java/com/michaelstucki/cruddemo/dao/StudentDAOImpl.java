package com.michaelstucki.cruddemo.dao;

import com.michaelstucki.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager em;

    @Autowired
    // Inject entity manager via constructor injection
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    // Implement save
    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }
}
