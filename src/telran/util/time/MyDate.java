package telran.util.time;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/**
 * We won't deal with it  but a pretty interestingly from the OOP point
 * @author User
 *
 */
public class MyDate implements Temporal {

	@Override
	public boolean isSupported(TemporalField field) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getLong(TemporalField field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSupported(TemporalUnit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Temporal with(TemporalField field, long newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporal plus(long amountToAdd, TemporalUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long until(Temporal endExclusive, TemporalUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
