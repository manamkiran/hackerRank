package kiran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JavaStackProblemDeque {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			boolean balanced = true;
			Deque<Character> deque = new ArrayDeque<Character>();
			if (input != null && input.length() > 0) {
				for (char ch : input.toCharArray()) {
					if ('{' == (ch) || '(' == (ch) || '[' == (ch)) {
						deque.push(ch);
					} else if ('}' == (ch) || ')' == (ch) || ']' == (ch)) {
						if (deque.isEmpty()) {
							balanced = false;
							break;
						}
						char output = deque.peek();
						if (('}' == (ch) && '{' == (output)) || (')' == (ch) && '(' == (output))
								|| (']' == (ch) && '[' == (output))) {
							deque.pop();
						} else {
							balanced = false;
							break;
						}
					}
				}

			}
			System.out.println(deque.isEmpty() && balanced);
		}

	}

}
