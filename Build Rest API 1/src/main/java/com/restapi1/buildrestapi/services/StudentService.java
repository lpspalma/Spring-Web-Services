package com.restapi1.buildrestapi.services;

import com.restapi1.buildrestapi.entity.Student;
import com.restapi1.buildrestapi.repository.StudentRepository;
import com.restapi1.buildrestapi.request.CreateStudentRequest;
import com.restapi1.buildrestapi.request.InQueryRequest;
import com.restapi1.buildrestapi.request.UpdateStudentRequest;
import com.restapi1.buildrestapi.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);
        student = studentRepository.save(student);
        return student;
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if(updateStudentRequest.getFirstName() != null &&
        !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        if(updateStudentRequest.getLastName() != null &&
        !updateStudentRequest.getLastName().isEmpty()){
            student.setLastName(updateStudentRequest.getLastName());
        }
        if(updateStudentRequest.getEmail() != null &&
        !updateStudentRequest.getEmail().isEmpty()){
            student.setEmail(updateStudentRequest.getEmail());
        }
        student = studentRepository.save(student);

        return student;
    }

    public String deleteStudent(Long id){
        studentRepository.deleteById(id);;

        return "Student has been deleted succesfully";
    }

    public List<Student> getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public Student getByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List <Student> getByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstName());
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");

        return studentRepository.findAll(sort);
    }

    public List<Student> like(String firstName) {
        return studentRepository.findByFirstNameContains(firstName);

    }

    /*public List<Student> startWith(String firstName) {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }

//    public Integer updateStudentByJPQL(Long id, String firstName) {
//        return studentRepository.updateFirstName(id, firstName);
//    }*/
}
