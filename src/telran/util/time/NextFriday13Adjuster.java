package telran.util.time;
//HW_23 

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13Adjuster implements TemporalAdjuster {
	private static final int DAY13=13;

	
/*	
 // VARIANT 1, watched at the webinar, on a million repetitions it works 4 seconds
	@Override
	public Temporal adjustInto(Temporal temporal) {
		temporal=getNearest13Day(temporal);
		while(DayOfWeek.from(temporal) != DayOfWeek.FRIDAY){
			temporal=temporal.plus(1, ChronoUnit.MONTHS);
		}
		return temporal;
	}
	// get nearest date with DAY_OF_MOTNTH equals 13
	private Temporal getNearest13Day(Temporal temporal) {
		if(temporal.get(ChronoField.DAY_OF_MONTH) >= 13) {
			temporal = temporal.plus(1, ChronoUnit.MONTHS);
		}
		temporal = temporal.with(ChronoField.DAY_OF_MONTH, 13);
		return temporal;
	}
*/
	
/*
 // VARIANT 2, I wrote it with a minimum of methods and without methods for TEMPORAL, 7 seconds work on a million repetitions
		@Override
	public Temporal adjustInto(Temporal temporal) {
//		LocalDate date = LocalDate.from(temporal);
		LocalDate date = (LocalDate) temporal;
		while ((date.getDayOfMonth() != DAY13) ||
		(date.getDayOfWeek() != DayOfWeek.FRIDAY)) date=date.plusDays(1);
	return temporal.with(date);
	}
*/
	
	 // VARIANT 3, I wrote it with a minimum of methods for TEMPORAL, 10 seconds work on a million repetitions
	@Override
	public Temporal adjustInto(Temporal temporal) {
			
	//		while((temporal.get(ChronoField.DAY_OF_MONTH) != 13)||
	//			( DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)) != DayOfWeek.FRIDAY))	temporal = temporal.plus(1, ChronoUnit.DAYS);
			
		// temporal.get(ChronoField.DAY_OF_WEEK) - integer Monday=1, Friday=5!!!!!!
		while((temporal.get(ChronoField.DAY_OF_MONTH) != 13)||
					((temporal.get(ChronoField.DAY_OF_WEEK)) != 5))	temporal = temporal.plus(1, ChronoUnit.DAYS);
		return temporal;
		}
	
}
