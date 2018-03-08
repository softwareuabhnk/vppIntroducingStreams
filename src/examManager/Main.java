package examManager;

public class Main {

	public static void main(String[] args) {
		
		ExamManager.CalculationFunctionInterface average = myScores -> {
			Double sum = 0d;
			
			for (Double nextScore : myScores) {
				sum += nextScore;
			}
			return sum / myScores.size();
			
		};
		
		ExamManager.CalculationFunctionInterface highestScore = myScores -> {
			Double highest = 0d;
			
			for (Double nextScore : myScores) {
				highest = Math.max(highest, nextScore);
			}
			return highest;
			
		};
		
		
		ExamManager examManager = new ExamManager();
		System.out.println ("The average score is " + examManager.customCalculation(average));
		System.out.println ("The highest score is " + examManager.customCalculation(highestScore));
	}

}
