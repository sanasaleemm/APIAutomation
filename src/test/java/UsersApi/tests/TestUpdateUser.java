package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;

public class TestUpdateUser {
    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init() throws IOException {

        userServiceHelper = new  UserServiceHelper();
    }

    @Test(priority = 1)
    @Owner("Sana")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that Account is being updated successfully")

    public void Test_UpdateUser(@NotNull ITestContext context) throws IOException {
     //   userServiceHelper = new UserServiceHelper();
        String emptyResponse = String.valueOf(userServiceHelper.UpdateAccount(context));
        System.out.println("User is updated and returned:" + emptyResponse);

    }
}
