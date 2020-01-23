package test.example1;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;

public class MainClass {
	public static void main(String[] args) {
		WeaponImpl w1=new WeaponImpl();
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.attack();
	}
}
