package de.telran.team001;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static de.telran.team001.Handler.*;

public class Main {
    //private static final Faker FAKER = new Faker();
    //private static final Random RANDOM = new Random();
    //private static List<List<Team>> groupTeams = new ArrayList<>();

    public static void main(String[] args) {

        generate();
        play();
        showMap();

        //teamMax();
        //System.out.println(Handler.sumValue());

        //noPoints();
        //middleAge();
        //moreThanMiddle();
        //onlyOneCategory();

    }

}
