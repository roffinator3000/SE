/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      11:34
  Time spent:    20m
*/
package Auto;

import java.util.Date;

public interface AutoIF {
     int getNummerschild();

     Date getZeitreinfahren();

     long getZeitaufenhalt();

     int getKosten();

     String getTickehash();

     String getFarbcode();

     int getParkplatznummer();

     void setZeitaufenhalt(int zeitaufenhalt);

     void setParkplatznummer(int parkplatznummer);
}
