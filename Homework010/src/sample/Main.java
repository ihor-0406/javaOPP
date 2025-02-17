package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LetterCounter counter = new LetterCounter("text.txt");
		counter.analyzeText();
		counter.printFrequency();
	}

}
