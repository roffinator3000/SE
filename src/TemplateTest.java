/*
	Author:		R. Kuhn
	Date:		08.08.2020
	Time:		15:03
*/

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TemplateTest{
 
	@BeforeAll
	public static void pre(){				//wird einmal vor allen Tests ausgefuehrt
	}

	@BeforeEach
	public void start(){					//wird vor jedem einzelnen Test neu ausgefuehrt
	}

	//	@Order(1)
	@Test
	public void Test1(){
		assertTrue(true);			//kann helfen, alles halbmanuell zu testen, Fehler werden aber schwerer erkennbar
		assertFalse(false);
	}

	//	@Order(2)
	@Test
	public void Test2(){
		assertSame(1, 1);		//testet, ob das SELBE Objekt uebergeben wird, funktioniert bei primitiven auch so
	}

	//	@Order(3)
	@Test
	public void Test3(){
		assertEquals("HALLO", "Hallo".toUpperCase());	//testet, ob das GLEICHE Objekt uebergeben wird
	}

	@AfterEach
	public void end(){						//wird nach jedem einzelnen Test ausgefuehrt
	}

	@AfterAll
	public static void post(){				//wird einmal nach allen Tests ausgefuehrt
	}
}
