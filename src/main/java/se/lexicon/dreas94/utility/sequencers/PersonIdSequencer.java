package se.lexicon.dreas94.utility.sequencers;

public class PersonIdSequencer extends IdSequencer
{
    private PersonIdSequencer() {}

    private static class SingletonHelper
    {
        private static final PersonIdSequencer INSTANCE = new PersonIdSequencer();
    }

    public static PersonIdSequencer getInstance()
    {
        return SingletonHelper.INSTANCE;
    }
}
