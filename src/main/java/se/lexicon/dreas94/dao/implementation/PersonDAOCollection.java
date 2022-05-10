package se.lexicon.dreas94.dao.implementation;

import se.lexicon.dreas94.dao.PersonDAO;
import se.lexicon.dreas94.model.Person;

import java.util.Vector;

public class PersonDAOCollection implements PersonDAO
{
    private final Vector<Person> dataCollection;

    public PersonDAOCollection()
    {
        dataCollection = new Vector<>();
    }
    @Override
    public Person persist(Person person)
    {
        if(person == null) throw new IllegalArgumentException("Person person username was null");

        dataCollection.add(person);

        return person;
    }

    @Override
    public Vector<Person> findAll()
    {
        return dataCollection;
    }

    @Override
    public void remove(Integer id)
    {
        dataCollection.remove(findById(id));
    }

    @Override
    public Person findById(int id)
    {
        return dataCollection.stream()
                .filter(person -> person.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public Person findByEmail(String email)
    {
        return dataCollection.stream()
                .filter(person -> person.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }
}
