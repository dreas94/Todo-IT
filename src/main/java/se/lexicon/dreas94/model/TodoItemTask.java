package se.lexicon.dreas94.model;

import se.lexicon.dreas94.MessageHandler;

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
        if(todoItem == null)
        {
            MessageHandler.baseWarning("TodoItemTask::setTodoItem()");
        }
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

    public String getSummary()
    {
        if(assigned)
            return "{Id: " + id + ", Todo Item: " + todoItem.getSummary() + ", Assigned Status: " + assignee.getSummary() + "}";
        else
            return "{Id: " + id + ", Todo Item: " +  todoItem.getSummary() + ", Assigned Status: None}";
        // ternary operator
    }
}
