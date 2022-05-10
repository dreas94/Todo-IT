package se.lexicon.dreas94.dao.implementation;

import se.lexicon.dreas94.dao.TodoItemDAO;
import se.lexicon.dreas94.model.TodoItem;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Vector;

public class TodoItemDAOCollection implements TodoItemDAO
{
    private final Vector<TodoItem> dataCollection;

    public TodoItemDAOCollection()
    {
        dataCollection = new Vector<>();
    }
    @Override
    public TodoItem persist(TodoItem todoItem)
    {
        if(todoItem == null) throw new IllegalArgumentException("TodoItem todoItem username was null");

        dataCollection.add(todoItem);

        return todoItem;
    }

    @Override
    public Vector<TodoItem> findAll()
    {
        return dataCollection;
    }

    @Override
    public void remove(Integer id)
    {
        dataCollection.remove(findById(id));
    }

    @Override
    public TodoItem findById(int id)
    {
        return dataCollection.stream()
            .filter(todoItem -> todoItem.getId() == id)
            .findFirst().orElse(null);
    }

    @Override
    public Vector<TodoItem> findAllByDoneStatus(boolean done)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        dataCollection.stream()
                .filter(todoItem -> todoItem.isDone() == done)
                .forEach(returnVector::add);

        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByTitleContains(String title)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        dataCollection.stream()
                .filter(todoItem -> Objects.equals(todoItem.getTitle(), title))
                .forEach(returnVector::add);
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByPersonId(int personId)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        dataCollection.stream()
                .filter(todoItem -> todoItem.getCreator().getId() == personId)
                .forEach(returnVector::add);
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByDeadlineBefore(LocalDate deadline)
    {
        Vector<TodoItem> returnVector = new Vector<>();

        dataCollection.stream()
                .filter(todoItem -> todoItem.getDeadLine().isBefore(deadline))
                .forEach(returnVector::add);

        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByDeadlineAfter(LocalDate deadline)
    {
        Vector<TodoItem> returnVector = new Vector<>();

        dataCollection.stream()
                .filter(todoItem -> todoItem.getDeadLine().isAfter(deadline))
                .forEach(returnVector::add);

        return returnVector;
    }
}
