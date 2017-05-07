/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (identical(s, t)) return true;
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    public boolean identical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return ((t1.val == t2.val) && identical(t1.left, t2.left) && identical(t1.right, t2.right));
    }
}