package deserve;

import java.util.Random;

public class Dice {
	static final int MIN = 1;
	static final int MAX = 6;
	public int roll() {
		return this.random(MIN,MAX);
	}
	public int random(int min, int max) {
		int result = (int) (min + Math.floor((max-min) * Math.random()));
		return result;
	}
	public int rollEvenNumbersDice(){
		Random rand = new Random();
		int randomNum = rand.nextInt(7);
		int num =  randomNum % 2 == 0 ? randomNum : rollEvenNumbersDice();
		return num;
	}
}
