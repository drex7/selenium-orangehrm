package data;

import com.github.javafaker.Faker;
import config.Configuration;
import config.ConfigurationManager;
import java.util.Locale;
import java.util.Random;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.log4j.Log4j2;

import model.UserData;

@Log4j2
public class UserDataFactory {

    private final Faker faker;
    private final Dotenv dotenv;
    public UserDataFactory() {
        Configuration configuration = ConfigurationManager.getConfiguration();

        faker = new Faker(Locale.of("en"));
        dotenv = Dotenv.load();
    }

    public UserData createUserData() {
        UserData userData = UserData.builder().
                email(faker.internet().emailAddress()).
                invalidUsername(faker.internet().emailAddress()).
                validUsername(dotenv.get("VALID_USERNAME")).

                validPassword(dotenv.get("PASSWORD")).
                invalidPassword(faker.internet().password()).
                build();
//                country(returnRandomCountry()).
        return userData;
    }

    private String returnRandomCountry() {
        return returnRandomItemOnArray(new String[]{"Belgium", "Brazil", "Netherlands"});
    }

    private String returnDailyBudget() {
        return returnRandomItemOnArray(new String[]{"$100", "$100 - $499", "$499 - $999", "$999+"});
    }

    private String returnRandomItemOnArray(String[] array) {
        return array[(new Random().nextInt(array.length))];
    }
}
