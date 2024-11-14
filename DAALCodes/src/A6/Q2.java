import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    static boolean largestProfitStrategy(int a, int b, double[] profit) {
        return profit[a] > profit[b];
    }

    static boolean smallestWeightStrategy(int a, int b, double[] weight) {
        return weight[a] < weight[b];
    }

    static boolean largestProfitWeightRatioStrategy(int a, int b, double[] profit, double[] weight) {
        return (profit[a] / weight[a]) > (profit[b] / weight[b]);
    }

    static double fractionalKnapsack(int n, double[] profit, double[] weight, int capacity, int strategy) {
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        if (strategy == 1) {
            Arrays.sort(index, (a, b) -> largestProfitStrategy(a, b, profit) ? -1 : 1);
        } else if (strategy == 2) {
            Arrays.sort(index, (a, b) -> smallestWeightStrategy(a, b, weight) ? -1 : 1);
        } else if (strategy == 3) {
            Arrays.sort(index, (a, b) -> largestProfitWeightRatioStrategy(a, b, profit, weight) ? -1 : 1);
        }

        double totalProfit = 0.0;
        double currentWeight = 0.0;

        for (int i = 0; i < n; i++) {
            int idx = index[i];
            if (currentWeight + weight[idx] <= capacity) {
                totalProfit += profit[idx];
                currentWeight += weight[idx];
            } else {
                double remainingCapacity = capacity - currentWeight;
                totalProfit += (profit[idx] / weight[idx]) * remainingCapacity;
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        
        double[] profit = new double[n];
        double[] weight = new double[n];

        System.out.println("Enter profits and weights for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Profit for item " + (i + 1) + ": ");
            profit[i] = scanner.nextDouble();
            System.out.print("Weight for item " + (i + 1) + ": ");
            weight[i] = scanner.nextDouble();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double largestProfit = fractionalKnapsack(n, profit, weight, capacity, 1);
        System.out.println("Largest Profit Strategy: Total Profit = " + largestProfit);

        double smallestWeight = fractionalKnapsack(n, profit, weight, capacity, 2);
        System.out.println("Smallest Weight Strategy: Total Profit = " + smallestWeight);

        double largestProfitWeightRatio = fractionalKnapsack(n, profit, weight, capacity, 3);
        System.out.println("Largest Profit Weight Ratio Strategy: Total Profit = " + largestProfitWeightRatio);

        scanner.close();
    }
}
