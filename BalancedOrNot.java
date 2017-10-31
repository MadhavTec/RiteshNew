import java.io.IOException;
import java.util.Scanner;

public class BalancedOrNot {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] inputs = new String[in.nextInt() + 1];
		for (int i = 0; i < inputs.length; i++) {
			if (inputs.equals(""))
				inputs[0] = in.nextLine();
			else
				inputs[i] = in.nextLine();
		}

		int[] maxReplacement = new int[in.nextInt()];
		for (int i = 0; i < maxReplacement.length; i++) {
				maxReplacement[i] = in.nextInt();
		}

		for(int i:balancedOrNot(inputs, maxReplacement)){
			System.out.println(i);
		}
	}

	private static int[] balancedOrNot(String[] inputs, int[] maxReplacement) {
		int j = 0;
		int[] ls = new int[maxReplacement.length];
		for (String input : inputs) {
			if (input != null && !input.equals("")) {
				int openBrackets = 0;
				boolean unBalanced = false;
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) == '<') {
						openBrackets++;
					} else if (openBrackets > 0) {
						openBrackets--;
					} else if (maxReplacement[j] > 0) {
						maxReplacement[j]--;
					} else {
						unBalanced = true;
					}
				}
				if (unBalanced || openBrackets > 0) {
					ls[j] = 0;
				} else {
					ls[j] = 1;
				}
				j++;
			}
		}
		return ls;
	}
}
