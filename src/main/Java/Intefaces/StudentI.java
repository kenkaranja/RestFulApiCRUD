package Intefaces;

import Entities.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentI {
    boolean add(Student student);

    List<Student> viewAll();

    boolean update(Student student);

    List<Student> getById(String regno);
}
