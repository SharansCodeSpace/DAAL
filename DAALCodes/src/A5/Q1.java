import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values for n and m
        long n = sc.nextLong();
        long m = sc.nextLong();

        long kmin, kmax;
        long x;

        x = n / m + 1;
        kmin = ((x * (x - 1)) / 2) * (n % m);
        x -= 1;
        kmin += ((x * (x - 1)) / 2) * (m - (n % m));

        // Calculating kmax
        x = n - m + 1;
        kmax = (x * (x - 1)) / 2;

        // Output the results
        System.out.println(kmin + " " + kmax);

        sc.close();
    }
}
