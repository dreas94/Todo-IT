package se.lexicon.dreas94.model;

import java.util.Collection;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO
{

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return null;
    }

    @Override
    public void remove(Integer integer) {

    }

    @Override
    public Collection<TodoItem> findByAssignedStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return null;
    }
}
