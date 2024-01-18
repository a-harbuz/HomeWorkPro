package de.telran.team001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class Team<T> {
    private String teamName;
    private List<T> participantList = new ArrayList<>();
    private GroupTeams group;
    private Double punkte;

    public Team(String teamName, GroupTeams group) {
        this.teamName = teamName;
        this.group = group;
    }

    public String getTeamName() {
        return teamName;
    }
//===========================================================
    public List<T> getParticipantList() {
        return participantList;
    }
//===========================================================

    public GroupTeams getGroup() {
        return group;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setParticipantList(List<T> participantList) {
        this.participantList = participantList;
    }

    public Double getPunkte() {
        return punkte;
    }

    public void setPunkte(Double punkte) {
        this.punkte = punkte;
    }

    public void addNewParticipant(T participant) {
        participantList.add(participant);
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
            winner = "";
            return 0.5;
        }
        //System.out.println("WINNER: " + winner + "!!!!!");
    }


}
