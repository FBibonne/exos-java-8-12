package exo1;

import java.util.Arrays;

public class Main {
	
	private static Etape[] etapes= {new Etape1(), new Etape3(), new Etape4(), new Etape2()};

	public static void main(String[] args) {
		Arrays.stream(etapes).forEach(Etape::test);
	}

}
