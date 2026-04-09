package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void testEquals_sameObject() {
        Team t = new Team("156-12");
        assertTrue(t.equals(t));
    }
    @Test
    public void testEquals_differentClass() {
        Team t = new Team("156-12");
        assertFalse(t.equals("test"));
    }
    @Test
    public void testEquals_TT() {
        Team t1 = new Team ("team1");
        Team t2 = new Team ("team1");
        assertTrue(t1.equals(t2));
    }
    @Test
    public void testEquals_TF() {
        Team t1 = new Team ("team1");
        t1.addMember("Bob");
        Team t2 = new Team ("team1");
        assertFalse(t1.equals(t2));
    }
    @Test
    public void testEquals_F() {
        Team t1 = new Team ("team1");
        Team t2 = new Team ("team2");
        assertFalse(t1.equals(t2));
    }
    @Test
    public void testHashCode() {
        Team t1 = new Team("team1");
        Team t2 = new Team("team1");
        t1.addMember("test");
        t2.addMember("test");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void testHashCode_expectedValue() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
