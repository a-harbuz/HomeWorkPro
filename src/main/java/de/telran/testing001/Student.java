package de.telran.testing001;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double grade; // средний балл студента.
    private Major major; // специальность студента.
    private int year; // курс обучения студента.
    private boolean fullTime;
}
