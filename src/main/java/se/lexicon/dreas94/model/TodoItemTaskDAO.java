package se.lexicon.dreas94.model;

import java.util.Collection;

public interface TodoItemTaskDAO extends GenericDAO<TodoItemTask, Integer>
{
    Collection<TodoItem>findByAssignedStatus(boolean status);
    Collection<TodoItem>findByPersonId(int personId);
}
