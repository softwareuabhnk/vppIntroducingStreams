package examManager;

import java.util.Comparator;

public class DecendingComparator implements Comparator<Double> {

	@Override
	public int compare(Double arg0, Double arg1) {
			
		int result = 0;
		
		if (arg0 < arg1) result = 1;
		else if (arg1 < arg0) result = -1;
		return result;
	}

}
