package romwa.three;

import java.util.Scanner;

public class Three {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of cases-->");
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			System.out.print("Enter " + (i+1) + " number-->");
			int num = in.nextInt();
			System.out.println(getFinalNum(num));
		}
	}

	public static int getFinalNum(int num) {
		if(num > 0) {
			while(num%3 != 0) {
				String numS = Integer.toString(num);
				removeLastChar(numS);
//				num = Integer.parseInt(numS);
				System.out.println(numS);
				if(numS.length() == 1) break;
			}
			if(num%3 == 0) return num;
			return -1;
		} else {
			return -1;
		}
	}
	
	public static String removeLastChar(String s) {
		if(s != null && s != "") {
			return s.substring(0, s.length()-1);
		}
		return null;
	}
}
