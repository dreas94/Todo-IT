package se.lexicon.dreas94.model;

import java.util.Collection;

public interface TodoItemTaskDAO extends GenericDAO<TodoItemTask, Integer>
{
    TodoItemTask findById(int id);
    Collection<TodoItemTask>findByAssignedStatus(boolean status);
    Collection<TodoItemTask>findByPersonId(int personId);
}
