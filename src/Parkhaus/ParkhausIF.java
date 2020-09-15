package Parkhaus;/*
	Author:			C. Schirmacher
	Coauthor:		
	Refactoring:	
	Date:			01.09.2020
	Time:			20:08
	Time spent:		0.2 h
*/
import java.util.List;
import Auto.Auto;

public interface ParkhausIF {
	
	void autoEnter(String[] neuesAuto);
	void autoLeave(String[] altesAuto);
	int[][] gibDaten();
	List<Auto>[] gibAutos();
}
