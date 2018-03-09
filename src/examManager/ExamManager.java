package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamManager {

	private List<Double> myScores;

	public ExamManager() {
		myScores = new ArrayList<Double>();
		myScores.add(78.3);
		myScores.add(69.2);
		myScores.add(44.7);
		myScores.add(61.6);
		myScores.add(80.2);
		myScores.add(66.9);
		myScores.add(54.1);
	}

	public Double customCalculation(ToDoubleFunction<List<Double>> calculator) {
		return calculator.applyAsDouble(myScores);
	}

	// public void PrintScores() {
	// for (Double score: myScores) {
	// System.out.println(score);
	// }
	// }

	public void PrintScores() {
		
		Comparator<Double> ascendingComparator = (arg0, arg1) -> {		
			int result = 0;
			
			if (arg0 < arg1) result = -1;
			else if (arg1 < arg0) result = 1;
			return result;
		};
				
		Collections.sort(myScores,new DecendingComparator());
		System.out.println("Sort Descending order:");
		myScores.forEach(s -> System.out.println(s));
		Collections.sort(myScores,ascendingComparator);
		System.out.println("Sort ascending order:");
		myScores.forEach(s -> System.out.println(s));
	}

	public void printSelectedScores(Predicate<Double> testCriteria) {
		
	myScores.stream().filter(testCriteria).forEach(s -> System.out.println(s));
	System.out.println("Same printout with functional operating on streams ");
		// ForEach excepts a lambda expression of type consumer
		myScores.forEach(s -> {
			// Evaluates another lambda expression passed in to the method
			if (testCriteria.test(s)) {
				System.out.println(s);
			}
		});
	}
	
	public double getTotalOfAllScores(){
		
		//Double total = 0d;
		//Stream<Double> scoreStream = myScores.stream();
		//return scoreStream.reduce(total, (a,b) -> a+b);
		return myScores.stream().reduce(0d, (a,b) -> a+b);
				
	}
	
	public void doubleAllScores() {
		System.out.println("Double all values in my stream:");
		myScores.stream().map(d -> d*2).forEach(s -> System.out.println(s));
	}
	
	
	public List<Double> doubleAllScores2() {
		System.out.println("Double all values in my stream and convert the stream to a List:");
		return myScores.stream().map(d -> d*2).collect(Collectors.toList());
	}

}
