package Beans;

import Dao.StudentDao;
import Entities.Student;
import Intefaces.StudentI;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Local
@Stateless
public class StudentImp implements StudentI {
    @PersistenceContext
    EntityManager em;

    public boolean add(Student s) {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.add(s);

    }

    public List<Student> viewAll() {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.viewAll();
    }

    public boolean update(Student s) {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.update(s);
    }

    public List<Student> getById(String regno) {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.getById(regno);
    }
}
