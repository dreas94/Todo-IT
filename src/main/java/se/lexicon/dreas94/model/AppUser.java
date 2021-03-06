package se.lexicon.dreas94.model;

import se.lexicon.dreas94.utility.Validation;

import java.util.Objects;

public class AppUser
{
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role)
    {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        Validation.checkStringNotNull.andThen(Validation.checkNotEmpty).accept(username, "Username");
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        Validation.checkStringNotNull.andThen(Validation.checkNotEmpty).andThen(Validation.checkMinLength3).accept(password, "Password");
        this.password = password;
    }

    public AppRole getRole()
    {
        return role;
    }

    public void setRole(AppRole role)
    {
        if (role == null) throw new IllegalArgumentException("Parameter: AppRole role was null");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;
        return Objects.equals(getUsername(), appUser.getUsername()) && getRole() == appUser.getRole();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getRole());
    }
}
