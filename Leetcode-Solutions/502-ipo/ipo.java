class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=capital[i];
            pair[i][1]=profits[i];
                  }
        Arrays.sort(pair,(a,b)->a[0]-b[0]);
       int j=0;
       PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
       for(int i=0;i<k;i++){

        while(j<n && pair[j][0]<=w){
            heap.add(pair[j][1]);
            j++;
        }

        if(heap.isEmpty()) break;

        w+=heap.poll();
       }
       return w;

    }
}