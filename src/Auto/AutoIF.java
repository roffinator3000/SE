/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      11:34
  Time spent:    0.2 h
*/
package Auto;

public interface AutoIF {
     int getNummerschild();

     int getZeitreinfahren();

     int getZeitaufenhalt();

     int getKosten();

     String getTickehash();

     String getFarbcode();

     int getParkplatznummer();

     void setZeitaufenhalt(int zeitaufenhalt);

     void setParkplatznummer(int parkplatznummer);
}
