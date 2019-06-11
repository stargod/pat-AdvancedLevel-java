import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0,b = 0;
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
        }
        int c = a + b;
        System.out.print(new DecimalFormat(",###").format(c));
    }
}