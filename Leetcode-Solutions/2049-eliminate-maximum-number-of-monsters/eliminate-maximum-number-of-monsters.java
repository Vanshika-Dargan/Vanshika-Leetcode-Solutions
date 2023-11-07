class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        List<Double> list=new ArrayList<>();
        for(int i=0;i<dist.length;i++){
            list.add((double)dist[i]/speed[i]);
        }
        Collections.sort(list);
        int count=0;
        for(int i=0;i<dist.length;i++){
            if(list.get(i)<=i)
            break;
            count++;
        }
        return count;
    }
}