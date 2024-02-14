package de.telran.game001;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamsComplexReport {
    //private Team<Participant> team;
    private String teamName;
    private double averageAge;
    private double score; //баллы всех игр
    private int winnersCount; //сколько раз подряд победили

    @Override
    public String toString() {
        return "TeamsComplexReport{" +
                "teamName='" + teamName + '\'' +
                ", averageAge=" + averageAge +
                ", score=" + score +
                ", winnersCount=" + winnersCount +
                '}';
    }
}
