class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

       Trie trie=new Trie();
       for(String s:dictionary){
        trie.insert(s);
       } 
      String arr[]=sentence.split(" ");
      for(int i=0;i<arr.length;i++){
        arr[i]=trie.findShortestCommonString(arr[i]);
      }

       return String.join(" ",arr);
    }

}

class Node{
   boolean isEnd;
   Node[] children;
   Node(){
    isEnd=false;
    children=new Node[26];
   }
}


class Trie{

    Node root;
    
    Trie(){
        root=new Node();
    }

    void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                curr.children[word.charAt(i)-'a']=new Node();
            }
            curr=curr.children[word.charAt(i)-'a'];
        }
        curr.isEnd=true;
    }

    String findShortestCommonString(String word){
    Node curr=root;
    for(int i=0;i<word.length();i++){
    if(curr.children[word.charAt(i)-'a']==null) {
        return word;
    }
    curr=curr.children[word.charAt(i)-'a'];
    if(curr.isEnd) return word.substring(0,i+1);
    }
    return word;
    }
}