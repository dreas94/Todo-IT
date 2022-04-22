package se.lexicon.dreas94;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import se.lexicon.dreas94.model.Person;
import se.lexicon.dreas94.model.TodoItem;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTest
{
    private TodoItem testTodoItem;
    private Person testSubject;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp()
    {
        TodoItem todoItemTest = new TodoItem();
        testSubject = new Person("Andreas", "Eriksson", "fakeemail@gmail.com");
        testTodoItem = new TodoItem("Testing", "Testing some java code to see that it works",
                LocalDate.parse("2018-12-27"), testSubject);
    }

    @Test
    public void test_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testTodoItem.getId());
    }

    @Test
    public void test_getTitle()
    {
        final String expectedTitle = "Testing";
        assertEquals(expectedTitle, testTodoItem.getTitle());
    }

    @Test
    public void test_setTitle()
    {
        String testTitle = "Testdasding";
        testTodoItem.setTitle(testTitle);
        assertEquals(testTitle, testTodoItem.getTitle());
    }

    @Test
    public void test_setFirstNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("TodoItem::setTitle()::You did something wrong with the input, default value used instead");
        String testName = null;
        testTodoItem.setTitle(testName);
    }

    @Test
    public void test_setFirstNameToEmptySpace()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("TodoItem::setTitle()::You did something wrong with the input, default value used instead");
        String testName = "";
        testTodoItem.setTitle(testName);
    }

    @Test
    public void test_getTaskDescription()
    {
        final String expectedTaskDescription = "Testing some java code to see that it works";
        assertEquals(expectedTaskDescription, testTodoItem.getTaskDescription());
    }

    @Test
    public void test_setTaskDescription()
    {
        String testName = "Testdasding";
        testTodoItem.setTaskDescription(testName);
        assertEquals(testName, testTodoItem.getTaskDescription());
    }

    @Test
    public void test_getDeadline()
    {
        final LocalDate expectedLocalDate = LocalDate.parse("2018-12-27");
        assertEquals(expectedLocalDate, testTodoItem.getDeadLine());
    }

    @Test
    public void test_setDeadline()
    {
        final LocalDate testLocalDate = LocalDate.now();
        testTodoItem.setDeadLine(testLocalDate);
        assertEquals(testLocalDate, testTodoItem.getDeadLine());
    }

    @Test
    public void test_setDeadlineToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("TodoItem::setDeadLine()::You did something wrong with the input, default value used instead");
        final LocalDate testLocalDate = null;
        testTodoItem.setDeadLine(testLocalDate);
    }

    @Test
    public void test_getDone()
    {
        assertFalse(testTodoItem.isDone());
    }

    @Test
    public void test_setDone()
    {
        testTodoItem.setDone(true);
        assertTrue(testTodoItem.isDone());
    }

    @Test
    public void test_getCreator()
    {
        final Person expectedCreator = testSubject;
        assertEquals(expectedCreator, testTodoItem.getCreator());
    }

    @Test
    public void test_setCreator()
    {
        final Person testCreator = new Person();
        testTodoItem.setCreator(testCreator);
        assertEquals(testCreator, testTodoItem.getCreator());
    }

    @Test
    public void test_isOverdue()
    {
        assertFalse(testTodoItem.isOverDue());
    }

    @Test
    public void test_getSummary()
    {
        String expectedSummary = "{Id: 1, Title: Testing, Description:Testing some java code to see that it works, Deadline: 2018-12-27, Is Finished?: false, Created by: {Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}}";
        assertEquals(expectedSummary, testTodoItem.getSummary());
    }

    @Test
    public void test_getSummaryAndChange()
    {
        String expectedSummary = "{Id: 1, Title: Testing, Description:Testing some java code to see that it works, Deadline: 2018-12-27, Is Finished?: false, Created by: {Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}}";
        assertEquals(expectedSummary, testTodoItem.getSummary());
        String expectedSummary1 = "{Id: 1, Title: Anfsdsdfsreas, Description:Testing some java code to see that it works, Deadline: 2018-12-27, Is Finished?: false, Created by: {Id: 0, Name: Andreas Eriksson, Email: fakeemail@gmail.com}}";
        testTodoItem.setTitle("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testTodoItem.getSummary());
    }
}
