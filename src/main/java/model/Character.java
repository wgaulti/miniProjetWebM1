package model;

public class Character {

	private String name;
	private int hpMax;
	private int attack;
	private double dodgePercent = 0.05;

	public Character() {
	}
	

	public Character(String name, int hpMax, int attack) {
		super();
		this.name = name;
		this.hpMax = hpMax;
		this.attack = attack;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hp) {
		this.hpMax = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	

	public double getDodgePercent() {
		return dodgePercent;
	}


	public void setDodgePercent(double dodgePercent) {
		this.dodgePercent = dodgePercent/100;
	}


	@Override
	public String toString() {
		return name + ": hpMax=" + hpMax + ", attack=" + attack;
	}


}
