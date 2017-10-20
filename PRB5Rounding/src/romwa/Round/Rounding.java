package romwa.Round;

import java.util.*;

public class Rounding {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Scanner getStrings = new Scanner(System.in);
		System.out.print("Enter number of cases--> ");
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			int num, numZeros;
			String nextLine = getStrings.nextLine();
			String[] parts = nextLine.split(" ");
			num = Integer.parseInt(parts[0]);
			numZeros = Integer.parseInt(parts[1]);
			System.out.println(calc(num, numZeros));
		}
	}
	
	public static int calc(int num, int numZeros) {
		int roundedNumber = 0;
		if(Integer.toString(num).length() == numZeros+1) {
			int offset = (num >= 0) ? 500 : -500;
			String nums2 = "1";
			for(int j = 0; j < numZeros; j++) {
				nums2 = nums2 + "0";
			}
			int num2 = Integer.parseInt(nums2);
			roundedNumber = (num + offset) / num2 * num2;
			System.out.println(offset + " " + nums2 + " " + num2
					+ " " + roundedNumber);
		}
		return roundedNumber;
	}
}
