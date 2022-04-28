package se.lexicon.dreas94.sequencers;

public class PersonalIdSequencer extends IdSequencer
{
    private PersonalIdSequencer() {}

    private static class SingletonHelper
    {
        private static final PersonalIdSequencer INSTANCE = new PersonalIdSequencer();
    }

    public static PersonalIdSequencer getInstance()
    {
        return SingletonHelper.INSTANCE;
    }
}
