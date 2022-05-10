package se.lexicon.dreas94;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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
    private static AppUser testUser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setUp()
    {
        testUser = new AppUser("Andreas", "Eriksoneriuo", AppRole.ROLE_APP_USER);
    }

    @Test
    public void atest_getUsername()
    {
        String expectedUsername = "Andreas";
        assertEquals(expectedUsername, testUser.getUsername());
    }

    @Test
    public void btest_setUserName()
    {
        String testUsername = "Andreas1234";
        testUser.setUsername(testUsername);
        assertEquals(testUsername, testUser.getUsername());
    }

    @Test
    public void ctest_setUserNameToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Username is null");
        String testUsername = null;
        testUser.setUsername(testUsername);
    }

    @Test
    public void dtest_setUserNameToEmpty()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Username is empty");
        String testUsername = "";
        testUser.setUsername(testUsername);
    }

    @Test
    public void etest_getPassword()
    {
        String expectedPassword = "Eriksoneriuo";
        assertEquals(expectedPassword, testUser.getPassword());
    }

    @Test
    public void ftest_setPassword()
    {
        String testPassword = "Eriksoneriuo12345123";
        testUser.setPassword(testPassword);
        assertEquals(testPassword, testUser.getPassword());
    }

    @Test
    public void gtest_setPasswordToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Password is null");
        String testPassword = null;
        testUser.setPassword(testPassword);
    }

    @Test
    public void htest_setPasswordToEmpty()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Password is empty");
        String testPassword = "";
        testUser.setPassword(testPassword);
    }

    @Test
    public void itest_getRole()
    {
        AppRole expectedRole = AppRole.ROLE_APP_USER;
        assertEquals(expectedRole, testUser.getRole());
    }

    @Test
    public void jtest_setRole()
    {
        AppRole testRole = AppRole.ROLE_APP_ADMIN;
        testUser.setRole(testRole);
        assertEquals(testRole, testUser.getRole());
    }

    @Test
    public void ktest_setRoleToNull()
    {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Parameter: AppRole role was null");
        AppRole testRole = null;
        testUser.setRole(testRole);
    }

    @Test
    public void ltest_toString()
    {
        String expectedSummary = "AppUser{username='Andreas1234', role=ROLE_APP_ADMIN}";
        assertEquals(expectedSummary, testUser.toString());
    }

    @Test
    public void mtest_changeUsernameAndToString()
    {
        String expectedSummary1 = "AppUser{username='Anfsdsdfsreas', role=ROLE_APP_ADMIN}";
        testUser.setUsername("Anfsdsdfsreas");
        assertEquals(expectedSummary1, testUser.toString());
    }
}
