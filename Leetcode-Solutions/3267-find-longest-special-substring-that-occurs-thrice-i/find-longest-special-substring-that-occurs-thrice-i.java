class Solution {
    public int maximumLength(String s) {
        
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int length=0;
            for(int j=i;j<s.length();j++){
                char next=s.charAt(j);
                if(ch!=next) break;
                length++;
                String key=length+","+ch;
                map.put(key,map.getOrDefault(key,0)+1);
            }        
        }

        int maxLength=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            
            String key[]=entry.getKey().split(",");
            int curr=Integer.parseInt(key[0]);
            if(entry.getValue()>=3){
                if(curr>maxLength){
                    maxLength=curr;
                }
            }
            
        }

        return maxLength==0?-1:maxLength;
    }
}