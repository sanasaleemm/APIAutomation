package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestDeleteUser {

    private UserServiceHelper userServiceHelper;



    public void init() throws IOException {

        userServiceHelper= new UserServiceHelper();
    }

    @Test (priority = 2)
    //  Verify that Account/user is being deleted successfully"7
    public void DeleteUser(@NotNull ITestContext context) throws IOException {
        userServiceHelper= new  UserServiceHelper();
        String emptyresponse = String.valueOf(userServiceHelper.DeleteAccount(context));

        System.out.println("Account is Deleted and returned:" + emptyresponse);
    }

}
