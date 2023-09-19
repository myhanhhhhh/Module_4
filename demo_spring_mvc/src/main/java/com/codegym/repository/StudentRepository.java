package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Lien","C05",0, new String[]{"JS","Java"}));
        studentList.add(new Student(2,"chanh2","C04",1, new String[]{"PHP","Java"}));
        studentList.add(new Student(3,"Kien","C06",-1, new String[]{"SQL","Java"}));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (Student s: studentList) {
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }
}
