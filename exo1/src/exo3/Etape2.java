package exo3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Compter les occurences des mots de Sherlock.txt en ottant au pr�alable les
 * mots du flux json stop-words-en.json
 * 
 *
 */
public class Etape2 {
	
	public static class JsonFilter{
		
		private Set<String> stopWords;

		public JsonFilter(String pathname) throws IOException {
			stopWords=Files.lines(Paths.get(pathname))
					       .flatMap(s -> Arrays.stream(s.split("[|\"|,|]")))
					       .filter(m->m.length()>1)
					       .collect(Collectors.toSet())
					       ;
			
		}
		
		public boolean filtrer(String mot) {
			return !stopWords.contains(mot);
		}
	}

	public static void main(String[] args) throws IOException {
		//Map<String, Integer> nathalie = new HashMap<>();
		JsonFilter jsonFilter=new JsonFilter("C:\\Users\\Public\\stop-words-en.json");
		Files.lines(Paths.get("C:\\Users\\Public\\sherlock.txt"))
			.flatMap(s -> Arrays.stream(s.split(" |,|\\.|;|\\)|\\(|\\?|:|!|�|�|_|�|�|\\d|\"|�|/")))
			.filter(m->m.length()>1)
			.map(String::toLowerCase)
			.filter(jsonFilter::filtrer)
			/*.forEach(s -> nathalie.merge(s, 1, (n, m) -> n + 1));
		;
		System.out.println(nathalie);*/
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEach(entry->System.out.printf("\n%s -> %d",entry.getKey(), entry.getValue()));
	}

}
