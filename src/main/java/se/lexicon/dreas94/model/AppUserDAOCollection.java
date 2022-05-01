package se.lexicon.dreas94.model;

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
    public AppUser findByUsername(String userName)
    {
        if(userName == null) throw new IllegalArgumentException("Person person username was null");
        if (userName.isEmpty()) throw new IllegalArgumentException("Parameter: String username was empty");

        for(AppUser appUser : dataCollection)
        {
            if(appUser.getUsername().equalsIgnoreCase(userName))
            {
                return appUser;
            }
        }
        return null;
    }
}
