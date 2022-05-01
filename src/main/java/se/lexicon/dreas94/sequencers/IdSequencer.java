package se.lexicon.dreas94.sequencers;

public abstract class IdSequencer
{
    private int currentId;

    public IdSequencer()
    {
        setCurrentId(0);
    }

    public int nextId()
    {
        return ++this.currentId;
    }

    public int getCurrentId()
    {
        return this.currentId;
    }

    public void setCurrentId(int currentId)
    {
        this.currentId = currentId;
    }
}
