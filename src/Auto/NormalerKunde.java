/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      16:24
  Time spent:    10m
*/
package Auto;

public class NormalerKunde implements Kunde{
    @Override
    public int preisberechnen(long zeit) {
        return (int) ((zeit*2.9)/5);
    }
    
    @Override
    public String getKundenTyp() {
        return "NormalerKunde";
    }
}
