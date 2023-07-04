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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestDeleteUser {

    private UserServiceHelper userServiceHelper;


    @BeforeClass
    public void init() throws IOException {

        userServiceHelper= new UserServiceHelper();
    }

    @Test (priority = 2)
    @Owner("Sana")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that Account is being deleted successfully")
    public void Test_DeleteUser(@NotNull ITestContext context) throws IOException {
    //    userServiceHelper= new  UserServiceHelper();
        String emptyresponse = String.valueOf(userServiceHelper.DeleteAccount(context));

        System.out.println("Account is Deleted and returned:" + emptyresponse);
    }

}
