package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import se.lexicon.dreas94.model.AppRole;
import se.lexicon.dreas94.model.AppUser;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppUserTest
{
    private AppUser testUser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp()
    {
        testUser = new AppUser("Andreas", "Eriksoneriuo", AppRole.ROLE_APP_USER);
    }

    @Test
    public void test_getUsername()
    {
        String expectedUsername = "Andreas";
        assertEquals(expectedUsername, testUser.getUsername());
    }

    @Test
    public void test_setUserName()
    {
        String testUsername = "Andreas1234";
        testUser.setUsername(testUsername);
        assertEquals(testUsername, testUser.getUsername());
    }

    @Test
    public void test_setUserNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String username was null");
        String testUsername = null;
        testUser.setUsername(testUsername);
    }

    @Test
    public void test_setUserNameToEmpty()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String username was empty");
        String testUsername = "";
        testUser.setUsername(testUsername);
    }

    @Test
    public void test_getPassword()
    {
        String expectedPassword = "Eriksoneriuo";
        assertEquals(expectedPassword, testUser.getPassword());
    }

    @Test
    public void test_setPassword()
    {
        String testPassword = "Eriksoneriuo12345123";
        testUser.setPassword(testPassword);
        assertEquals(testPassword, testUser.getPassword());
    }

    @Test
    public void test_setPasswordToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String password was null");
        String testPassword = null;
        testUser.setPassword(testPassword);
    }

    @Test
    public void test_setPasswordToEmpty()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: String password was empty");
        String testPassword = "";
        testUser.setPassword(testPassword);
    }

    @Test
    public void test_getRole()
    {
        AppRole expectedRole = AppRole.ROLE_APP_USER;
        assertEquals(expectedRole, testUser.getRole());
    }

    @Test
    public void test_setRole()
    {
        AppRole testRole = AppRole.ROLE_APP_ADMIN;
        testUser.setRole(testRole);
        assertEquals(testRole, testUser.getRole());
    }

    @Test
    public void test_setRoleToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: AppRole role was null");
        AppRole testRole = null;
        testUser.setRole(testRole);
    }

    @Test
    public void test_toString()
    {
        String expectedSummary = "AppUser{username='Andreas', role=ROLE_APP_USER}";
        assertEquals(expectedSummary, testUser.toString());
    }

    @Test
    public void test_changeUsernameAndToString()
    {
        String expectedSummary1 = "AppUser{username='Anfsdsdfsreas', role=ROLE_APP_USER}";
        testUser.setUsername("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testUser.toString());
    }
}
