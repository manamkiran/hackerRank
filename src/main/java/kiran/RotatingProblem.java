package kiran;

import java.util.Collections;
import java.util.List;

public class RotatingProblem {

	/*
	 * public <V> List<V> rotate(List<V> input, int rotateBy) { int n =
	 * input.size(); int rotate = rotateBy % n; if (rotate == 0) { return input; }
	 * for (int i = 0; i < n; i++) { Collections.swap(input, i, (i + rotate) < n ?
	 * (i + rotate) : n - 1); } return input;
	 * 
	 * }
	 */

	public <V> List<V> rotate(List<V> input, int rotateBy) {
		int n = input.size();
		int rotate = rotateBy % n;
		if (rotate == 0) {
			return input;
		}
		Collections.reverse(input);
		Collections.reverse(input.subList(0, n-rotate));
		//reverseList(input, 0, rotate);
		Collections.reverse(input.subList(n-rotate, n));
		//reverseList(input, rotate, n);
		return input;

	}
	
	private void reverseList(List<?> input ,int startIndex ,int endIndex) {
		for (int i = startIndex; i < (startIndex+endIndex)/2; i++) {
			Collections.swap(input, i, endIndex+startIndex-i-1);
		}
	}

}
