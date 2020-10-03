/*
  Author:      L.Daskin
  Coauthor:    
  Refactoring:  
  Date:      04.09.20
  Time:      17:23
  Time spent:    0.0 h  
*/
package Auto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTest {

        static Auto a1;
        @BeforeAll
        static void test1(){
            a1 = new Auto(23,new Date(),"#aaddjaj","#HkfjJ1","Firmenkunde","Frau");


        }

        @Test
        void test_nummerschild(){
            assertEquals(23,a1.getNummerschild());
        }
        @Test
        void test_zeitreinfahren(){
            assertEquals(123311,a1.getZeitreinfahren());
        }

        @Test
        void test_Tickehash(){
            assertEquals("#aaddjaj",a1.getTickehash());
        }

        @Test
        void test_Farbcode(){
        assertEquals("#HkfjJ1",a1.getFarbcode());
        }

}
