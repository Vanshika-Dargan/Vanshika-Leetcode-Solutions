class Solution {
    public boolean checkIfExist(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int zeroCount=0;
    for(int a:arr){
        set.add(a);
        if(a==0) zeroCount+=1;
    }    
    for(int i=0;i<arr.length;i++){
        if(arr[i]==0 && zeroCount==1) continue;
        if(set.contains(arr[i] * 2)) return true;
    }
    return false;
    }
}