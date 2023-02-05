package br.com.visualnuts.api.models;

import java.util.List;

public class Country {

    private String country;
    private List<String> languages;

    public Country(String country, List<String> languages) {
        this.country = country;
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
