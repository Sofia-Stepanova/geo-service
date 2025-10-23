package ru.netology.locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;


public class LocalizationServiceImplTest {

    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void try_locale_return_correct_value_eng() {

        String expectedText = "Welcome";
        Assertions.assertEquals(expectedText, localizationService.locale(Country.USA));
    }

    @Test
    void try_locale_return_correct_value_ru() {

        String expectedText = "Добро пожаловать";
        Assertions.assertEquals(expectedText, localizationService.locale(Country.RUSSIA));
    }
}
