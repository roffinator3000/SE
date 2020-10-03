/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      16:24
  Time spent:    0.0 h  
*/
package Auto;

public class NormalerKunde implements Kunde{
    @Override
    public long preisberechnen(long zeit) {
        return zeit*3;
    }
}
