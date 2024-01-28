package com.example;

public class PeopleDto {
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getO_mnie() {
        return o_mnie;
    }

    public void setO_mnie(String o_mnie) {
        this.o_mnie = o_mnie;
    }

    public String getUlubiona_postac_z_kapitana_bomby() {
        return ulubiona_postac_z_kapitana_bomby;
    }

    public void setUlubiona_postac_z_kapitana_bomby(String ulubiona_postac_z_kapitana_bomby) {
        this.ulubiona_postac_z_kapitana_bomby = ulubiona_postac_z_kapitana_bomby;
    }

    public String getUlubiony_serial() {
        return ulubiony_serial;
    }

    public void setUlubiony_serial(String ulubiony_serial) {
        this.ulubiony_serial = ulubiony_serial;
    }

    public String getUlubiony_film() {
        return ulubiony_film;
    }

    public void setUlubiony_film(String ulubiony_film) {
        this.ulubiony_film = ulubiony_film;
    }

    public String getUlubiony_kolor() {
        return ulubiony_kolor;
    }

    @Override
    public String toString() {
        return "" +
                "mam na imie " + imie +
                ", na nazwisko " + nazwisko +
                ", moj wiek " + wiek +
                ", o_mnie: " + o_mnie +
                ", ulubiona postac z kapitana bomby " + ulubiona_postac_z_kapitana_bomby +
                ", ulubiony serial " + ulubiony_serial +
                ", ulubiony film " + ulubiony_film +
                ", ulubiony kolor " + ulubiony_kolor;
    }

    public void setUlubiony_kolor(String ulubiony_kolor) {
        this.ulubiony_kolor = ulubiony_kolor;
    }

    private String imie;
    private String nazwisko;
    private int wiek;
    private String o_mnie;
    private String ulubiona_postac_z_kapitana_bomby;
    private String ulubiony_serial;
    private String ulubiony_film;
    private String ulubiony_kolor;

    // Getters and Setters
}
