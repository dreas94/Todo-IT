package se.lexicon.dreas94.dao;

import se.lexicon.dreas94.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends GenericDAO<TodoItemTask, Integer>
{
    TodoItemTask findById(int id);
    Collection<TodoItemTask>findByAssignedStatus(boolean status);
    Collection<TodoItemTask>findByPersonId(int personId);
}
