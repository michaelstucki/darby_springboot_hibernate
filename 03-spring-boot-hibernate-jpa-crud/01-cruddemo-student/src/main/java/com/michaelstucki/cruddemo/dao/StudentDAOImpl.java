package com.michaelstucki.cruddemo.dao;

import com.michaelstucki.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery(
                "FROM Student WHERE lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Student.class, id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        return em.createQuery("DELETE FROM Student").executeUpdate();
    }
}
