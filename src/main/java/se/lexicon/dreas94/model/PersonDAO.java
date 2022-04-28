package se.lexicon.dreas94.model;

public interface PersonDAO extends GenericDAO<Person,Integer>
{
    int findById(int id);
    String findBy(String email);
}
