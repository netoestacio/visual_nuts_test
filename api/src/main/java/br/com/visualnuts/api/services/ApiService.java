package br.com.visualnuts.api.services;

import br.com.visualnuts.api.models.Country;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApiService {

    private List<Country> countries;

    public ApiService(List<Country> countries) {
        this.countries = countries;
    }
    public String validateNumber(Integer number){

            if (number % 3 == 0 && number % 5 == 0) {
                return "Visual Nuts";
            } else if (number % 3 == 0) {
                return "Visual";
            } else if (number % 5 == 0) {
                return "Nuts";
            } else {
                return number.toString();
            }

    }

    public int getNumberOfCountries(List<Country> countries) {
        return countries.size();
    }

    public String getCountryWithMostLanguagesSpokenGerman(List<Country> countries) {
        String countryWithMostLanguagesSpokenGerman = null;
        int maxLanguagesSpokenGerman = 0;
        for (Country country : countries) {
            List<String> languages = country.getLanguages();
            int countLanguagesSpokenGerman = 0;
            for (String language : languages) {
                if (language.equals("de")) {
                    countLanguagesSpokenGerman++;
                }
            }
            if (countLanguagesSpokenGerman > maxLanguagesSpokenGerman) {
                maxLanguagesSpokenGerman = countLanguagesSpokenGerman;
                countryWithMostLanguagesSpokenGerman = country.getCountry();
            }
        }
        return countryWithMostLanguagesSpokenGerman;
    }

    public int getTotalNumberOfLanguages(List<Country> countries) {
        int totalLanguages = 0;
        for (Country country : countries) {
            totalLanguages += country.getLanguages().size();
        }
        return totalLanguages;
    }

    public String getCountryWithMostLanguages(List<Country> countries) {
        String countryWithMostLanguages = null;
        int maxLanguages = 0;
        for (Country country : countries) {
            int numberOfLanguages = country.getLanguages().size();
            if (numberOfLanguages > maxLanguages) {
                maxLanguages = numberOfLanguages;
                countryWithMostLanguages = country.getCountry();
            }
        }
        return countryWithMostLanguages;
    }

    public List<String> getMostCommonLanguages(List<Country> countries) {
        Map<String, Integer> languageCounts = new HashMap<>();
        for (Country country : countries) {
            for (String language : country.getLanguages()) {
                if (!languageCounts.containsKey(language)) {
                    languageCounts.put(language, 1);
                } else {
                    languageCounts.put(language, languageCounts.get(language) + 1);
                }
            }
        }
        int maxLanguageCount = Collections.max(languageCounts.values());
        List<String> mostCommonLanguages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : languageCounts.entrySet()) {
            if (entry.getValue() == maxLanguageCount) {
                mostCommonLanguages.add(entry.getKey());
            }
        }
        return mostCommonLanguages;
    }
}
