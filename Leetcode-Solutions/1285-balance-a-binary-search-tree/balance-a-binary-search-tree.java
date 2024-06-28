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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(list,root);
        return balanceTheBST(list,0,list.size()-1);
    }

    void inorder(List<Integer> list,TreeNode root){
        
        if(root==null) return;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }

    TreeNode balanceTheBST(List<Integer> list,int s,int e){
    if(s>e) return null;
    int mid=s+(e-s)/2;
    
    TreeNode left=balanceTheBST(list,s,mid-1);
    TreeNode right=balanceTheBST(list,mid+1,e);
    TreeNode node=new TreeNode(list.get(mid),left,right);

    return node;
    }
}