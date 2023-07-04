package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

public class TestUpdateUser {
    private UserServiceHelper userServiceHelper;

    // @Test(priority = 2)
    public void init() throws IOException {

        userServiceHelper = new  UserServiceHelper();
    }

    @Test(priority = 1)

    //Verify that user is being updated successfully with username and email

    public void UpdateUser(@NotNull ITestContext context) throws IOException {
        userServiceHelper = new UserServiceHelper();
        String emptyResponse = String.valueOf(userServiceHelper.UpdateAccount(context));
        System.out.println("User is updated and returned:" + emptyResponse);

    }
}
