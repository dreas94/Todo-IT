package se.lexicon.dreas94.dao.implementation;

import se.lexicon.dreas94.dao.TodoItemTaskDAO;
import se.lexicon.dreas94.model.TodoItemTask;

import java.util.Vector;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO
{
    private final Vector<TodoItemTask> dataCollection;

    public TodoItemTaskDAOCollection()
    {
        dataCollection = new Vector<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask)
    {
        if(todoItemTask == null) throw new IllegalArgumentException("TodoItemTask todoItemTask username was null");

        dataCollection.add(todoItemTask);

        return todoItemTask;
    }

    @Override
    public Vector<TodoItemTask> findAll()
    {
        return dataCollection;
    }

    @Override
    public void remove(Integer id)
    {
        dataCollection.remove(findById(id));
    }

    @Override
    public TodoItemTask findById(int id)
    {
        return dataCollection.stream()
                .filter(todoItemTask -> todoItemTask.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public Vector<TodoItemTask> findByAssignedStatus(boolean status)
    {
        Vector<TodoItemTask> returnVector = new Vector<>();

        dataCollection.stream()
                .filter(todoItemTask -> todoItemTask.isAssigned() == status)
                .forEach(returnVector::add);

        return returnVector;
    }

    @Override
    public Vector<TodoItemTask> findByPersonId(int personId)
    {

        Vector<TodoItemTask> returnVector = new Vector<>();

        dataCollection.stream()
                .filter(todoItemTask -> todoItemTask.isAssigned() && todoItemTask.getAssignee().getId() == personId)
                .forEach(returnVector::add);

        return returnVector;
    }
}
