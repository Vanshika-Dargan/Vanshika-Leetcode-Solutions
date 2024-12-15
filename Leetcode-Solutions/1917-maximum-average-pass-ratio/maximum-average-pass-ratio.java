import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int k) {
        // Priority Queue as a max-heap based on the "increase" value
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Populate the priority queue with initial "increase" values
        for (int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            pq.offer(new double[]{increase(pass, total), pass, total});
        }

        // Add k extra students to maximize the average
        for (int i = 0; i < k; i++) {
            double[] next = pq.poll();
            double pass = next[1];
            double total = next[2];
            pq.offer(new double[]{increase(pass + 1, total + 1), pass + 1, total + 1});
        }

        // Calculate the final average ratio
        double ans = 0;
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            ans += curr[1] / curr[2];
        }

        return ans/classes.length;
    }

 
    private double increase(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}
