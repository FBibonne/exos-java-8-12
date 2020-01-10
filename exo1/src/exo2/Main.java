package exo2;

import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	
	public static class Ligne{
		private String contenu;

		public String getContenu() {
			return contenu;
		}

		public void setContenu(String contenu) {
			this.contenu = contenu;
		}
		
		
	}

	public static class MonthsInYear {
		public static void display(int annee) {
			Year year = Year.of(annee);
			/*
			 * Arrays.stream(Month.values()).map(year::atMonth)
			 * .mapToInt(YearMonth::lengthOfMonth) .forEach(System.out::println);
			 */
			Formatter formatter = new Formatter();
			Ligne ligne=new Ligne();
			Arrays.stream(Month.values()).map(year::atMonth).forEach(m -> ligne.setContenu(formatter.format("%s : %d \r\n",
					m.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH), m.lengthOfMonth()).toString()));
			formatter.close();
		}
	}

	public static void main(String[] args) {
		//MonthsInYear.display(2020);
		System.out.println(calculerPremiers(100));
	}
	
	
	public static List<Integer> calculerPremiers(int n){
		List<Integer> nombres=IntStream.range(2, 100).mapToObj(Integer::valueOf).collect(Collectors.toList());
		List<Integer> premiers=new ArrayList<>();
		nombres.stream().filter(x->premiers.stream().filter(p -> ( x % p)==0).count()==0).forEach(premiers::add);
		return premiers;
	}

}
