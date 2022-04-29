package se.lexicon.dreas94.model;

import java.util.Collection;

public interface AppUserDAO extends GenericDAO<AppUser,String>
{
    AppUser findByUsername(String userName);
}
