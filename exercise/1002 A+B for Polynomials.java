import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k1 = 0,k2 = 0;
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        double[] a1 = new double[10];
        double[] a2 = new double[10];
        int[] n3 = new int[20];
        double[] a3 = new double[20];
        while (in.hasNextInt()) {
            k1 = in.nextInt();
            for (int i =0;i<k1;i++) {
                n1[i] = in.nextInt();
                a1[i] = in.nextDouble();
            }
            k2 = in.nextInt();
            for (int i =0;i<k2;i++) {
                n2[i] = in.nextInt();
                a2[i] = in.nextDouble();
            }
        }
        int i =0,j=0,k3=0;
        while (i < k1 || j < k2) {
            if (i<k1 && j <k2) {
                if (n1[i] == n2[j]) {
                    n3[k3] = n1[i];
                    a3[k3] = a1[i] + a2[j];
                    i++;
                    j++;
                    k3++;
                } else if (n1[i] > n2[j]){
                    n3[k3] = n1[i];
                    a3[k3] = a1[i];
                    i++;
                    k3++;
                } else {
                    n3[k3] = n2[j];
                    a3[k3] = a2[j];
                    j++;
                    k3++;
                }
            } else if (i < k1) {
                n3[k3] = n1[i];
                a3[k3] = a1[i];
                i++;
                k3++;
            } else {
                n3[k3] = n2[j];
                a3[k3] = a2[j];
                j++;
                k3++;
            }
        }
        int sum = 0;
        for (int k = 0;k<k3;k++) {
            if (a3[k] != 0.0) {
                sum ++;
            }
        }
        System.out.print(sum);
        for (int k = 0;k<k3;k++) {
            if (a3[k] != 0.0) {
                System.out.print(" ");
                System.out.print(n3[k]);
                System.out.print(" ");
                //保留一位小数，我也不知道为什么
                double v = Math.round(a3[k]*10) /10.0;
                System.out.print(v);
            }
        }
    }
}