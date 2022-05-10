package se.lexicon.dreas94.utility.sequencers;

public abstract class IdSequencer
{
    private int currentId;

    public IdSequencer()
    {
        setCurrentId(-1);
    }

    public int getCurrentId()
    {
        return this.currentId;
    }

    public int nextId()
    {
        return ++this.currentId;
    }

    public void setCurrentId(int currentId)
    {
        this.currentId = currentId;
    }
}
