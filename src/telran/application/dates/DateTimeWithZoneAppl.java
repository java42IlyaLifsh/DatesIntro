package telran.application.dates;
//HW_25_IlyaL 2
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateTimeWithZoneAppl {

	static List<ZonedDateTime> timeZones = new ArrayList<>();
	
	public static void main(String[] args) {
	//args[0] - optional substring of time Zone (default - local time zone)
	// display out the time in the appropriate ZoneId
	
	//1 получить данные
	//2 проверить их на корректность и если нет распечатать хелп
	//3 трай кетч, в трае получить время в запрашиваемых зонах
	//3 распечатать полученные результаты
	//4 обработать рантайм эксепшн, распечатав стек ошибки функциональности
	//5 обработать чекэксепшн, распечатав сообщение и неверные данные на вводе.
		
			
		
		
		if (args.length > 0 && args[0].contains("-h")) {
			printHelp();
			return;
		}
		try {
			getZones(args);
			printResults();
		} catch (RuntimeException ex) {
			ex.printStackTrace();				//functionality error
		} catch(Exception ex) {
			System.out.println(ex.toString());  //wrong input data 
		}
	}

	private static void printHelp() {
		System.out.println("Select one on following zones. Default value is Local Zone");
		for (String zone : ZoneId.getAvailableZoneIds()) {
			System.out.println(zone);
		}
	}

	private static void printResults() {
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss VV");
		Iterator<ZonedDateTime> itr = timeZones.iterator();
		while(itr.hasNext()) {
			//System.out.printf("The time for selected Zone is: %s  \n", itr.next().format(format));
			System.out.println(itr.next());
		}
	}

	private static void getZones(String[] args) throws Exception {
		if(args.length>0) {
			for (String zone : ZoneId.getAvailableZoneIds()) {
				if (zone.toLowerCase().contains(args[0].toLowerCase())) { 
					timeZones.add(ZonedDateTime.now(ZoneId.of(zone)));
				}
			}
			if(timeZones.size()==0) {
				throw new Exception("zone="+args[0]+" isn't found");
			}
		} else {
			timeZones.add(ZonedDateTime.now());
		}

	
	}
		
}