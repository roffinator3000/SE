/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      11:51
  Time spent:    2.2 h
*/
package Auto;

import java.util.Date;

public class Auto implements AutoIF{
    private int nummerschild;
    private Date zeitreinfahren;
    private long zeitaufenhalt;
    private int kosten;
    private String tickehash;
    private String farbcode;
    private int parkplatznummer;
    private String kundetyp;
    private String menschenart;

    public Auto(int nummerschild,Date zeitreinfahren,String tickehash,String farbcode,String kundentyp,String menschenart){
        this.nummerschild=nummerschild;
        this.zeitreinfahren=zeitreinfahren;
        this.tickehash=tickehash;
        this.farbcode=farbcode;
        this.menschenart = menschenart;
        this.kundetyp = kundentyp;
    }
    public void ausfahrt(long zeitaufenhalt,int parkplatznummer){
        this.kosten = (int) ((zeitaufenhalt * 2.9) / 5);
        this.zeitaufenhalt = zeitaufenhalt;
        this.parkplatznummer=parkplatznummer;
    }
    public int getNummerschild() {
        return nummerschild;
    }

    public Date getZeitreinfahren() {
        return zeitreinfahren;
    }

    public long getZeitaufenhalt() {
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
    
    public String getKundentyp() {
        return kundetyp;
    }
}
