package se.lexicon.dreas94.model;

import java.util.Objects;

public class TodoItemTask
{
    private static int sequencer = 0;

    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;


    public TodoItemTask()
    {
        this.id = sequencer++;
    }

    public TodoItemTask(TodoItem todoItem, Person assignee)
    {
        this();
        setTodoItem(todoItem);
        setAssignee(assignee);
    }

    public int getId()
    {
        return id;
    }

    public boolean isAssigned()
    {
        return assigned;
    }

    private void setAssigned(boolean assigned)
    {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem()
    {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem)
    {
        if (todoItem == null) throw new IllegalArgumentException("Parameter: TodoItem todoItem was null");
        this.todoItem = todoItem;
    }

    public Person getAssignee()
    {
        return assignee;
    }

    public void setAssignee(Person assignee)
    {
        this.assignee = assignee;
        setAssigned(this.assignee != null);
    }

    @Override
    public String toString()
    {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return getId() == that.getId() && isAssigned() == that.isAssigned() && getTodoItem().equals(that.getTodoItem());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), isAssigned(), getTodoItem());
    }
}
