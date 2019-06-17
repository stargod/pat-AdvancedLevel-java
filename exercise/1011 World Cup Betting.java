import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] inputs = new double[9];
		for (int i =0; i< 9; i++) {
			inputs[i] = scanner.nextDouble();
		}
		char[] choose = new char[3];
		double[] maxFit = new double[3];
		for (int i =0; i<3;i++) {
			if (inputs[i*3] > inputs[i*3+1] && inputs[i*3] > inputs[i*3+2]) {
				choose[i] = 'W';
				maxFit[i] = inputs[i*3];
			} else if (inputs[i*3] < inputs[i*3+1] && inputs[i*3+1] > inputs[i*3+2]) {
				choose[i] = 'T';
				maxFit[i] = inputs[i*3+1];
			} else {
				choose[i] = 'L';
				maxFit[i] = inputs[i*3+2];
			}
		}
		double maxProfit = (maxFit[0] *
				maxFit[1] *
				maxFit[2] * 0.65 - 1 ) * 2;
		maxProfit = Math.round(maxProfit * 100) /100.0;
		System.out.print(choose[0] + " ");
		System.out.print(choose[1] + " ");
		System.out.print(choose[2] + " ");
		System.out.print(maxProfit);
	}
}
