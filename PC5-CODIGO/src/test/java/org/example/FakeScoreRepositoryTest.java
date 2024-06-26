package org.example;

import org.example.example.ScoreDatabaseFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FakeScoreRepositoryTest {

    private ScoreDatabaseFake scoreRepository;

    @BeforeEach
    public void setUp() {
        scoreRepository = new ScoreDatabaseFake();
    }

    @Test
    public void testSaveAndGetScore() {
        scoreRepository.saveScore("Alice", 100);
        scoreRepository.saveScore("Bob", 50);

        assertEquals(100, scoreRepository.getScore("Alice"));
        assertEquals(50, scoreRepository.getScore("Bob"));
    }

    @Test
    public void testResetScore() {
        scoreRepository.saveScore("Alice", 100);
        scoreRepository.saveScore("Bob", 50);

        scoreRepository.resetScore("Alice");

        assertEquals(0, scoreRepository.getScore("Alice"));
        assertEquals(50, scoreRepository.getScore("Bob"));
    }
}
