package tasktm.main;

public class TasktmMain {

	public static void main(String[] args) {
		//0.reading property
		Processer.readProperties();
		//1.collecting TASKTM info
		new Collecter().collect();
		//2.analyzing TASKTM info
		new Analyzer().analyze();

	}






}
