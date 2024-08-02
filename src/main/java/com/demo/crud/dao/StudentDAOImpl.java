package com.demo.crud.dao;

import com.demo.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.QueryParameter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student readStudent(Integer id) {
      return   entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> createQuery=entityManager.createQuery("FROM Student ",Student.class);

        return createQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String name) {
        TypedQuery<Student> findBylName=entityManager.createQuery(
                "FROM Student where lastName=:theName",Student.class);
        findBylName.setParameter("theName",name);
        return findBylName.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
