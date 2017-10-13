package REST;

import Entities.Student;
import Intefaces.StudentI;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class StudentRest {
    @EJB
    private StudentI studentI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student) {
        //getRegNo and getName from JSON
        student.setRegNo(student.getRegNo());
        student.setName(student.getName());
        studentI.add(student);
        return Response.ok().build();
    }

    @Path("/viewAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Student> studentList = new ArrayList<Student>();
        Gson gson = new Gson();
        for (Student student : studentI.viewAll()) {
            studentList.add(student);
        }
        return Response.ok().entity(gson.toJson(studentList)).build();
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Student student) {
        student.setRegNo(student.getRegNo());
        student.setName(student.getName());
        studentI.update(student);
        return Response.ok().build();
    }

    @Path("/viewById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(String reg) {
        Gson gson = new Gson();
        List<Student> studentList = studentI.getById(reg);
        for (Student student : studentList) {
            studentList.add(student);
        }
        return Response.ok().entity(gson.toJson(studentList)).build();
    }
}
