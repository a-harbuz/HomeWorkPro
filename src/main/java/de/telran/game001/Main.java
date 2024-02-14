package de.telran.game001;

import java.util.ArrayList;
import java.util.List;

import static de.telran.game001.Handler.*;

public class Main {
    //private static final Faker FAKER = new Faker();
    //private static final Random RANDOM = new Random();
    private static final List<List<Team<Participant>>> groupTeamsList = new ArrayList<>(); // All Commands

    public static void main(String[] args) {

        Generator.generateTeams(groupTeamsList);
        Handler.play(groupTeamsList);

        //showTeams(groupTeamsList);
        showParticipant(groupTeamsList);
        //showResultGameMap();

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
