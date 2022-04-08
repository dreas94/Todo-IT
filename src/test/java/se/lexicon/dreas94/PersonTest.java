package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest
{
    private Person testSubject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp()
    {
        Person personTest = new Person("Mehrdad", "Javan", "fakeemail1@gmail.com");
        testSubject = new Person("Andreas", "Eriksson", "fakeemail@gmail.com");
    }

    @Test
    public void test_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testSubject.getId());
    }

    @Test
    public void test_getFirstName()
    {
        String expectedName = "Andreas";
        assertEquals(expectedName, testSubject.getFirstName());
    }

    @Test
    public void test_setFirstName()
    {
        String testName = "And23reas";
        testSubject.setFirstName(testName);
        assertEquals(testName, testSubject.getFirstName());
    }

    @Test
    public void test_setFirstNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Person::setEmail::You did something wrong with the input, default value used instead");
        String testName = null;
        testSubject.setFirstName(testName);
    }

    @Test
    public void test_getLastName()
    {
        String expectedName = "Eriksson";
        assertEquals(expectedName, testSubject.getLastName());
    }

    @Test
    public void test_setLastName()
    {
        String testName = "Erik23sson";
        testSubject.setFirstName(testName);
        assertEquals(testName, testSubject.getLastName());
    }

    @Test
    public void test_setLastNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Person::setEmail::You did something wrong with the input, default value used instead");
        String testName = null;
        testSubject.setFirstName(testName);
    }

    @Test
    public void test_getEmail()
    {
        String expectedEmail = "fakeemail@gmail.com";
        assertEquals(expectedEmail, testSubject.getEmail());
    }

    @Test
    public void test_setEmail()
    {
        String testEmail = "ASFDdafsdf@gmail.com";
        testSubject.setEmail(testEmail);
        assertEquals(testEmail, testSubject.getEmail());
    }

    @Test
    public void test_setEmailToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Person::setEmail::You did something wrong with the input, default value used instead");
        String testEmail = null;
        testSubject.setEmail(testEmail);
    }

    @Test
    public void test_getSummary()
    {
        String expectedSummary = "{Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}";
        assertEquals(expectedSummary, testSubject.getSummary());
    }

    @Test
    public void test_getSummaryAndChange()
    {
        String expectedSummary = "{Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}";
        assertEquals(expectedSummary, testSubject.getSummary());
        String expectedSummary1 = "{Id: 0, Name: Anfsdsdfsreas Eriksson, Email: fakeemail@gmail.com}";
        testSubject.setFirstName("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testSubject.getSummary());
    }
}
