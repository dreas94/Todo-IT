package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import se.lexicon.dreas94.model.Person;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTest
{
    private static Person testSubject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUp()
    {
        Person personTest = new Person("Mehrdad", "Javan", "fakeemail1@gmail.com", null);
        testSubject = new Person("Andreas", "Eriksson", "fakeemail@gmail.com", null);
    }

    @Test
    public void atest_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testSubject.getId());
    }

    @Test
    public void btest_getFirstName()
    {
        String expectedName = "Andreas";
        assertEquals(expectedName, testSubject.getFirstName());
    }

    @Test
    public void ctest_setFirstName()
    {
        String testName = "And23reas";
        testSubject.setFirstName(testName);
        assertEquals(testName, testSubject.getFirstName());
    }

    @Test
    public void dtest_setFirstNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("FirstName is null");
        String testName = null;
        testSubject.setFirstName(testName);
    }

    @Test
    public void etest_getLastName()
    {
        String expectedName = "Eriksson";
        assertEquals(expectedName, testSubject.getLastName());
    }

    @Test
    public void ftest_setLastName()
    {
        String testName = "Erik23sson";
        testSubject.setLastName(testName);
        assertEquals(testName, testSubject.getLastName());
    }

    @Test
    public void gtest_setLastNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("LastName is null");
        String testName = null;
        testSubject.setLastName(testName);
    }

    @Test
    public void htest_getEmail()
    {
        String expectedEmail = "fakeemail@gmail.com";
        assertEquals(expectedEmail, testSubject.getEmail());
    }

    @Test
    public void itest_setEmail()
    {
        String testEmail = "ASFDdafsdf@gmail.com";
        testSubject.setEmail(testEmail);
        assertEquals(testEmail, testSubject.getEmail());
    }

    @Test
    public void jtest_setEmailToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Email is null");
        String testEmail = null;
        testSubject.setEmail(testEmail);
    }

    @Test
    public void ktest_toString()
    {
        String expectedSummary = "Person{id=1, firstName='And23reas', lastName='Erik23sson', email='ASFDdafsdf@gmail.com'}";
        assertEquals(expectedSummary, testSubject.toString());
    }

    @Test
    public void ltest_toStringAndChange()
    {
        String expectedSummary = "Person{id=1, firstName='And23reas', lastName='Erik23sson', email='ASFDdafsdf@gmail.com'}";
        assertEquals(expectedSummary, testSubject.toString());
        String expectedSummary1 = "Person{id=1, firstName='Anfsdsdfsreas', lastName='Erik23sson', email='ASFDdafsdf@gmail.com'}";
        testSubject.setFirstName("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testSubject.toString());
    }
}
