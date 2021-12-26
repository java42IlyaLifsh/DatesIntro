package telran.util.time;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13Adjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		temporal = adjustTemporal(temporal);
		while(temporal.get(ChronoField.DAY_OF_WEEK) != 5) {
			temporal = temporal.plus(1, ChronoUnit.MONTHS);
		}
		return temporal;
	}

	private Temporal adjustTemporal(Temporal temporal) {
		Temporal res = null;
		if (temporal.get(ChronoField.DAY_OF_MONTH) >= 13) {
			res = temporal.plus(1, ChronoUnit.MONTHS);
		}
		return res.with(ChronoField.DAY_OF_MONTH, 13);
	}

}
