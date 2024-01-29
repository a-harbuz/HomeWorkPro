package de.telran.team001;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static de.telran.team001.Handler.*;

public class Main {
    //private static final Faker FAKER = new Faker();
    //private static final Random RANDOM = new Random();
    private static final List<List<Team<Participant>>> groupTeamsList = new ArrayList<>(); // All Commands

    public static void main(String[] args) {

        Generator.generateTeams(groupTeamsList);
        Handler.play(groupTeamsList);
        //showTeams(groupTeamsList);
        showResultGameMap();

        //teamMax(groupTeamsList);
        //sumValue();
        //noPoints();
        //middleAge();
        //moreThanMiddle();

        //onlyOneCategory();
        //whoWin();

        //soYung();
        //soExpiriens();
        //teamFromTo(10,11);
        //participantsByAge();
        //participantsByGleichAge();
        //teamFromTo(10,13);

        //complexReport();
        //groupAveragingScore();

        //noLossTeam();


    }

}
