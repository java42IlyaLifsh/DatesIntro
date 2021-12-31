package telran.application.dates;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//HW_25_IlyaL 1
public class DateTimeWithZoneAppl {
public static void main(String[] args) {
	//args[0] - optional substring of time Zone (default - local time zone)
	//TODO display out the time in the appropriate ZoneId
String timeZone="GMT+8";
try {
	timeZone=getTimeZone(args).toString();
	System.out.println("1111  "+timeZone);
} catch (RuntimeException e) {
	e.printStackTrace();//functionality error
}
catch (Exception e) {
	System.out.println(e.getMessage());//wrong input data 
	return;
}
System.out.println("22222  "+timeZone);


}

private static ZoneId getTimeZone(String[] args) throws Exception {
	// TODO Auto-generated method stub
	ZoneId rezZone= ZoneId.systemDefault();
	if (args.length > 1) {
		String city = getCity(args[1]);
		
		ZonedDateTime ztd = ZonedDateTime.now();
		for(String zone: ZoneId.getAvailableZoneIds()) {
			
			if (zone.toLowerCase().contains(city)) {
				rezZone=ZoneId.of(zone);
				System.out.println("33333  "+ztd.withZoneSameInstant(rezZone));
			}
		}
	}
	
	return rezZone;
}


private static String getCity(String string)  throws Exception {
	String res ="toronto";
	try {
		res = string.toLowerCase();
	} catch (NumberFormatException e) {
		throw new Exception("City should be a string");}
	
	if (res == null) {
		throw new Exception("City can't be blanced");
	}
	return res;
}
}
