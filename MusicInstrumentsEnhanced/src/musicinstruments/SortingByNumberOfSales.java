package musicinstruments;

import java.util.Comparator;
import java.util.Map.Entry;

public class SortingByNumberOfSales implements Comparator<Entry<Instrument, Integer>>{

	@Override
	public int compare(Entry<Instrument, Integer> a, Entry<Instrument, Integer> b) {
		return (a.getKey().getNumberOfSales() == b.getKey().getNumberOfSales())
				? a.getKey().getId() - b.getKey().getId()
				: a.getValue() - b.getValue();
	}

}
