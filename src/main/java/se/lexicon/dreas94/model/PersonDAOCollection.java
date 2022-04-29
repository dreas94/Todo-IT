package se.lexicon.dreas94.model;

import java.util.Collection;
import java.util.Iterator;

public class PersonDAOCollection implements PersonDAO
{
    private Collection<Person> dataCollection;

    @Override
    public Person persist(Person person)
    {
        dataCollection.add(person);

        return person;
    }

    @Override
    public Collection<Person> findAll()
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
        Iterator<Person> iterator = dataCollection.iterator();
        while (iterator.hasNext())
        {
            Person temp = iterator.next();
            if(temp.getId() == id)
            {
                return temp;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email)
    {
        Iterator<Person> iterator = dataCollection.iterator();
        while (iterator.hasNext())
        {
            Person temp = iterator.next();
            if(temp.getEmail().equalsIgnoreCase(email))
            {
                return temp;
            }
        }
        return null;
    }
}
