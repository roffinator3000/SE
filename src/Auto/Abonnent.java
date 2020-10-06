/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      16:21
  Time spent:    10m
*/
package Auto;

public class Abonnent implements Kunde{
    @Override
    public int preisberechnen(long zeit) {
        int preisBerechnet = (int) ((zeit*2.5)/5);
        return preisBerechnet > 599 ? 599 : preisBerechnet;
    }
    
    @Override
    public String getKundenTyp(){
        return "Abonnent";
    }
}
