package telran.util.time;
//HW_23
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalUnit;

public class BarMizvaAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		
		return temporal.plus(13, ChronoUnit.YEARS);
	}

}
