import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//BufferedReader 性能好，不过还是放弃java吧
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.valueOf(split[0]);
		int m = Integer.valueOf(split[1]);
		Map<Integer, Integer> student = new HashMap<>(n*2);
		int[][] degrees = new int[n][4];
		int[][] rank = new int[4][101];
		int[][] sumRank = new int[4][101];
		for (int i =0; i< n; i++) {
			split = in.readLine().split(" ");
			int no = Integer.valueOf(split[0]);
			int cp = Integer.valueOf(split[1]);
			int mp = Integer.valueOf(split[2]);
			int ep = Integer.valueOf(split[3]);
			int ap = (cp + mp + ep)/3;
			student.put(no, i);
			degrees[i][0] = cp;
			degrees[i][1] = mp;
			degrees[i][2] = ep;
			degrees[i][3] = ap;
			rank[0][cp]++;
			rank[1][mp]++;
			rank[2][ep]++;
			rank[3][ap]++;
		}
		for (int i =0; i< m; i++) {
			if (i != 0) {
				System.out.println("");
			}

			int no = Integer.valueOf(in.readLine());
			if (student.get(no) == null) {
				System.out.print("N/A");
			} else {
				Integer index = student.get(no);
				int arank = getRank(sumRank,rank, 3, degrees[index][3]);
				if (arank == 1) {
					System.out.print(arank + " A");
					continue;
				}
				int crank = getRank(sumRank,rank, 0, degrees[index][0]);
				if (crank == 1) {
					System.out.print(crank + " C");
					continue;
				}
				int mrank = getRank(sumRank,rank, 1, degrees[index][1]);
				if (mrank == 1) {
					System.out.print(mrank + " M");
					continue;
				}
				int erank = getRank(sumRank,rank, 2, degrees[index][2]);
				if (erank == 1) {
					System.out.print(erank + " E");
					continue;
				}

				int minRank = Math.min(Math.min(crank, mrank),Math.min(erank, arank));
				if (arank == minRank) {
					System.out.print(arank + " A");
					continue;
				} else if (crank == minRank) {
					System.out.print(crank + " C");
					continue;
				} else if (mrank == minRank) {
					System.out.print(mrank + " M");
					continue;
				} else if (erank == minRank) {
					System.out.print(erank + " E");
				}
			}
		}
		in.close();
	}
	public static int getRank(int[][] sumRank, int[][] ranks,int row,int degree) {
		if (degree == 100) {
			return 1;
		}
		if (sumRank[row][degree] == 0) {
			sumRank[row][100] = 1;
			for (int i = 99; i >= degree;i--) {
				sumRank[row][i] = sumRank[row][i+1] + ranks[row][i+1];
			}
			return sumRank[row][degree];
		} else {
			return sumRank[row][degree];
		}
	}
}
