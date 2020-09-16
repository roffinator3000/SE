/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      11:51
  Time spent:    2.0 h
*/

public class Auto {
    private int nummerschild;
    private int zeitreinfahren;
    private int zeitaufenhalt;
    private int kosten;
    private String tickehash;
    private String farbcode;
    private int parkplatznummer;
    private Kunde kundetyp;
    private String menschenart;

    public Auto(int nummerschild,int zeitreinfahren,String tickehash,String farbcode,String kundentyp,String menschenart){
        this.nummerschild=nummerschild;
        this.zeitreinfahren=zeitreinfahren;
        this.tickehash=tickehash;
        this.farbcode=farbcode;
        this.menschenart=menschenart;

        switch (kundentyp) {
            case "Normal" -> this.kundetyp = new NormalerKunde();
            case "Firmenkunde" -> this.kundetyp = new Firmenkunde();
            case ("Abbonent") -> this.kundetyp = new Abonnent();
        }
    }
    public void ausfahrt(int zeitaufenhalt,int parkplatznummer){
        this.kosten=this.kundetyp.preisberechnen(zeitaufenhalt);
        this.zeitaufenhalt=zeitaufenhalt;
        this.parkplatznummer=parkplatznummer;
    }
    public int getNummerschild() {
        return nummerschild;
    }

    public int getZeitreinfahren() {
        return zeitreinfahren;
    }

    public int getZeitaufenhalt() {
        return zeitaufenhalt;
    }

    public int getKosten() {
        return kosten;
    }

    public String getTickehash() {
        return tickehash;
    }

    public String getFarbcode() {
        return farbcode;
    }

    public int getParkplatznummer() {
        return parkplatznummer;
    }

    public void setZeitaufenhalt(int zeitaufenhalt) {
        this.zeitaufenhalt = zeitaufenhalt;
    }

    public void setParkplatznummer(int parkplatznummer) {
        this.parkplatznummer = parkplatznummer;
    }

    public String getMenschenart() {
        return menschenart;
    }
}
