package de.telran.testing001;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {
    StudentRegistry studentRegistry = new StudentRegistry();
    @BeforeEach
    public void setUp() {
        studentRegistry.getStudentsMap().clear();
        studentRegistry.addStudent(new Student(1,"Vasya", "Petrov",
                "mail@email.com",4.5,Major.COMPUTER_SCIENCE,2021,true));
        studentRegistry.addStudent(new Student(2,"Petya", "Vasechkin",
                "mail@email.com",5.0,Major.MEDICINE,2022,true));
    }
    @Test
    void addStudentTest() {
        int actualResult = studentRegistry.getStudentsMap().size();
        Assertions.assertEquals(2,actualResult);
    }

    @Test
    void removeStudentTest() {
        studentRegistry.removeStudent(1);
        int actualResult = studentRegistry.getStudentsMap().size();
        Assertions.assertEquals(1,actualResult);
    }

    @Test
    void findStudentsByMajorTest() {
        List<Student> lst = studentRegistry.findStudentsByMajor(Major.COMPUTER_SCIENCE);
        Assertions.assertEquals(1,lst.size());
    }

    @Test
    void calculateAverageGradeTest() {
        Assertions.assertEquals(4.75,studentRegistry.calculateAverageGrade());
    }

    @Test
    void listStudentsByYearTest() {
    }

    @Test
    void getStudentTest() {
    }

    @Test
    void getTotalNumberOfStudentsTest() {
    }

    @Test
    void getStudentsWithGradeAboveTest() {
    }

    @Test
    void getAverageGradeByMajorTest() {
    }

    @Test
    void isStudentPresentTest() {
    }
}