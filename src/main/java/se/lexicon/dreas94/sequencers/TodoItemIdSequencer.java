package se.lexicon.dreas94.sequencers;

public class TodoItemIdSequencer extends IdSequencer
{
    private TodoItemIdSequencer() {}

    private static class SingletonHelper
    {
        private static final TodoItemIdSequencer INSTANCE = new TodoItemIdSequencer();
    }

    public static TodoItemIdSequencer getInstance()
    {
        return SingletonHelper.INSTANCE;
    }
}
