package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import se.lexicon.dreas94.model.*;

import java.time.LocalDate;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoItemTaskTest
{
    private static TodoItemTask testTodoItemTask;
    private static TodoItem testTodoItem;
    private static Person testAssignee;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUp()
    {
        TodoItemTask todoItemTest = new TodoItemTask();
        final Person testCreator = new Person("Andreas", "Eriksson", "fakeemail@gmail.com", null);
        testAssignee = new Person("Mehrdad", "Javan", "fakeemail1@gmail.com", null);
        testTodoItem = new TodoItem("Testing", "Testing some java code to see that it works", LocalDate.parse("2018-12-27"), testCreator);
        testTodoItemTask = new TodoItemTask(testTodoItem, testAssignee);
    }

    @Test
    public void atest_getID()
    {
        final int expectedNum = 1;
        assertEquals(expectedNum, testTodoItemTask.getId());
    }

    @Test
    public void btest_isAssigned()
    {
        assertTrue(testTodoItemTask.isAssigned());
    }

    @Test
    public void ctest_getTodoItem()
    {
        assertEquals(testTodoItemTask.getTodoItem(),testTodoItem);
    }

    @Test
    public void dtest_setTodoItem()
    {
        final TodoItem todoItem = new TodoItem("Testfasding", "Testing some jadfvasdfaadfva code to see that it works", LocalDate.parse("2022-04-25"), testAssignee);
        testTodoItemTask.setTodoItem(todoItem);

    }

    @Test
    public void etest_getAssignee()
    {
        assertEquals(testTodoItemTask.getAssignee(), testAssignee);
    }

    @Test
    public void ftest_setAssigneeAndSetAssigned()
    {
        testTodoItemTask.setAssignee(null);
        assertFalse(testTodoItemTask.isAssigned() && testTodoItemTask.getAssignee().equals(testAssignee));
    }

    @Test
    public void gtest_toString()
    {
        String expectedSummary = "TodoItemTask{id=1, assigned=false, todoItem=TodoItem{id=1, title='Testfasding', taskDescription='Testing some jadfvasdfaadfva code to see that it works', deadLine=2022-04-25, done=false}}";
        assertEquals(expectedSummary, testTodoItemTask.toString());
    }

    @Test
    public void htest_toStringAndChange()
    {
        String expectedSummary = "TodoItemTask{id=1, assigned=false, todoItem=TodoItem{id=1, title='Testfasding', taskDescription='Testing some jadfvasdfaadfva code to see that it works', deadLine=2022-04-25, done=false}}";
        assertEquals(expectedSummary, testTodoItemTask.toString());
        String expectedSummary1 = "TodoItemTask{id=1, assigned=false, todoItem=TodoItem{id=1, title='Testfasding', taskDescription='Testing some jadfvasdfaadfva code to see that it works', deadLine=2022-04-25, done=false}}";
        assertEquals(expectedSummary1, testTodoItemTask.toString());
    }

}
