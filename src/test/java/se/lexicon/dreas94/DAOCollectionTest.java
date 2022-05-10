package se.lexicon.dreas94;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import se.lexicon.dreas94.dao.implementation.AppUserDAOCollection;
import se.lexicon.dreas94.dao.implementation.PersonDAOCollection;
import se.lexicon.dreas94.dao.implementation.TodoItemDAOCollection;
import se.lexicon.dreas94.dao.implementation.TodoItemTaskDAOCollection;
import se.lexicon.dreas94.model.*;

import java.time.LocalDate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOCollectionTest
{
    private static AppUserDAOCollection testAppUserCollection;
    private static PersonDAOCollection testPersonCollection;
    private static TodoItemDAOCollection testTodoItemCollection;
    private static TodoItemTaskDAOCollection testTodoItemTaskCollection;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUp()
    {
        testAppUserCollection = new AppUserDAOCollection();
        testPersonCollection = new PersonDAOCollection();
        testTodoItemCollection = new TodoItemDAOCollection();
        testTodoItemTaskCollection = new TodoItemTaskDAOCollection();

        testAppUserCollection.persist(new AppUser("Andreasiro", "123ABC", AppRole.ROLE_APP_ADMIN));
        testAppUserCollection.persist(new AppUser("Mehrdad123", "456def", AppRole.ROLE_APP_USER));
        testPersonCollection.persist(new Person("Andreas", "Eriksson", "fakeemail@gmail.com", testAppUserCollection.findByUsername("Andreasiro")));
        testPersonCollection.persist(new Person("Mehrdad", "Javan", "fakeemail1@gmail.com", testAppUserCollection.findByUsername("Mehrdad123")));
        testTodoItemCollection.persist(new TodoItem("Testing", "Testing some java code to see that it works", LocalDate.parse("2018-12-27"), testPersonCollection.findById(0)));
        testTodoItemTaskCollection.persist(new TodoItemTask(testTodoItemCollection.findById(0),testPersonCollection.findById(1)));
        assertEquals("[TodoItemTask{id=0, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}]", testTodoItemTaskCollection.findAll().toString());
    }

    @Test
    public void a1_test_persistAppUser()
    {
        testAppUserCollection.persist(new AppUser("Jonasir", "efdgter", AppRole.ROLE_APP_ADMIN));
        int expected = 3;
        assertEquals(expected, testAppUserCollection.findAll().size());
    }

    @Test
    public void a2_test_persistPerson()
    {
        testPersonCollection.persist(new Person("Jonas", "Eriksson", "fakeemail3@gmail.com", testAppUserCollection.findByUsername("Jonasir")));
        int expected = 3;
        assertEquals(expected, testPersonCollection.findAll().size());
    }

    @Test
    public void a3_test_persistTodoItem()
    {
        testTodoItemCollection.persist(new TodoItem("TestinsdadfaFDasd", "Testing some java code to see that it workssdfasfdasfd", LocalDate.parse("2022-05-27"), testPersonCollection.findById(2)));
        int expected = 2;
        assertEquals(expected, testTodoItemCollection.findAll().size());
    }

    @Test
    public void a4test_persisTodoItemTask()
    {
        testTodoItemTaskCollection.persist(new TodoItemTask(testTodoItemCollection.findById(1),null));
        int expected = 2;
        assertEquals(expected, testTodoItemTaskCollection.findAll().size());
    }

    @Test
    public void b1test_findAppUser()
    {
        String expected = "[AppUser{username='Andreasiro', role=ROLE_APP_ADMIN}, AppUser{username='Mehrdad123', role=ROLE_APP_USER}, AppUser{username='Jonasir', role=ROLE_APP_ADMIN}]";
        assertEquals(expected, testAppUserCollection.findAll().toString());
    }

    @Test
    public void b2test_findPerson()
    {
        String expected = "[Person{id=0, firstName='Andreas', lastName='Eriksson', email='fakeemail@gmail.com'}, Person{id=1, firstName='Mehrdad', lastName='Javan', email='fakeemail1@gmail.com'}, Person{id=2, firstName='Jonas', lastName='Eriksson', email='fakeemail3@gmail.com'}]";
        assertEquals(expected, testPersonCollection.findAll().toString());
    }

    @Test
    public void b3test_findTodoItem()
    {
        String expected = "[TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}, TodoItem{id=1, title='TestinsdadfaFDasd', taskDescription='Testing some java code to see that it workssdfasfdasfd', deadLine=2022-05-27, done=false}]";
        assertEquals(expected, testTodoItemCollection.findAll().toString());
    }

    @Test
    public void b4test_findTodoItemTask()
    {
        String expected = "[TodoItemTask{id=0, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}, TodoItemTask{id=1, assigned=false, todoItem=TodoItem{id=1, title='TestinsdadfaFDasd', taskDescription='Testing some java code to see that it workssdfasfdasfd', deadLine=2022-05-27, done=false}}]";
        assertEquals(expected, testTodoItemTaskCollection.findAll().toString());
    }

    @Test
    public void c2test_findByIdPerson()
    {
        String expected = "Person{id=0, firstName='Andreas', lastName='Eriksson', email='fakeemail@gmail.com'}";
        assertEquals(expected, testPersonCollection.findById(0).toString());
    }

    @Test
    public void c3test_findByIdTodoItem()
    {
        String expected = "TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}";
        assertEquals(expected, testTodoItemCollection.findById(0).toString());
    }

    @Test
    public void c4test_findByIdTodoItemTask()
    {
        String expected = "TodoItemTask{id=0, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}";
        assertEquals(expected, testTodoItemTaskCollection.findById(0).toString());
    }

    @Test
    public void d1test_findByAppUser()
    {
        String expected = "AppUser{username='Andreasiro', role=ROLE_APP_ADMIN}";
        assertEquals(expected, testAppUserCollection.findByUsername("Andreasiro").toString());
    }

    @Test
    public void d2test_findByPerson()
    {
        String expected = "Person{id=2, firstName='Jonas', lastName='Eriksson', email='fakeemail3@gmail.com'}";
        assertEquals(expected, testPersonCollection.findByEmail("fakeemail3@gmail.com").toString());
    }

    @Test
    public void d2test_findByPersonIdTodoItem()
    {
        String expected = "[TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}]";
        assertEquals(expected, testTodoItemCollection.findByPersonId(0).toString());
    }

    @Test
    public void d3test_findByDeadlineAfterTodoItem()
    {
        String expected = testTodoItemCollection.findAll().toString();
        assertEquals(expected, testTodoItemCollection.findByDeadlineAfter(LocalDate.parse("2018-12-26")).toString());
    }

    @Test
    public void d3test_findByDeadlineBeforeTodoItem()
    {
        String expected = testTodoItemCollection.findAll().toString();
        assertEquals(expected, testTodoItemCollection.findByDeadlineBefore(LocalDate.parse("9999-12-26")).toString());
    }

    @Test
    public void d3test_findAllByDoneStatusTodoItem()
    {
        String expected = "[]";
        assertEquals(expected, testTodoItemCollection.findAllByDoneStatus(true).toString());
    }

    @Test
    public void d3test_findByTitleContainsTodoItem()
    {
        String expected = "[TodoItem{id=1, title='TestinsdadfaFDasd', taskDescription='Testing some java code to see that it workssdfasfdasfd', deadLine=2022-05-27, done=false}]";
        assertEquals(expected, testTodoItemCollection.findByTitleContains("TestinsdadfaFDasd").toString());
    }

    @Test
    public void d4test_findByAssignedStatusTodoItemTask()
    {
        String expected = "[TodoItemTask{id=1, assigned=false, todoItem=TodoItem{id=1, title='TestinsdadfaFDasd', taskDescription='Testing some java code to see that it workssdfasfdasfd', deadLine=2022-05-27, done=false}}]";
        assertEquals(expected, testTodoItemTaskCollection.findByAssignedStatus(false).toString());
    }

    @Test
    public void d4test_findByPersonIdTodoItemTask()
    {
        String expected = "[TodoItemTask{id=0, assigned=true, todoItem=TodoItem{id=0, title='Testing', taskDescription='Testing some java code to see that it works', deadLine=2018-12-27, done=false}}]";
        assertEquals(expected, testTodoItemTaskCollection.findByPersonId(1).toString());
    }

    @Test
    public void e1test_removeAppUser()
    {
        String username = "Jonasir";
        testAppUserCollection.remove("Jonasir");
        assertNull(testAppUserCollection.findByUsername(username));
    }

    @Test
    public void e2test_removePerson()
    {
        int index = 2;
        testPersonCollection.remove(index);
        assertNull(testPersonCollection.findById(index));
    }

    @Test
    public void e3test_removeTodoItem()
    {
        int index = 1;
        testTodoItemCollection.remove(index);
        assertNull(testTodoItemCollection.findById(index));
    }

    @Test
    public void e4test_removeTodoItemTask()
    {
        int index = 1;
        testTodoItemTaskCollection.remove(index);
        assertNull(testTodoItemTaskCollection.findById(index));
    }
}
