/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      16:21
  Time spent:    5m
*/
package Auto;

public class Abonnent implements Kunde{
    @Override
    public long preisberechnen(long zeit) {
        return zeit;
    }
}
