package model;

import java.util.ArrayList;

public class Universe {

	private static ArrayList<Character> characters = new ArrayList<Character>();
	private static ArrayList<Character> monsters = new ArrayList<Character>();

	public static ArrayList<Character> getCharacters() {
		return characters;
	}
	
	public static ArrayList<Character> getMonsters() {
		return monsters;
	}

	public static void creation() {
		
		Character ashoka = new Character("Ashoka", 300, 40, "ashoka", 0.4);
		characters.add(ashoka);
		
		Character luke = new Character("Luke", 30, 40, "luke", 0.4);
		characters.add(luke);
		
		Character obiwan = new Character("ObiWan", 300, 40, "obiwan", 0.4);
		characters.add(obiwan);
		
		Character quigon = new Character("QuiGon", 300, 40, "quigon", 0.4);
		characters.add(quigon);
		
		Character windu = new Character("Windu", 300, 40, "windu", 0.4);
		characters.add(windu);
		
		Character yoda = new Character("Yoda", 300, 300, "yoda", 0.4);
		characters.add(yoda);
		
		Character darthmaul = new Character("DarthMaul", 300, 40, "darkmaul", 0.4);
		monsters.add(darthmaul);
		
		Character dooku = new Character("Dooku", 300, 40, "dooku", 0.4);
		monsters.add(dooku);
		
		Character grievous = new Character("Grievous", 300, 40, "grievous", 0.4);
		monsters.add(grievous);
		
		Character palpatine = new Character("Palpatine", 300, 40, "palpatine", 0.4);
		monsters.add(palpatine);
		
		Character vador = new Character("Vader", 300, 40, "vador", 0.4);
		monsters.add(vador);
		
		/*
		Character nain = new Character();
		nain.setName("Gimli");
		nain.setHpMax(150);
		nain.setAttack(25);
		characters.add(nain);

		Character elf = new Character();
		elf.setName("Legolas");
		elf.setHpMax(30);
		elf.setAttack(15);
		elf.setDodgePercent(50);
		characters.add(elf);

		Character rat = new Character();
		rat.setName("rat");
		rat.setHpMax(20);
		rat.setAttack(2);
		monsters.add(rat);

		Character gobelin = new Character();
		gobelin.setName("gobelin");
		gobelin.setHpMax(80);
		gobelin.setAttack(10);
		monsters.add(gobelin);		

		Character dragon = new Character("dragon", 3000, 100, );
		monsters.add(dragon);*/

	}

}
