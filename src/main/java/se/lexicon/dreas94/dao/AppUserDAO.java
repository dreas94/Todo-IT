package se.lexicon.dreas94.dao;

import se.lexicon.dreas94.model.AppUser;

public interface AppUserDAO extends GenericDAO<AppUser,String>
{
    AppUser findByUsername(String userName);
}
