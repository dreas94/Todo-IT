package se.lexicon.dreas94;

public class Person
{
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    private static int sequencer = 0;

    public Person()
    {
        this.id = sequencer++;
    }

    public Person(String firstName, String lastName, String email)
    {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if(firstName == null)
        {
            MessageHandler.baseWarning("Person::setFirstName");
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        if(lastName == null)
        {
            MessageHandler.baseWarning("Person::setLastName");
        }

        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        if(email == null)
        {
            MessageHandler.baseWarning("Person::setEmail");
        }

        this.email = email;
    }

    public String getSummary()
    {
        return "{Id: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email + "}";
    }
}
