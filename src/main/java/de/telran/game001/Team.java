package de.telran.game001;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team<T> {
    private String teamName;
    //Список участников в команде
    private List<T> participantList = new ArrayList<>();
    private GroupTeams group; //Группа команд PUPIL, TEENAGER, ADULT

    //Общая сумма балов выигрышей
    private double punkte;

    //У кого выиграли (список команд)
    private Map<Team<T>,Double> iamWinMap = new HashMap<>(); //мапа с кем играли, какой бал в каждой игре

    private int winnersCount; //сколько раз подряд победили
    //private int neutralCount; //сколько раз подряд ничьих
    //private int lossCount; //сколько раз подряд проигрышей

    public Team(String teamName, GroupTeams group) {
        this.teamName = teamName;
        this.group = group;
    }
    //===========================================================

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setParticipantList(List<T> participantList) {
        this.participantList = participantList;
    }

    public void addNewParticipant(T participant) {
        participantList.add(participant);
    }

//    public void addiamWin(Team<T> team) {
//        iamWinList.add(team);
//    }
    public void addiamWinMap(Team<T> team, double score) {
        iamWinMap.put(team, score);
    }

    public double play(Team<T> secondTeam) {
        String winner;
        int randomDigit = new Random().nextInt(3);

        if(randomDigit == 0) {
            //this winner
            winner = this.teamName;
            return 1.0;
        } else if (randomDigit == 1){
            //second winner
            winner = secondTeam.teamName;
            return 0.0;
        } else {
            //same both winner
            winner = "Ничья.";
            return 0.5;
        }
        //System.out.println("WINNER: " + winner + "!!!!!");
    }


}
