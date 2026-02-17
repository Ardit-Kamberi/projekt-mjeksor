
package com.medicalsystem.model;

public class Pacient {
    private int id;
    private String emri;
    private String mbiemri;
    private int mosha;
    private String gjinia;
    private String historikuMjekesor;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmri() { return emri; }
    public void setEmri(String emri) { this.emri = emri; }

    public String getMbiemri() { return mbiemri; }
    public void setMbiemri(String mbiemri) { this.mbiemri = mbiemri; }

    public int getMosha() { return mosha; }
    public void setMosha(int mosha) { this.mosha = mosha; }

    public String getGjinia() { return gjinia; }
    public void setGjinia(String gjinia) { this.gjinia = gjinia; }

    public String getHistorikuMjekesor() { return historikuMjekesor; }
    public void setHistorikuMjekesor(String historikuMjekesor) { this.historikuMjekesor = historikuMjekesor; }
}
