package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import se.lexicon.dreas94.model.*;

import java.time.LocalDate;

public class TodoItemTaskTest
{
    private TodoItemTask testTodoItemTask;
    private TodoItem testTodoItem;
    private Person testAssignee;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp()
    {
        TodoItemTask todoItemTest = new TodoItemTask();
        final Person testCreator = new Person("Andreas", "Eriksson", "fakeemail@gmail.com");
        testAssignee = new Person("Mehrdad", "Javan", "fakeemail1@gmail.com");
        testTodoItem = new TodoItem("Testing", "Testing some java code to see that it works", LocalDate.parse("2018-12-27"), testCreator);
        testTodoItemTask = new TodoItemTask(testTodoItem, testAssignee);
    }

    @Test
    public void test_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testTodoItemTask.getId());
    }

    @Test
    public void test_isAssigned()
    {
        assertTrue(testTodoItemTask.isAssigned());
    }

    @Test
    public void test_getTodoItem()
    {
        assertEquals(testTodoItemTask.getTodoItem(),testTodoItem);
    }

    @Test
    public void test_setTodoItem()
    {
        final TodoItem todoItem = new TodoItem("Testfasding", "Testing some jadfvasdfaadfva code to see that it works", LocalDate.now(), testAssignee);
        testTodoItemTask.setTodoItem(todoItem);

    }

    @Test
    public void test_getAssignee()
    {
        assertEquals(testTodoItemTask.getAssignee(), testAssignee);
    }

    @Test
    public void test_setAssigneeAndSetAssigned()
    {
        testTodoItemTask.setAssignee(null);
        assertFalse(testTodoItemTask.isAssigned() && testTodoItemTask.getAssignee().equals(testAssignee));
    }

    @Test
    public void test_getSummary()
    {
        String expectedSummary = "TodoItemTask{id=1, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}";
        assertEquals(expectedSummary, testTodoItemTask.toString());
    }

    @Test
    public void test_getSummaryAndChange()
    {
        String expectedSummary = "TodoItemTask{id=1, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}";
        assertEquals(expectedSummary, testTodoItemTask.toString());
        String expectedSummary1 = "TodoItemTask{id=1, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}";
        testTodoItemTask.getAssignee().setFirstName("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testTodoItemTask.toString());
    }

}
