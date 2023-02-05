package br.com.visualnuts.api.services;

import br.com.visualnuts.api.models.Country;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ApiServiceTest {

    @InjectMocks
    private ApiService service;
    @Test
    public void testNumberDivisibleBy3() {
        assertEquals("Visual", service.validateNumber(3));
    }

    @Test
    public void testNumberDivisibleBy5() {
        assertEquals("Nuts", service.validateNumber(5));
    }

    @Test
    public void testNumberDivisibleByBoth() {
        assertEquals("Visual Nuts", service.validateNumber(15));
    }

    @Test
    public void testGetNumberOfCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Germany", Arrays.asList("de")));
        countries.add(new Country("France", Arrays.asList("fr")));
        countries.add(new Country("Spain", Arrays.asList("es")));
        int expected = 3;
        int actual = service.getNumberOfCountries(countries);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCountryWithMostLanguagesSpokenGerman() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Germany", Arrays.asList("de")));
        countries.add(new Country("France", Arrays.asList("fr")));
        countries.add(new Country("Spain", Arrays.asList("es", "de")));
        String expected = "Germany";
        String actual = service.getCountryWithMostLanguagesSpokenGerman(countries);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTotalNumberOfLanguages() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Germany", Arrays.asList("de")));
        countries.add(new Country("France", Arrays.asList("fr")));
        countries.add(new Country("Spain", Arrays.asList("es", "de")));
        int expected = 4;
        int actual = service.getTotalNumberOfLanguages(countries);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCountryWithMostLanguages() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Germany", Arrays.asList("de")));
        countries.add(new Country("France", Arrays.asList("fr", "en")));
        countries.add(new Country("Spain", Arrays.asList("es", "de")));
        String expected = "France";
        String actual = service.getCountryWithMostLanguages(countries);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMostCommonLanguages() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Germany", Arrays.asList("de")));
        countries.add(new Country("France", Arrays.asList("fr", "en")));
        countries.add(new Country("Spain", Arrays.asList("es")));
        List<String> expectedMostCommonLanguages = Arrays.asList("de", "fr", "en", "es");
        List<String> actualMostCommonLanguages = service.getMostCommonLanguages(countries);

        assertEquals(expectedMostCommonLanguages.size(), actualMostCommonLanguages.size());
        for (String language : expectedMostCommonLanguages) {
            assertTrue(actualMostCommonLanguages.contains(language));
        }
    }
}
