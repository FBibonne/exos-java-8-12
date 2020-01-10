package exo3;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> prenoms=Arrays.asList("Ludovic","Laurent", "Fabrice","Mathieu", "Lo�c", "Olivier", "Betty", "Benjamin","Simon", "Nicolas");
		/*prenoms.stream()
		    .forEach(p->System.out.println("  "+p));
		*/
		prenoms.stream()
		    .peek(System.out::print)
		    .map(String::length)
		    .forEach(System.out::println);
		

	}

}
