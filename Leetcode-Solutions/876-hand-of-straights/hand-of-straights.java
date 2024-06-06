class Solution {
    public boolean isNStraightHand(int[] handy, int groupSize) {
        int m=handy.length;
        if(m<groupSize || m%groupSize!=0) return false;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(handy[i],map.getOrDefault(handy[i],0)+1);
        }
        
        int hand[]=new int[map.size()];
        int idx=0;
        for(int key:map.keySet()){
            hand[idx++]=key;
        }
        Arrays.sort(hand);
        int n=hand.length;
        for(int i=0;i<n;i++){
            int start=hand[i];
            if(map.get(hand[i])>0){
                int count=map.get(hand[i]);
                for(int j=start;j<start+groupSize;j++){
                    if(map.getOrDefault(j,0)<count) return false;
                    map.put(j,map.get(j)-count);
                }
            }
        }
        return true;
    }
}