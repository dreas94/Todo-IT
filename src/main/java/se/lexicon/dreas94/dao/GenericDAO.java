package se.lexicon.dreas94.dao;

import java.util.Vector;

public interface GenericDAO<T,S>
{
    T persist(T t);
    Vector<T> findAll();
    void remove(S s);
}
