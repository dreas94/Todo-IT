package se.lexicon.dreas94.dao.implementation;

import se.lexicon.dreas94.dao.AppUserDAO;
import se.lexicon.dreas94.model.AppUser;

import java.util.Vector;

public class AppUserDAOCollection implements AppUserDAO
{
    private final Vector<AppUser> dataCollection;

    public AppUserDAOCollection()
    {
        dataCollection = new Vector<>();
    }

    @Override
    public AppUser persist(AppUser appUser)
    {
        if(appUser == null) throw new IllegalArgumentException("AppUser appUser username was null");

        dataCollection.add(appUser);

        return appUser;
    }

    @Override
    public Vector<AppUser> findAll()
    {
        return dataCollection;
    }

    @Override
    public void remove(String userName)
    {
        dataCollection.remove(findByUsername(userName));
    }

    @Override
    public AppUser findByUsername(String username)
    {
        return dataCollection.stream()
                .filter(appUser -> appUser.getUsername().equalsIgnoreCase(username))
                .findFirst().orElse(null);
    }
}
