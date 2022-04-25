package se.lexicon.dreas94.model;

import java.util.Objects;

public class Person
{
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    AppUser credentials;

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
        if(firstName == null) throw new IllegalArgumentException("Parameter: String firstName was null");

        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        if(lastName == null) throw new IllegalArgumentException("Parameter: String lastName was null");

        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        if(email == null) throw new IllegalArgumentException("Parameter: String email was null");

        this.email = email;
    }

    public AppUser getCredentials()
    {
        return credentials;
    }

    public void setCredentials(AppUser credentials)
    {
        this.credentials = credentials;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }
}
