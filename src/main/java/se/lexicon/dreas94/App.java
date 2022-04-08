package se.lexicon.dreas94;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TodoItemTask itemTask = new TodoItemTask(
                new TodoItem("Testing", "Testing some java code to see that it works", LocalDate.parse("2018-12-27"),
                        new Person("Andreas", "Eriksson", "fakeemail@gmail.com")),
                new Person("Mehrdad", "Javan", "fakeemail1@gmail.com"));
        System.out.println(itemTask.getSummary());
    }
}
