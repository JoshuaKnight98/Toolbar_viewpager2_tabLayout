package com.example.tabby.models;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class Country {

    private String nameCountry;
    private String codeCountry;

    public Country(String nameCountry, String codeCountry) {
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getFlagUrl(String code) {
        return "http://www.geognos.com/api/en/countries/flag/"+code+".png";
    }

    @Override
    public String toString() {
        return nameCountry;
    }
}
