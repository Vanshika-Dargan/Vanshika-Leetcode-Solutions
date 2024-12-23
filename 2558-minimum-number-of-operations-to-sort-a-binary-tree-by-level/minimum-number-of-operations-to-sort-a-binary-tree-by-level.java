/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res=0;

        while(!q.isEmpty()){
            int size=q.size();
            int arr[]=new int[size];
            for(int i=0;i<size;i++){
            TreeNode node=q.poll();
            arr[i]=node.val;
            if(node.left!=null)
            q.offer(node.left);
            if(node.right!=null)
            q.offer(node.right);
            }
            res+=getSwaps(arr);
        }
        return res;
    }
    int getSwaps(int[] arr){
        int swaps=0;
        int clone[]=arr.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> pos = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            pos.put(arr[i],i);
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=clone[i]){
                swaps++;

                int currPos=pos.get(clone[i]);
                arr[currPos]=arr[i];
                pos.put(arr[i],currPos);
            }

        }
        return swaps;
    }
}