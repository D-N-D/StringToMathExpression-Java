import java.util.Scanner;
import java.math.BigDecimal;

public class StringToMath {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();

		String newInput = input.replaceAll("\\s+", "");

		String[] members = newInput.split("");

		BigDecimal result = new BigDecimal("0");

		Boolean positiveSign = true;

		StringBuilder tempNum = new StringBuilder();

		for (int i = 0; i < members.length; i++) {
			if (members[i].matches("\\d+") || members[i].matches("\\.")) {

				tempNum.append(members[i]);
			}

			else if (members[i].matches("\\+")) {

				BigDecimal curNum = new BigDecimal(tempNum.toString());
				
				
				if (positiveSign) {
					result = result.add(curNum);
				} else {
					result = result.subtract(curNum);
				}

				positiveSign = true;

				if (i != members.length) {
					tempNum.setLength(0);
				}
			}

			else if (members[i].matches("\\-")) {

				BigDecimal curNum = new BigDecimal(tempNum.toString());
				
				if (positiveSign) {
					result = result.add(curNum);
				} else {
					result = result.subtract(curNum);
				}

				positiveSign = false;
				if (i != members.length) {
					tempNum.setLength(0);
				}
			}

		}

		BigDecimal curNum = new BigDecimal(tempNum.toString());
		if (positiveSign) {
			result = result.add(curNum);
		} else {
			result = result.subtract(curNum);
		}

		System.out.print(result);

	}

}
