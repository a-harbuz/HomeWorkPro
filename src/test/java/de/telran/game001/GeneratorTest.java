package de.telran.game001;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @ExtendWith(MockitoExtension.class)
    @Mock
    Generator generator;
    @Mock
    GroupTeams groupTeams;
    @Test
    void generateTeams() {
    }

    @Test
    void generateGroupTeams() {
        //assertEquals(25, generator.generateGroupTeams(groupTeams, Mockito.anyInt()).size());

    }
}