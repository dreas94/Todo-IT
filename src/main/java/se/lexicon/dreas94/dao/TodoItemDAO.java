package se.lexicon.dreas94.dao;

import se.lexicon.dreas94.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends GenericDAO<TodoItem,Integer>
{
    TodoItem findById(int id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate deadLine);
    Collection<TodoItem> findByDeadlineAfter(LocalDate deadLine);
}
