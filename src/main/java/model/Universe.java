package model;

import java.util.ArrayList;

public class Universe {

	private static ArrayList<Character> jedis = new ArrayList<Character>();
	private static ArrayList<Character> siths = new ArrayList<Character>();

	public static ArrayList<Character> getJedis() {
		return jedis;
	}
	
	public static ArrayList<Character> getSiths() {
		return siths;
	}

	public static void creation() {
		
		// JEDIS
		
		Character ashoka = new Character("Ashoka", 180, 80, "ashoka", 0.6);
		jedis.add(ashoka);
		
		Character luke = new Character("Luke", 200, 100, "luke", 0.4);
		jedis.add(luke);
		
		Character obiwan = new Character("ObiWan", 250, 100, "obiwan", 0.3);
		jedis.add(obiwan);
		
		Character quigon = new Character("QuiGon", 300, 80, "quigon", 0.3);
		jedis.add(quigon);
		
		Character windu = new Character("Windu", 350, 100, "windu", 0.2);
		jedis.add(windu);
		
		Character yoda = new Character("Yoda", 90, 200, "yoda", 0.8);
		jedis.add(yoda);
		
		
		// SITHS
		
		Character darthmaul = new Character("DarthMaul", 150, 40, "darkmaul");
		siths.add(darthmaul);
		
		Character dooku = new Character("Dooku", 200, 60, "dooku");
		siths.add(dooku);
		
		Character grievous = new Character("Grievous", 200, 70, "grievous");
		siths.add(grievous);
		
		Character palpatine = new Character("Palpatine", 300, 80, "palpatine");
		siths.add(palpatine);
		
		Character vador = new Character("Vader", 400, 100, "vador");
		siths.add(vador);
		

	}

}
