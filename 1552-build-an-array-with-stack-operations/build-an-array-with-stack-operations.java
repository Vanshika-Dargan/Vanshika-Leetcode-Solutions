class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int j=0;
        for(int i=1;i<=n && j<target.length;i++){
            if(i==target[j]){
                j++;
                res.add("Push");
            }
            else{
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}