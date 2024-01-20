package de.telran.team001;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static void generateTeams(List<List<Team<Participant>>> teamsList) {
        //List<Team<Participant>> listGroups = new ArrayList<>();
        teamsList.add(generateGroupTeams(GroupTeams.PUPIL));
        teamsList.add(generateGroupTeams(GroupTeams.TEENAGER));
        teamsList.add(generateGroupTeams(GroupTeams.ADULT));
    }

    public static List<Team<Participant>> generateGroupTeams(GroupTeams group) {
        List<Team<Participant>> list = new ArrayList<>();
        int numTeams = 25;
        int numPerson = 4;
        for (int i = 0; i < numTeams; i++) {
            //Create One Team
            Team<Participant> team = new Team<Participant>(FAKER.name().name(),group);
            for (int j = 0; j < numPerson; j++) {
                if (group.equals(GroupTeams.PUPIL)) {
                    Pupil participant = new Pupil(FAKER.name().name(), RANDOM.nextInt(8)+10);
                    team.addNewParticipant(participant);
                }
                if (group.equals(GroupTeams.TEENAGER)) {
                    TeenAger participant = new TeenAger(FAKER.name().name(), RANDOM.nextInt(8)+18);
                    team.addNewParticipant(participant);
                }
                if (group.equals(GroupTeams.ADULT)) {
                    Adult participant = new Adult(FAKER.name().name(), RANDOM.nextInt(30)+26);
                    team.addNewParticipant(participant);
                }
            }
            list.add(team);
        }
        return list;
    }


    public static void schowTeams(List<List<Team<Participant>>> listGroups) {
        int count=0;
//        for (List<Team> teamsList: listGroups) {
//            //===
//            for (int i = 0; i < teamsList.size(); i++) {
//                count++;
//                System.out.println("Team №"+count+": " + teamsList.get(i).getTeamName());
//                System.out.println("Team №"+count+": " + teamsList.get(i).getGroup());
//                for (Object s: teamsList.get(i).getParticipantList()) {
//                    System.out.println(s);
//                }
//            }
//            //===
//        }
    }


}
