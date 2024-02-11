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
        Assertions.assertEquals(1,studentRegistry.listStudentsByYear(2021).size());
    }

    @Test
    void getStudentTest() {
        Assertions.assertEquals(Student.class,studentRegistry.getStudent(1).getClass());
        Assertions.assertEquals("Vasya",studentRegistry.getStudent(1).getFirstName());
    }

    @Test
    void getTotalNumberOfStudentsTest() {
        Assertions.assertEquals(2,studentRegistry.getTotalNumberOfStudents());
    }

    @Test
    void getStudentsWithGradeAboveTest() {
        Assertions.assertEquals(1,studentRegistry.getStudentsWithGradeAbove(4.5).size());
        Assertions.assertEquals("Petya",studentRegistry.getStudentsWithGradeAbove(4.5).get(0).getFirstName());
    }

    @Test
    void getAverageGradeByMajorTest() {
        Assertions.assertEquals(4.5,studentRegistry.getAverageGradeByMajor("COMPUTER_SCIENCE"));
    }

    @Test
    void isStudentByEmailPresentTest() {
        assertTrue(studentRegistry.isStudentPresent("mail@email.com"));
        assertFalse(studentRegistry.isStudentPresent("x@xx.xx"));
    }
}