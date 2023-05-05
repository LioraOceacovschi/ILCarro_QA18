package manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    //WebDriver wd;
     Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    HelperUser user;
    HelperSearch search;

    public void init() {
       // wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new HelperUser(wd);
        search = new HelperSearch(wd);
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperSearch getSearch() {
        return search;
    }

    public void stop() {
//        wd.quit();
    }

}
