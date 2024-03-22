package de.telran.game001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class HandlerTest {
    @Spy
    Map<Team<Participant>, Double> resultGamesMap;
    @InjectMocks
    Handler handler;
    @Test
    void sumValueTest() {
        //Assertions.assertEquals(2.1, Handler.sumValue());
    }

    @Test
    void play() {
    }

    @Test
    void playInGroup() {
    }

    @Test
    void showResultGameMapTest() {
//        Handler handler = new Handler();
//        Assertions.assertEquals(100,Handler.sumValue());
//        //Handler.sumValue();
    }

    @Test
    void showTeams() {
    }

    @Test
    void showParticipant() {
    }

    @Test
    void teamMax() {
    }

    @Test
    void sumValue() {
    }

    @Test
    void noPoints() {
    }

    @Test
    void middleAge() {
    }

    @Test
    void moreThanMiddle() {
    }

    @Test
    void teamSortedByPoint() {
    }

    @Test
    void onlyOneCategory() {
    }

    @Test
    void whoWin() {
    }

    @Test
    void soYung() {
    }

    @Test
    void soExpiriens() {
    }

    @Test
    void teamFromTo() {
    }

    @Test
    void participantsByAge() {
    }

    @Test
    void participantsByMaxDifferentAge() {
    }

    @Test
    void participantsByGleichAge() {
    }

    @Test
    void groupAveragingScore() {
    }

    @Test
    void besserEachPlay() {
    }

    @Test
    void noLossTeam() {
    }

    @Test
    void teamsDrawWithTeam() {
    }

    @Test
    void resultTeamWithTeam() {
    }

    @Test
    void complexReport() {
    }
}