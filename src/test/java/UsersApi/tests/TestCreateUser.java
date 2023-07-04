package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
public class TestCreateUser {
    private UserServiceHelper userServiceHelper;
    @BeforeClass

    public void init() {

        try {
            userServiceHelper = new UserServiceHelper();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }


    }

    @Test()

    //Verify that Account is being created successfully with mandatory fields
    public void Test_CreateValidUser( @NotNull ITestContext context) {

        String id = String.valueOf(userServiceHelper.createUser());

        assertNotNull(id, "id is not null");
        System.out.println("User is created with id:" + id);
        context.setAttribute("id", id);
    }



}
