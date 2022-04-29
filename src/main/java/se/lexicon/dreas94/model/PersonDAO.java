package se.lexicon.dreas94.model;

public interface PersonDAO extends GenericDAO<Person,Integer>
{
    Person findById(int id);
    Person findByEmail(String email);
}
