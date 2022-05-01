package se.lexicon.dreas94.model;

import java.util.Vector;

public class PersonDAOCollection implements PersonDAO
{
    private Vector<Person> dataCollection;

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
        for(Person person : dataCollection)
        {
            if(person.getId() == id)
            {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email)
    {
        for(Person person : dataCollection)
        {
            if(person.getEmail().equalsIgnoreCase(email))
            {
                return person;
            }
        }
        return null;
    }
}
