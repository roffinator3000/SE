/*
	Author:			C. Schirmacher
	Coauthor:
	Refactoring:
	Date:			19.09.2020
	Time:			15:49
	Time spent:		1.25 h
*/
package Parkhaus;

import Auto.Auto;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Parkhaustest {
	
	@BeforeAll
	public static void pre(){				//wird einmal vor allen Tests ausgefuehrt
	}
	
	@BeforeEach
	public void start(){					//wird vor jedem einzelnen Test neu ausgefuehrt
	}
	
	//	@Order(1)
	@Test
	public void Test1(){
		Parkhaus parkhaus = new Parkhaus();
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertTrue(autosEingefahren.isEmpty());
		assertTrue(autosAusgefahren.isEmpty());
		
	}
	
	//	@Order(2)
	@Test
	public void Test2(){
		Parkhaus parkhaus = new Parkhaus();
		String[] auto = new String[20];
		auto[1] = "233";
		auto[2] = "123";//Darstellung?
		auto[5] = "#2346";
		auto[6] = "4536";
		auto[8] = "Abbonent";
		auto[9] = "Familie";
		
		parkhaus.autoEnter(auto);
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertFalse(autosEingefahren.isEmpty());
		assertTrue(autosAusgefahren.isEmpty());
		assertEquals(1, autosEingefahren.size());
		
		
	}
	
	//	@Order(3)
	@Test
	public void Test3(){
		Parkhaus parkhaus = new Parkhaus();
		String[] auto = new String[20];
		auto[1] = "233";
		auto[2] = "123";//Darstellung?
		auto[3] = "356";
		auto[5] = "#2346";
		auto[6] = "4536";
		auto[7] = "5";
		auto[8] = "Abbonent";			//in Autos umändern
		auto[9] = "Familie";
		
		parkhaus.autoEnter(auto);
		parkhaus.autoLeave(auto);
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertTrue(autosEingefahren.isEmpty());
		assertFalse(autosAusgefahren.isEmpty());
		assertEquals(0, autosEingefahren.size());
		assertEquals(1,autosAusgefahren.size());
		
	}
	@Test
	public void Test4(){
		Parkhaus parkhaus = new Parkhaus();
		String[] auto1 = new String[20];
		auto1[1] = "233";
		auto1[2] = "123";//Darstellung?
		auto1[3] = "356";
		auto1[5] = "#27467898";
		auto1[6] = "4536";
		auto1[7] = "5";
		auto1[8] = "Abbonent";			//in Autos umändern
		auto1[9] = "Familie";
		
		String[] auto2 = new String[20];
		auto2[1] = "243";
		auto2[2] = "123";//Darstellung?
		auto2[3] = "356";
		auto2[5] = "#2789964356";
		auto2[6] = "4536";
		auto2[7] = "5";
		auto2[8] = "Abbonent";			//in Autos umändern
		auto2[9] = "Familie";
		
		String[] auto3 = new String[20];
		auto3[1] = "253";
		auto3[2] = "123";//Darstellung?
		auto3[3] = "356";
		auto3[5] = "#2890346";
		auto3[6] = "4536";
		auto3[7] = "5";
		auto3[8] = "Abbonent";			//in Autos umändern
		auto3[9] = "Familie";
		
		parkhaus.autoEnter(auto1);
		parkhaus.autoLeave(auto1);
		parkhaus.autoEnter(auto2);
		parkhaus.autoLeave(auto2);
		parkhaus.autoEnter(auto3);
		parkhaus.autoLeave(auto3);
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertTrue(autosEingefahren.isEmpty());
		assertFalse(autosAusgefahren.isEmpty());
		assertEquals(0, autosEingefahren.size());
		assertEquals(3,autosAusgefahren.size());
		
	}
	@Test
	public void Test5(){
		Parkhaus parkhaus = new Parkhaus();
		String[] auto1 = new String[20];
		auto1[1] = "233";
		auto1[2] = "123";//Darstellung?
		auto1[3] = "356";
		auto1[5] = "#27467898";
		auto1[6] = "4536";
		auto1[7] = "5";
		auto1[8] = "Abbonent";			//in Autos umändern
		auto1[9] = "Familie";
		
		String[] auto2 = new String[20];
		auto2[1] = "243";
		auto2[2] = "123";//Darstellung?
		auto2[3] = "356";
		auto2[5] = "#2789964356";
		auto2[6] = "4536";
		auto2[7] = "5";
		auto2[8] = "Abbonent";			//in Autos umändern
		auto2[9] = "Familie";
		
		String[] auto3 = new String[20];
		auto3[1] = "253";
		auto3[2] = "123";//Darstellung?
		auto3[3] = "356";
		auto3[5] = "#2890346";
		auto3[6] = "4536";
		auto3[7] = "5";
		auto3[8] = "Abbonent";			//in Autos umändern
		auto3[9] = "Familie";
		
		parkhaus.autoEnter(auto1);
		parkhaus.autoEnter(auto3);
		parkhaus.autoEnter(auto2);
		parkhaus.autoLeave(auto1);
		parkhaus.autoLeave(auto2);
		parkhaus.autoLeave(auto3);
	
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertTrue(autosEingefahren.isEmpty());
		assertFalse(autosAusgefahren.isEmpty());
		assertEquals(0, autosEingefahren.size());
		assertEquals(3,autosAusgefahren.size());
		
	}
	@Test
	public void Test6(){
		Parkhaus parkhaus = new Parkhaus();
		String[] auto1 = new String[20];
		auto1[1] = "233";
		auto1[2] = "123";//Darstellung?
		auto1[3] = "356";
		auto1[5] = "#27467898";
		auto1[6] = "4536";
		auto1[7] = "5";
		auto1[8] = "Abbonent";			//in Autos umändern
		auto1[9] = "Familie";
		
		String[] auto2 = new String[20];
		auto2[1] = "243";
		auto2[2] = "123";//Darstellung?
		auto2[3] = "356";
		auto2[5] = "#2789964356";
		auto2[6] = "4536";
		auto2[7] = "5";
		auto2[8] = "Abbonent";			//in Autos umändern
		auto2[9] = "Familie";
		
		String[] auto3 = new String[20];
		auto3[1] = "253";
		auto3[2] = "123";//Darstellung?
		auto3[3] = "356";
		auto3[5] = "#2890346";
		auto3[6] = "4536";
		auto3[7] = "5";
		auto3[8] = "Abbonent";			//in Autos umändern
		auto3[9] = "Familie";
		
		parkhaus.autoEnter(auto1);
		parkhaus.autoEnter(auto3);
		parkhaus.autoEnter(auto2);
		parkhaus.autoLeave(auto1);
		parkhaus.autoLeave(auto3);
		
		ArrayList<Auto>[] alleAutos = parkhaus.gibAutos();
		ArrayList<Auto>autosEingefahren = alleAutos[1];
		ArrayList<Auto>autosAusgefahren = alleAutos[0];
		
		assertFalse(autosEingefahren.isEmpty());
		assertFalse(autosAusgefahren.isEmpty());
		assertEquals(1, autosEingefahren.size());
		assertEquals(2,autosAusgefahren.size());
		
	}
	@AfterEach
	public void end(){						//wird nach jedem einzelnen Test ausgefuehrt
	}
	
	@AfterAll
	public static void post(){				//wird einmal nach allen Tests ausgefuehrt
	}
}
