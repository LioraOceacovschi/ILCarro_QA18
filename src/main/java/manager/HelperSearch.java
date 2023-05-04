package manager;

import models.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperSearch extends HelperBase {
WebDriverWait wait = new WebDriverWait(wd,10);
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(Search search) {
        type(By.xpath("//input[@id='city']"), search.getCity());
        pause(3000);
        chooseCityInSearchCard();
        click(By.xpath("//input[@id='dates']"));
        pause(3000);
        click(By.xpath("//button[@aria-label='Choose month and year']"));
       click(By.xpath("//tbody[@class='mat-calendar-body']/tr/td[contains(.,'" + search.getYear() + "')]"));
      pause(3000);
        click(By.xpath("//tbody[@class='mat-calendar-body']/tr/td[contains(.,'" + search.getMonth() + "')]"));
      pause(3000);
        click(By.xpath("//tbody[@class='mat-calendar-body']/tr/td[contains(.,'" + search.getDateFrom() + "')]"));
        click(By.xpath("//tbody[@class='mat-calendar-body']/tr/td[contains(.,'" + search.getDateTo() + "')]"));
    }

    public void confirmSearch() {
        click(By.xpath("//button[contains(.,\"alla!\")]"));
    }
    public void  chooseCityInSearchCard(){
        Rectangle rect = wd.findElement(By.xpath("//input[@id='city']")).getRect();
        int x = rect.getX()+rect.getWidth()/2;
        int y = rect.getY()+rect.getHeight()+5;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x,y).click().perform();

    }
}
