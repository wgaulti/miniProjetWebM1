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
		
		Character ashoka = new Character("Ashoka Tano", 300, 40, "ashoka.png", 0.4);
		characters.add(ashoka);
		
		Character luke = new Character("Luke Skywalker", 300, 40, "luke.png", 0.4);
		characters.add(luke);
		
		Character obiwan = new Character("Obi-Wan Kenobi", 300, 40, "obiwan.png", 0.4);
		characters.add(obiwan);
		
		Character quigon = new Character("Qui-Gon Jinn", 300, 40, "quigon.png", 0.4);
		characters.add(quigon);
		
		Character windu = new Character("Mace Windu", 300, 40, "windu.png", 0.4);
		characters.add(windu);
		
		Character yoda = new Character("Yoda", 300, 40, "ashoka.png", 0.4);
		characters.add(yoda);
		
		Character darthmaul = new Character("Darth Maul", 300, 40, "darkmaul.png", 0.4);
		monsters.add(darthmaul);
		
		Character dooku = new Character("Count Dooku", 300, 40, "dooku.png", 0.4);
		monsters.add(dooku);
		
		Character grievous = new Character("General Grievous", 300, 40, "grievous.png", 0.4);
		monsters.add(grievous);
		
		Character palpatine = new Character("Emperor Palpatine", 300, 40, "palpatine.png", 0.4);
		monsters.add(palpatine);
		
		Character vador = new Character("Darth Vader", 300, 40, "vador.png", 0.4);
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
