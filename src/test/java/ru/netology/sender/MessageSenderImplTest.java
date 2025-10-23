package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    GeoService geoService;
    MessageSender messageSender;
    LocalizationService localizationService;
    Map<String, String> headers = new HashMap<>();
    String expectedText;

    @BeforeEach
    void createMocks() {
        headers = new HashMap<>();
        geoService = Mockito.mock(GeoServiceImpl.class);
        localizationService = Mockito.mock(LocalizationServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }


    @Test
    void test_send_message_inRussian() {

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        expectedText = "Добро пожаловать";


        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        Assertions.assertEquals(expectedText, messageSender.send(headers));

    }

    @Test
    void test_send_message_inEnglish() {

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        expectedText = "Welcome";

        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, "10th Avenue", 10));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        Assertions.assertEquals(expectedText, messageSender.send(headers));
    }

}
