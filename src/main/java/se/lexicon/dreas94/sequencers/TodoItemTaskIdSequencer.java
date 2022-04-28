package se.lexicon.dreas94.sequencers;

public class TodoItemTaskIdSequencer  extends IdSequencer
{
    private TodoItemTaskIdSequencer() {}

    private static class SingletonHelper
    {
        private static final TodoItemTaskIdSequencer INSTANCE = new TodoItemTaskIdSequencer();
    }

    public static TodoItemTaskIdSequencer getInstance()
    {
        return SingletonHelper.INSTANCE;
    }
}
