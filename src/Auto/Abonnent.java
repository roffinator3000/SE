/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      16:21
  Time spent:    0.0 h  
*/
package Auto;

public class Abonnent implements Kunde{
    @Override
    public int preisberechnen(int zeit) {
        return zeit*2;
    }
}
