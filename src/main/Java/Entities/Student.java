package Entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "viewall", query = "select s from Student s"),
        @NamedQuery(name = "updateStudent", query = "update Student set name=:name where regNo=:regno"),
        @NamedQuery(name = "viewById", query = "select a from Student  a where regNo=:regno")
})


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;
    String regNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
