package kiran;

import java.util.Scanner;

public class JavaStackProblem {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			boolean balanced = true;
			StringBuffer sb = new StringBuffer();
			if (input != null && input.length() > 0) {
				for (char ch : input.toCharArray()) {
					if ('{' == (ch) || '(' == (ch) || '[' == (ch)) {
						sb.append(ch);
					} else if ('}' == (ch) || ')' == (ch) || ']' == (ch)) {
						if(sb.length() == 0) {
							balanced = false;
							break;
						}
						char output = sb.charAt(sb.length() - 1);
						if (('}' == (ch) && '{' == (output)) || (')' == (ch) && '(' == (output))
								|| (']' == (ch) && '[' == (output))) {
							sb.deleteCharAt(sb.length() - 1);
						} else {
							balanced = false;
							break;
						}
					}
				}

			}
			System.out.println(sb.length() == 0 && balanced);
		}

	}
}