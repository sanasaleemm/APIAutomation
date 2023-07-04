package UsersApi.tests;

import com.exe.api.helpers.UserServiceHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Owner("Sana")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that Account/User is being created successfully")
    public void Test_CreateValidUser( @NotNull ITestContext context) {

        String id = String.valueOf(userServiceHelper.createUser());

        assertNotNull(id, "id is not null");
        System.out.println("User is created with id:" + id);
        context.setAttribute("id", id);
    }

}
