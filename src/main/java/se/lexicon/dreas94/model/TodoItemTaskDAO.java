package se.lexicon.dreas94.model;

import java.util.Collection;

public interface TodoItemTaskDAO<T,S> extends GenericDAO<T,S>
{
    <S> Collection<T> findAll(S s);
}
