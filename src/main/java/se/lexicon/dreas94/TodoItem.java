package se.lexicon.dreas94;

import java.time.LocalDate;

public class TodoItem
{
    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    Person creator;

    static int sequencer = 0;

    public TodoItem()
    {
        this("Untitled", "", LocalDate.now(), true, null);
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator)
    {
        this.id = ++sequencer;
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setDone(done);
        setCreator(creator);
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        if(title == null || title.compareToIgnoreCase("") == 0)
        {
            MessageHandler.baseWarning("TodoItem::setTitle()");
            this.title = "Untitled";
            return;
        }

        this.title = title;
    }

    public String getTaskDescription()
    {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine()
    {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine)
    {
        if(deadLine == null)
        {
            MessageHandler.baseWarning("TodoItem::setDeadLine()");
            this.deadLine = LocalDate.now();
            return;
        }

        this.deadLine = deadLine;
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean done)
    {
        this.done = done;
    }

    public Person getCreator()
    {
        return creator;
    }

    public void setCreator(Person creator)
    {
        this.creator = creator;
    }

    public boolean isOverDue()
    {
        return deadLine.equals(LocalDate.now());
    }

    public String getSummary()
    {
        return "{Id: " + id + ", Title: " + title + ", Description:" + taskDescription + ", Deadline: " + deadLine + ", Is Finished?: " + done + "Created by: " + creator.getSummary() + "}";
    }
}
