package com.restapi1.buildrestapi.repository;

import com.restapi1.buildrestapi.entity.Student;
import com.restapi1.buildrestapi.request.InQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameOrLastName(String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByFirstNameStartsWith(String firstName);
/*
    @Query("From Student where firstName=:firstName and lastname=:lastName")
    Student getByFirstNameAndLastName(String firstName, @Param("lastname")String lastName);

    @Modifying
    @Transactional //when modifying something in the DB should mark with this two notations
    @Query("Update Student set firstName=:firstName where id:=id")
    Integer updateFirstName(@Param("id")long id, String firstName);
    //will return how many items was updated
*/
    //here you can create all methods that the class will implement to find whatever you want
    //if you will only return one or unique object than you can change the List for Student
}
