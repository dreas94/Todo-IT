package se.lexicon.dreas94.model;

import java.util.Collection;

public class PersonDAOCollection implements PersonDAO
{

    @Override
    public Person persist(Person person)
    {
        return null;
    }

    @Override
    public Collection<Person> findAll()
    {
        return null;
    }

    @Override
    public void remove(Integer integer)
    {

    }

    @Override
    public int findById(int id)
    {
        return 0;
    }

    @Override
    public String findBy(String email)
    {
        return null;
    }
}
