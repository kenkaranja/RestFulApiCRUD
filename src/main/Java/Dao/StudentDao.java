package Dao;

import Entities.Student;
import Intefaces.StudentI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDao {
    EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }

    public boolean add(Student stu) {
        Student student = new Student();
        student.setName(stu.getName());
        student.setRegNo(stu.getRegNo());
        try {
            em.persist(student);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Student> viewAll() {
        try {
            return em.createNamedQuery("viewall").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean update(Student student) {
        if (getById(student.getRegNo()) != null) {
            try {
                em.createNamedQuery("updateStudent").setParameter("name", student.getName()).setParameter("regno", student.getRegNo());
                return true;
            } catch (PersistenceException e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public List<Student> getById(String regno) {
        try {
            return em.createNamedQuery("viewById").setParameter("regno", regno).getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }

    }
}
