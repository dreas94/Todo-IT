package se.lexicon.dreas94.model;

import java.util.Objects;

public class AppUser
{
    private String userName;
    private String password;
    private AppRole role;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        if (userName == null) throw new IllegalArgumentException("Parameter: String userName was null");
        if (userName.isEmpty()) throw new IllegalArgumentException("Parameter: String userName was empty");
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        if (password == null) throw new IllegalArgumentException("Parameter: String password was null");
        if (password.isEmpty()) throw new IllegalArgumentException("Parameter: String password was empty");
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
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;
        return getUserName().equals(appUser.getUserName()) && getRole() == appUser.getRole();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUserName(), getRole());
    }
}
