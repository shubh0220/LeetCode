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
    private TreeNode helper(int[] inorder,int[] postorder,int is,int ie,int ps,int pe,HashMap<Integer,Integer> map){
        if(ie<is || pe<ps) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int k = map.get(postorder[pe]);
        int m = k-is;
        root.left = helper(inorder,postorder,is,k-1,ps,ps+m-1,map);
        root.right = helper(inorder,postorder,k+1,ie,ps+m,pe-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length ==  0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
    }
}