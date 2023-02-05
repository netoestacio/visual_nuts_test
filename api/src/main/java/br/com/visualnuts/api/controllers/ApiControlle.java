package br.com.visualnuts.api.controllers;

import br.com.visualnuts.api.models.Country;
import br.com.visualnuts.api.models.ResponseModel;
import br.com.visualnuts.api.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiControlle {
    @Autowired
    private ApiService service;
    @GetMapping
    public List<String> exec1(Integer number) {
        for(int i = 0; i < number; i++){
            this.service.validateNumber(i);
        }
        return null;
    }

    @PostMapping()
    public ResponseEntity exec2(@RequestBody List<Country> listCountry){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCountryCounts(this.service.getNumberOfCountries(listCountry));
        responseModel.setCountryMostEpaskGermany(this.service.getCountryWithMostLanguagesSpokenGerman(listCountry));
        responseModel.setCountryMostLang(this.service.getCountryWithMostLanguages(listCountry));
        responseModel.setCommonLang(this.service.getMostCommonLanguages(listCountry));
        responseModel.setTotalLangs(this.service.getTotalNumberOfLanguages(listCountry));
        return new ResponseEntity(responseModel, HttpStatus.OK);
    }

}
