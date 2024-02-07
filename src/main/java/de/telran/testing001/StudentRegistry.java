package de.telran.testing001;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Getter
public class StudentRegistry {
    private final Map<Integer, Student> studentsMap = new HashMap<>();
    // где ключ - это id студента.

//    addStudent(Student student) - добавляет студента в реестр.
    public void addStudent(Student student) {
        studentsMap.put(student.getId(), student);
    }
//    removeStudent(int id) - удаляет студента по идентификатору.
    public void removeStudent(int id){
        studentsMap.remove(id);
    }

//    findStudentsByMajor(String major) - возвращает список студентов, обучающихся на указанной специальности.
    public List<Student> findStudentsByMajor(Major major) {
        return studentsMap.values().stream()
                .filter(s->s.getMajor().equals(major))
                .toList();
        //return null;
    }

//    calculateAverageGrade() - вычисляет средний балл среди всех студентов.
    public double calculateAverageGrade() {
        return studentsMap.values().stream()
                .collect(Collectors.averagingDouble(Student::getGrade));
        //return 0.0;
    }

//    listStudentsByYear(int year) - возвращает список студентов, обучающихся на указанном курсе.
    public List<Student> listStudentsByYear(int year) {
        return studentsMap.values().stream()
                .filter(s->s.getYear()==year)
                .toList();
        //return null;
    }

//
//    getStudent(int id) - возвращает студента по его идентификатору.
    public List<Student> getStudent(int id) {
        return studentsMap.values().stream()
                .filter(s->s.getId()==id)
                .toList();
        //return null;
    }

//            getTotalNumberOfStudents() - возвращает общее количество студентов.
    public int getTotalNumberOfStudents() {
        return studentsMap.values().size();
        //return 0.0;
    }

//    getStudentsWithGradeAbove(double grade) - возвращает список студентов, чей средний балл выше указанного.
    public List<Student> getStudentsWithGradeAbove(double grade) {
        return studentsMap.values().stream()
                .filter(s->s.getGrade()==grade)
                .toList();
        //return null;
    }

//            getAverageGradeByMajor(String major) - вычисляет средний балл среди студентов определенной специальности.
    public Map<Major, Double> getAverageGradeByMajor(String major) {

        return null;
    }

//            isStudentPresent(String email) - проверяет, существует ли студент с заданным email в реестре.
    public boolean isStudentPresent(String email) {
        return false;
    }

}
