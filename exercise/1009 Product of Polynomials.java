import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k1, k2;
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        double[] a1 = new double[10];
        double[] a2 = new double[10];
        Map<Integer, Double> exponentsToCoefficientsMap = new HashMap<>();
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
        for (int i = 0;i < k1;i++) {
            for (int j = 0;j < k2;j++) {
                Double coefficient = exponentsToCoefficientsMap.get(n1[i] + n2[j]);
                if (coefficient == null) {
                    exponentsToCoefficientsMap.put(n1[i] + n2[j], a1[i] * a2[j]);
                } else {
                    exponentsToCoefficientsMap.put(n1[i] + n2[j], a1[i] * a2[j] + coefficient);
                }
            }
        }
        List<Integer> exponentsList = new ArrayList<>(exponentsToCoefficientsMap.keySet());
        Collections.sort(exponentsList);
        StringBuffer sb = new StringBuffer();
        int k3 = 0;
        for (Integer exponent:exponentsList) {
            double coefficient = exponentsToCoefficientsMap.get(exponent);
            coefficient = Math.round(coefficient * 10) / 10.0;
            if (coefficient != 0.0) {
                sb.insert(0," " + exponent + " " + coefficient);
                k3 ++;
            }
        }
        sb.insert(0, k3);
        System.out.print(sb.toString());
    }
}