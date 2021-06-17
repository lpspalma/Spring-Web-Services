package com.restapi1.buildrestapi.controller;

//import com.restapi1.buildrestapi.response.StudentResponse;
import com.restapi1.buildrestapi.entity.Student;
import com.restapi1.buildrestapi.request.CreateStudentRequest;
import com.restapi1.buildrestapi.request.InQueryRequest;
import com.restapi1.buildrestapi.request.UpdateStudentRequest;
import com.restapi1.buildrestapi.response.StudentResponse;
import com.restapi1.buildrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    //@RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<StudentResponse> getAllStudent(){
       List<Student> studentList = studentService.getAllStudents();
       List<StudentResponse> studentResponseList = new ArrayList<>();

       studentList.stream().forEach(student -> {
           studentResponseList.add(new StudentResponse(student));
       });

       return studentResponseList;

    }
    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.createStudent(createStudentRequest);

        return new StudentResponse(student);
    }

    @PutMapping("/update")
    public StudentResponse uptadeStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student = studentService.updateStudent(updateStudentRequest);

        return new StudentResponse(student);
    }

    /*@DeleteMapping("/delete")
    public String deleteStudent(@RequestParam long id){
        return studentService.deleteStudent(id);
    }*/

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstName){
        List<Student> studentList= studentService.getByFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName){
        return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("/getByFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,@PathVariable String lastName){
        List <Student> studentList= studentService.getByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }
    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        List <Student> studentList= studentService.getByFirstNameIn(inQueryRequest);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;
    }

    @GetMapping("getAllWithPagination")
    public List<StudentResponse>getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List <Student> studentList= studentService.getAllWithPagination(pageNo, pageSize);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        return studentResponseList;

    }
    @GetMapping("getAllWithSorting")
    public List<StudentResponse>getAllWithSorting(){
        List <Student> studentList= studentService.getAllWithSorting();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    @GetMapping("/like/{firstName}")
    public List<StudentResponse> like(@PathVariable String firstName){
        List <Student> studentList= studentService.like(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }

    /*@GetMapping("/startWith/{firstName}")
    public List<StudentResponse> startWith(@PathVariable String firstName){
        List <Student> studentList= studentService.startWith(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }*/

    /*@PutMapping("/updateFirstName/{id}/firstName")
    public String updateStudentByJPQL(@PathVariable Long id, @PathVariable String firstName){
        return studentService.updateStudentByJPQL(id, firstName)+ " Student(s) Updated.";
    }*/

}
