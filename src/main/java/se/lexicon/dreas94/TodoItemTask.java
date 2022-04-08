package se.lexicon.dreas94;

public class TodoItemTask
{
    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    private static int sequencer = 0;

    public TodoItemTask()
    {
        this(new TodoItem(),new Person());
    }

    public TodoItemTask(TodoItem todoItem, Person assignee)
    {
        this.id = ++sequencer;
        assigned = assignee != null;
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

    public void setAssigned(boolean assigned)
    {
        this.assigned = assigned && assignee != null;
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
            this.todoItem = new TodoItem();
            return;
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
    }

    public String getSummary()
    {
        if(assigned)
            return "{Id: " + id + ", Todo Item: " + todoItem.getSummary() + ", Assigned Status: " + assignee.getSummary() + "}";
        else
            return "{Id: " + id + ", Todo Item: " +  todoItem.getSummary() + ", Assigned Status: None}";
    }
}
