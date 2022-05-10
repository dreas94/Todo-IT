package se.lexicon.dreas94.model;

import se.lexicon.dreas94.utility.sequencers.PersonIdSequencer;
import se.lexicon.dreas94.utility.Validation;

import java.util.Objects;

public class Person
{
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    AppUser credentials;

    public Person()
    {
        this.id = PersonIdSequencer.getInstance().nextId();
    }

    public Person(String firstName, String lastName, String email, AppUser credentials)
    {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setCredentials(credentials);
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
        Validation.checkStringNotNull.accept(firstName, "FirstName");
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        Validation.checkStringNotNull.accept(lastName, "LastName");

        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        Validation.checkStringNotNull.accept(email, "Email");

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
        return getId() == person.getId() && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }
}
