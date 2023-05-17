package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("asd@fgh.com").withPassword("$Asdf1234")});
        list.add(new Object[]{new User().withEmail("asd@fgh.com").withPassword("$Asdf1234")});
        list.add(new Object[]{new User().withEmail("asd@fgh.com").withPassword("$Asdf1234")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationDtoCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/dataRegistrationTests(registrationPositiveTest).csv")));
        String line = reader.readLine();

        while (line!=null) {
            String[] splitLine = line.split(",");
            list.add(new Object[]{new User()
                    .withName(splitLine[0])
                    .withLastName(splitLine[1])
                    .withEmail(splitLine[2])
                    .withPassword(splitLine[3])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}
