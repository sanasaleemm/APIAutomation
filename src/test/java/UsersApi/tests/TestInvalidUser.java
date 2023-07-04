package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Owner("Sana")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that Account is not being created with duplicated email")
    //Verify that Account is being created successfully with mandatory fields
    public void Test_CreateInvalidUser( ) {

        String actualResponse = String.valueOf(userServiceHelper.createInvalidUser());
        System.out.println("User is not created due to duplicated email:" + actualResponse);
    }

    //@Test(priority = 4)
    @Owner("Sana")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that Account is not being created with invalid authentication token")
    public void Test_Create_User_WithInvalid_token( ) {

        String actualResponse = String.valueOf(userServiceHelper. User_WithInvalid_token());
        System.out.println("User is not created due to invalid token:" + actualResponse);
    }
}
