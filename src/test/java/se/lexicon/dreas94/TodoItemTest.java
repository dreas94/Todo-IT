package se.lexicon.dreas94;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import se.lexicon.dreas94.model.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoItemTest
{
    private static TodoItem testTodoItem;
    private static Person testSubject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUp()
    {
        TodoItem todoItemTest = new TodoItem();
        testSubject = new Person("Andreas", "Eriksson", "fakeemail@gmail.com");
        testTodoItem = new TodoItem("Testing", "Testing some java code to see that it works",
                LocalDate.parse("2018-12-27"), testSubject);
    }

    @Test
    public void atest_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testTodoItem.getId());
    }

    @Test
    public void btest_getTitle()
    {
        final String expectedTitle = "Testing";
        assertEquals(expectedTitle, testTodoItem.getTitle());
    }

    @Test
    public void ctest_setTitle()
    {
        String testTitle = "Testdasding";
        testTodoItem.setTitle(testTitle);
        assertEquals(testTitle, testTodoItem.getTitle());
    }

    @Test
    public void dtest_setFirstNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String title was null");
        String testName = null;
        testTodoItem.setTitle(testName);
    }

    @Test
    public void etest_setFirstNameToEmptySpace()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String title was empty");
        String testName = "";
        testTodoItem.setTitle(testName);
    }

    @Test
    public void ftest_getTaskDescription()
    {
        final String expectedTaskDescription = "Testing some java code to see that it works";
        assertEquals(expectedTaskDescription, testTodoItem.getTaskDescription());
    }

    @Test
    public void gtest_setTaskDescription()
    {
        String testName = "Testdasding";
        testTodoItem.setTaskDescription(testName);
        assertEquals(testName, testTodoItem.getTaskDescription());
    }

    @Test
    public void htest_getDeadline()
    {
        final LocalDate expectedLocalDate = LocalDate.parse("2018-12-27");
        assertEquals(expectedLocalDate, testTodoItem.getDeadLine());
    }

    @Test
    public void itest_setDeadline()
    {
        final LocalDate testLocalDate = LocalDate.now();
        testTodoItem.setDeadLine(testLocalDate);
        assertEquals(testLocalDate, testTodoItem.getDeadLine());
    }

    @Test
    public void jtest_setDeadlineToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: LocalDate deadLine was null");
        final LocalDate testLocalDate = null;
        testTodoItem.setDeadLine(testLocalDate);
    }

    @Test
    public void ktest_getDone()
    {
        assertFalse(testTodoItem.isDone());
    }

    @Test
    public void ltest_setDone()
    {
        testTodoItem.setDone(true);
        assertTrue(testTodoItem.isDone());
    }

    @Test
    public void mtest_getCreator()
    {
        final Person expectedCreator = testSubject;
        assertEquals(expectedCreator, testTodoItem.getCreator());
    }

    @Test
    public void ntest_setCreator()
    {
        final Person testCreator = new Person();
        testTodoItem.setCreator(testCreator);
        assertEquals(testCreator, testTodoItem.getCreator());
    }

    @Test
    public void otest_isOverdue()
    {
        assertTrue(testTodoItem.isOverDue());
    }

    @Test
    public void ptest_toString()
    {
        String expectedSummary = "TodoItem{id=1, title='Testdasding', taskDescription='Testdasding', deadLine=2022-04-25, done=true}";
        assertEquals(expectedSummary, testTodoItem.toString());
    }

    @Test
    public void qtest_toStringAndChange()
    {
        String expectedSummary = "TodoItem{id=1, title='Testdasding', taskDescription='Testdasding', deadLine=2022-04-25, done=true}";
        assertEquals(expectedSummary, testTodoItem.toString());
        String expectedSummary1 = "TodoItem{id=1, title='Anfsdsdfsreas', taskDescription='Testdasding', deadLine=2022-04-25, done=true}";
        testTodoItem.setTitle("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testTodoItem.toString());
    }
}
