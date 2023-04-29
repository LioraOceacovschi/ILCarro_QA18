package tests;

import models.User;
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
        User data = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("asd@fgh.com", "$Asdf1234");
        app.getUser().fillLoginForm(data);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        User data = new User().withEmail("asdfgh.com").withPassword("$Asdf1234");
        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("asdfgh.com", "$Asdf1234");
        app.getUser().fillLoginForm(data);
        Assert.assertTrue(app.getUser().isLoggedFailed());
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}
