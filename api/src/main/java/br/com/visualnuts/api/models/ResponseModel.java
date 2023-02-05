package br.com.visualnuts.api.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private Integer countryCounts;
    private String countryMostLang;
    private String countryMostEpaskGermany;
    private Integer totalLangs;
    private List<String> commonLang;




}
