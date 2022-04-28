package se.lexicon.dreas94.model;

import java.util.Collection;

public interface GenericDAO<T,S>
{
    T persist(T t);
    Collection<T> findAll();
    void remove(S s);
}
