package se.lexicon.dreas94.model;

import java.time.LocalDate;
import java.util.Collection;

public class TodoItemDAOCollection implements TodoItemDAO
{
    @Override
    public TodoItem persist(TodoItem todoItem) {
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return null;
    }

    @Override
    public void remove(Integer integer) {

    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadLine) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate deadLine) {
        return null;
    }
}
