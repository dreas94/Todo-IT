package se.lexicon.dreas94.model;

import se.lexicon.dreas94.utility.sequencers.PersonIdSequencer;
import se.lexicon.dreas94.utility.sequencers.TodoItemIdSequencer;
import se.lexicon.dreas94.utility.Validation;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem
{
    private TodoItemIdSequencer sequencer;

    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


    public TodoItem()
    {
        this.id = TodoItemIdSequencer.getInstance().nextId();
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator)
    {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setDone(false);
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
        Validation.checkStringNotNull.andThen(Validation.checkNotEmpty).accept(title, "Title");

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
        Validation.checkLocalDateNotNull.accept(deadLine, "Deadline");

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
        return deadLine.isAfter(LocalDate.now());
    }

    @Override
    public String toString()
    {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() && isDone() == todoItem.isDone() && Objects.equals(getTitle(), todoItem.getTitle()) && Objects.equals(getTaskDescription(), todoItem.getTaskDescription()) && Objects.equals(getDeadLine(), todoItem.getDeadLine()) && Objects.equals(getCreator(), todoItem.getCreator());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getTitle(), getTaskDescription(), getDeadLine(), isDone(), getCreator());
    }
}
