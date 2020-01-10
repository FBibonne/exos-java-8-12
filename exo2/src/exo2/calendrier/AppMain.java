package exo2.calendrier;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;

public class AppMain {
	
	private static Logger logger=Logger.getLogger(AppMain.class.getSimpleName());

	public static void main(String[] args) {
		
		if (args.length==3) {
			final int year= Integer.valueOf(args[2]);
			final int month = Integer.valueOf(args[1]);
			final int dayOfMonth = Integer.valueOf(args[0]);
			LocalDate birthday=LocalDate.of(year, month, dayOfMonth);
			LocalDate today=LocalDate.now();
			Period periode=Period.between(birthday, today);
			logger.info("age = "+periode.getYears());
		}else {
			logger.severe("USAGE : java --module exo2.clendrier.AppMain <jour> <mois> <annee>");
		}

	}

}
