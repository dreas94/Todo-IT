package se.lexicon.dreas94.model;

import java.util.Vector;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO
{
    private Vector<TodoItemTask> dataCollection;

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
        findById(id);
    }

    @Override
    public TodoItemTask findById(int id)
    {
        for(TodoItemTask todoItem : dataCollection)
        {
            if(todoItem.getId() == id)
            {
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public Vector<TodoItemTask> findByAssignedStatus(boolean status)
    {
        Vector<TodoItemTask> returnVector = new Vector<>();
        for(TodoItemTask todoItemTask : dataCollection)
        {
            if(todoItemTask.isAssigned() == status)
            {
                returnVector.add(todoItemTask);
            }
        }
        return returnVector;
    }

    @Override
    public Vector<TodoItemTask> findByPersonId(int personId)
    {
        {
            Vector<TodoItemTask> returnVector = new Vector<>();
            for(TodoItemTask todoItemTask : dataCollection)
            {
                if(todoItemTask.isAssigned() && todoItemTask.getAssignee().getId() == personId)
                {
                    returnVector.add(todoItemTask);
                }
            }
            return returnVector;
        }
    }
}
