package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User data) { // overloading
        type(By.id("email"), data.getEmail());
        type(By.id("password"), data.getPassword());
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public void clickCheckbox() {
        // variant 1
//        click(By.xpath("//label[@for='terms-of-use']"));
        // variant 2
        JavascriptExecutor script = (JavascriptExecutor) wd;
        script.executeScript("document.querySelector('#terms-of-use').click();");
        // variant 3
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//        wait.until(ExpectedConditions.
//                visibilityOfElementLocated(By.xpath("//*[@class='checkbox-container']")));
//        Rectangle rect = wd.findElement(By.xpath("//*[@class='checkbox-container']")).getRect();
//        int x = rect.getX() + 5;
//        int y = rect.getY() + rect.getHeight()/2;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void logout() {
        click(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    }

    public boolean isRegisteredSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='You are logged in success']")).getText().contains("success");
    }

    public boolean isLoggedFailed() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }


    public void clickOkButton() {
        pause(1000);
        if (isElementPresent(By.xpath("//button[.='Ok']"))) {
            click(By.xpath("//button[.='Ok']"));
        }
    }

    public void pageDown() {
      WebElement header = wd.findElement(By.xpath("//div[@class='header']"));
      header.sendKeys(Keys.PAGE_DOWN);
    }


    public boolean isWrongEmailTextPresent() {
      return  isElementPresent(By.xpath("//div[contains(text(),'Wrong email')]"));
    }

    public boolean submitFormIsAvailable() {

       return wd.findElement(By.xpath("//button[@type='submit']")).isEnabled();
    }
}
