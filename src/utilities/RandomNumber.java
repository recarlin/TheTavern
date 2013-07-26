package utilities;

import java.util.Random;

public class RandomNumber {
	public static int getNumber(int min, int max){
		Random r = new Random();
		int result = r.nextInt(max - min + 1) + min;
		
		return result;
	}
}
