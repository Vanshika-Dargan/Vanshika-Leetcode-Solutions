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
    public int sumNumbers(TreeNode root) {
        
    return dfs(root,0,0);
    }

    int dfs(TreeNode head,int num,int sum){
    if(head==null){
        return sum;
    }
    if(head.left==null && head.right==null){
    sum+=num*10+head.val;
    return sum;
    }
    return dfs(head.left,num*10+head.val,sum)+dfs(head.right,num*10+head.val,sum);
    
    }
}