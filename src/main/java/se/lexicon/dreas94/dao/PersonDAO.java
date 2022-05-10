package se.lexicon.dreas94.dao;

import se.lexicon.dreas94.model.Person;

public interface PersonDAO extends GenericDAO<Person,Integer>
{
    Person findById(int id);
    Person findByEmail(String email);
}
