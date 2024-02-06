package de.telran.team001;

import com.github.javafaker.Faker;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static void generateTeams(List<List<Team<Participant>>> teamsList) {
        //List<Team<Participant>> listGroups = new ArrayList<>();
        teamsList.add(generateGroupTeams(GroupTeams.PUPIL,0));
        teamsList.add(generateGroupTeams(GroupTeams.TEENAGER,1));
        teamsList.add(generateGroupTeams(GroupTeams.ADULT,2));
    }

    public static List<Team<Participant>> generateGroupTeams(GroupTeams group, int cursor) {
        List<Team<Participant>> list = new ArrayList<>();
        String path = "C:\\JAVA\\HomeWorkPro\\src\\main\\java\\de\\telran\\team001\\cards.txt";
        //BufferedReader reader = new BufferedReader(new FileReader(path))
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            //System.out.println(reader.readLine());

            int numTeams = 25;
            int numPerson = 4;
            raf.seek((long) cursor *numTeams*numPerson*39); //Seek Cursor in cards.txt
            for (int i = 0; i < numTeams; i++) {
                //Create One Team
                Team<Participant> team = new Team<Participant>(FAKER.name().name(),group);
                for (int j = 0; j < numPerson; j++) {

                    String card = raf.readLine(); //Read Card
//                    System.out.println(card.substring(0,16));
//                    System.out.println(card.substring(22,29));
//                    System.out.println(card.substring(35,38));

                    if (group.equals(GroupTeams.PUPIL)) {
                        Pupil participant = new Pupil(FAKER.name().name(), RANDOM.nextInt(8)+10,
                                new CreditCard(card.substring(0,16),card.substring(22,29),card.substring(35,38)));
                        team.addNewParticipant(participant);
                    }
                    if (group.equals(GroupTeams.TEENAGER)) {
                        TeenAger participant = new TeenAger(FAKER.name().name(), RANDOM.nextInt(8)+18,
                                new CreditCard(card.substring(0,16),card.substring(22,29),card.substring(35,38)));
                        team.addNewParticipant(participant);
                    }
                    if (group.equals(GroupTeams.ADULT)) {
                        Adult participant = new Adult(FAKER.name().name(), RANDOM.nextInt(30)+26,
                                new CreditCard(card.substring(0,16),card.substring(22,29),card.substring(35,38)));
                        team.addNewParticipant(participant);
                    }
                }
                list.add(team);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


}
