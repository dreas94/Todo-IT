package se.lexicon.dreas94.model;

import java.time.LocalDate;
import java.util.Collection;
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
        for(TodoItem todoItem : dataCollection)
        {
            if(todoItem.getId() == id)
            {
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public Vector<TodoItem> findAllByDoneStatus(boolean done)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        for(TodoItem todoItem : dataCollection)
        {
            if(todoItem.isDone() == done)
            {
                returnVector.add(todoItem);
            }
        }
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByTitleContains(String title)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        for(TodoItem todoItem : dataCollection)
        {
            if(todoItem.getTitle().equalsIgnoreCase(title))
            {
                returnVector.add(todoItem);
            }
        }
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByPersonId(int personId)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        for(TodoItem todoItem : dataCollection)
        {
            if(todoItem.getCreator().getId() == personId)
            {
                returnVector.add(todoItem);
            }
        }
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByDeadlineBefore(LocalDate deadLine)
    {
        Vector<TodoItem> returnVector = new Vector<>();
        for(TodoItem todoItem : dataCollection)
        {
            if(todoItem.getDeadLine().isBefore(deadLine))
            {
                returnVector.add(todoItem);
            }
        }
        return returnVector;
    }

    @Override
    public Vector<TodoItem> findByDeadlineAfter(LocalDate deadLine)
    {
        {
            Vector<TodoItem> returnVector = new Vector<>();
            for(TodoItem todoItem : dataCollection)
            {
                if(todoItem.getDeadLine().isAfter(deadLine))
                {
                    returnVector.add(todoItem);
                }
            }
            return returnVector;
        }
    }
}
