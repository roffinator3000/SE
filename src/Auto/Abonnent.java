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
        return (int) zeit/5;
    }
    
    @Override
    public String getKundenTyp(){
        return "Abonnent";
    }
}
