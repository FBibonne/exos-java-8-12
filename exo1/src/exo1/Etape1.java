package exo1;

import java.util.Arrays;

public class Etape1 implements Etape {
	
	private Runnable runnable=()->System.out.println("Exercice1.Etape1");
	
	public void test() {
		runnable.run();
		//ajouter � la m�thode main une variable strString qui est un tableau de String initialis�e
		//avec les pr�noms des stagiaires de la salle.
		String[] strString= {"Ludovic","Laurent", "Fabrice","Mathieu", "Lo�c", "Olivier", "Betty", "Benjamin","Simon", "Nicolas"};
		 //Ensuite, il est demand� de trier les �l�ments de ce tableau � l�aide de la classe Arrays et de sa m�thode sort
		Arrays.sort(strString, (s1,s2)->(mirroir(s1)).compareTo(mirroir(s2)) );
		System.out.println(Arrays.toString(strString));
	}

	private static String mirroir(String s1) {
		// TODO Auto-generated method stub
		return s1;
	}

}
