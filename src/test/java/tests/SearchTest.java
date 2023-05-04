package tests;

import models.Search;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void searchPositiveTest() {
        Search search = Search.builder()
                .city("tel aviv")
                .year("2023")
                .month("MAY")
                .dateFrom("7")
                .dateTo("17")
                .build();
        app.getSearch().clickToHeaderLogo();
        app.getSearch().fillSearchForm(search);
        app.getSearch().confirmSearch();

    }
}
