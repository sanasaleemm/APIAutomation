package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestInvalidUser {

    private UserServiceHelper userServiceHelper;
    @BeforeClass

    public void init() {

        try {
            userServiceHelper = new UserServiceHelper();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }


    }

    @Test(priority = 3 )

    //Verify that Account is being created successfully with mandatory fields
    public void Test_CreateInvalidUser( ) {

        String actualResponse = String.valueOf(userServiceHelper.createInvalidUser());
        System.out.println("User is not created due to duplicated email:" + actualResponse);
    }
}
