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
	
	@Override
	
/*	
 // VARIANT 1, watched at the webinar, on a million repetitions it works 4 seconds
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

 // VARIANT 2, I wrote it with a minimum of methods, 7 seconds work on a million repetitions
	public Temporal adjustInto(Temporal temporal) {
		LocalDate date = LocalDate.from(temporal);
		while ((date.getDayOfMonth() != DAY13) ||
		(date.getDayOfWeek() != DayOfWeek.FRIDAY)) date=date.plusDays(1);
	return temporal.with(date);
	}


}
