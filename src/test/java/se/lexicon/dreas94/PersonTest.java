package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest
{
    private Person testSubject;
    private Person testSubject1;

    @Before
    public void setUp()
    {
        testSubject = new Person("Andreas", "Eriksson", "fakeemail@gmail.com");
        testSubject1 = new Person("Mehrdad", "Javan", "fakeemail1@gmail.com");
    }

    @Test
    public void getID()
    {
        final int expectedNum = 0;
        final int expectedNum1= 1;
        assertEquals(expectedNum, testSubject.getId());
        assertEquals(expectedNum1, testSubject1.getId());
    }

    @Test
    public void getFirstName()
    {
        String expectedName = "Andreas";
        assertEquals(expectedName, testSubject.getFirstName());
    }

    @Test
    public void setFirstName()
    {
        String testName = "And23reas";
        testSubject.setFirstName(testName);
        assertEquals(testName, testSubject.getFirstName());
    }

    @Test
    public void setFirstNameToNull()
    {
        String expectedName = "Andreas";
        String testName = null;
        testSubject.setFirstName(testName);
        assertEquals(expectedName, testSubject.getFirstName());
    }

    @Test
    public void getLastName()
    {
        String expectedName = "Eriksson";
        assertEquals(expectedName, testSubject.getLastName());
    }

    @Test
    public void setLastName()
    {
        String testName = "Erik23sson";
        testSubject.setFirstName(testName);
        assertEquals(testName, testSubject.getLastName());
    }

    @Test
    public void setLastNameToNull()
    {
        String expectedName = "Eriksson";
        String testName = null;
        testSubject.setFirstName(testName);
        assertEquals(expectedName, testSubject.getLastName());
    }

    @Test
    public void getEmail()
    {
        String expectedEmail = "fakeemail@gmail.com";
        assertEquals(expectedEmail, testSubject.getEmail());
    }

    @Test
    public void setEmail()
    {
        String testEmail = "ASFDdafsdf@gmail.com";
        testSubject.setEmail(testEmail);
        assertEquals(testEmail, testSubject.getEmail());
    }

    @Test
    public void setEmailToNull()
    {
        String expectedEmail = "fakeemail@gmail.com";
        String testEmail = null;
        testSubject.setEmail(testEmail);
        assertEquals(expectedEmail, testSubject.getEmail());
    }

    @Test
    public void getSummary()
    {
        String expectedSummary = "{Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}";
        assertEquals(expectedSummary, testSubject.getSummary());
    }

    @Test
    public void getSummaryAndChange()
    {
        String expectedSummary = "{Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}";
        assertEquals(expectedSummary, testSubject.getSummary());
        String expectedSummary1 = "{Id: 0, Name: Anfsdsdfsreas Eriksson, Email: fakeemail@gmail.com}";
        testSubject.setFirstName("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testSubject.getSummary());
    }
}
