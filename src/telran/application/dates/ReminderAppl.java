package telran.application.dates;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

//HW_25_IlyaL
public class ReminderAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//args[0] - mandatory interval of beeps 
		//args[1] - mandatory ChronoUnit (according to time units of ChronoUnit)
		//args[2] - optional in ChronoUnit values when to end up beeps (default) 1 hour
		//args[3] - optional in ChronoUnit values when to start beeping (default immediately )
		//beep - System.out.println("\007")
		int start = getStart(args);
		int stop = getStop(args);
		int interv = getInterv(args);
		Instant instant = Instant.now();
		LocalDateTime ltd = LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
		long intl=interv;
		waitingFor(intl);
		
		

	}
	private static int getInterv(String[] args) {
		return Integer.parseInt(args[2]);
	}
	private static int getStop(String[] args) {
		return Integer.parseInt(args[1]);
	}
	private static int getStart(String[] args) {
		return Integer.parseInt(args[0]);
	}
	
	/**
	 * waiting for the given time period in milliseconds
	 * @param periodInMillis
	 */
	static void waitingFor(long periodInMillis) {
		//TODO
		//do/while cycle with using Instant objects and method ChronoUnit between
		Instant instant1 = Instant.now();
		LocalDateTime ltd1 = LocalDateTime.ofInstant(instant1,ZoneId.systemDefault());
		
	do {System.out.println("\007");
		
	} while( (Instant.now().toEpochMilli()-instant1.toEpochMilli())<periodInMillis  );
	
	}

}
