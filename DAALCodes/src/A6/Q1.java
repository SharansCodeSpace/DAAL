import java.util.*;

class Job {
    int id, deadline, profit;
    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Q1 {

    static boolean compareJobs(Job j1, Job j2) {
        return j1.profit > j2.profit;
    }

    static List<Integer> jobSequencing(List<Job> jobs, int n) {
        jobs.sort((j1, j2) -> j2.profit - j1.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs.get(i).deadline);
        }

        int[] slots = new int[maxDeadline];
        Arrays.fill(slots, -1);

        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
                if (slots[j] == -1) {  // Slot available
                    slots[j] = jobs.get(i).id;
                    sequence.add(jobs.get(i).id);  // Add job to sequence
                    break;
                }
            }
        }

        return sequence;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int n = sc.nextInt();
        List<Job> jobs = new ArrayList<>();
        System.out.println("Enter job details (id, deadline, profit):");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs.add(new Job(id, deadline, profit));
        }
        List<Integer> sequence = jobSequencing(jobs, n);
        System.out.println("Maximum profit job sequence: " + sequence);
        sc.close();
    }
}
