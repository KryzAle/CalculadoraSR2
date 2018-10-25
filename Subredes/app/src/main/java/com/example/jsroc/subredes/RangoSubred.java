package com.example.jsroc.subredes;

public class RangoSubred {
    private String inicio;
    private String fin;
    private String mascaradecimal;
    private String mascaraslash;

    public RangoSubred(String inicio, String fin, String mascaradecimal, String mascaraslash) {
        this.inicio = inicio;
        this.fin = fin;
        this.mascaradecimal = mascaradecimal;
        this.mascaraslash = mascaraslash;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getMascaradecimal() {
        return mascaradecimal;
    }

    public void setMascaradecimal(String mascaradecimal) {
        this.mascaradecimal = mascaradecimal;
    }

    public String getMascaraslash() {
        return mascaraslash;
    }

    public void setMascaraslash(String mascaraslash) {
        this.mascaraslash = mascaraslash;
    }

    @Override
    public  String toString(){return this.inicio+"\n"+this.fin+"\n"+this.mascaradecimal+"\n"+this.mascaraslash;}
}
