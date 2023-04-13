package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("asd@fgh.com", "$Asdf1234");
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("asdfgh.com", "$Asdf1234");
        Assert.assertTrue(app.getUser().isLoggedFailed());
    }
    @Test
    public void loginNegativeTestWrongPassword(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("asd@fgh.com", "$Asdf123");
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedFailed2());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}
