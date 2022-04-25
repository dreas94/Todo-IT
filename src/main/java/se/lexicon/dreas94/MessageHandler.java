package se.lexicon.dreas94;

public class MessageHandler
{

    public static void msg(String text)
    {
        System.out.println(text);
    }

    public static void baseWarning()
    {
        baseWarning("");
    }
    public static void baseWarning(String text)
    {
        throw new IllegalArgumentException(text + "::You did something wrong with the input, default value used instead");
    }
}
