package se.lexicon.dreas94;

public class Person
{
    private int id;
    private String firstName = "";
    private String lastName = "";
    private String email = "";

    private void nullWarning()
    {
        System.out.println("Null is not a allowed value, try again!");
    }

    public Person(int id, String firstName, String lastName, String email)
    {
        if(firstName == null || lastName  == null || email == null)
        {
            nullWarning();
            return;
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if(firstName == null)
        {
            nullWarning();
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
            nullWarning();
            return;
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
            nullWarning();
            return;
        }

        this.email = email;
    }

    public String getSummary()
    {
        return "{Id: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email + "}";
    }
}
