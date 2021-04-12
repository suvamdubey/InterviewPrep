public class Find_Node_in_Clone_of_BinaryTree {
    /*
     * Given two binary trees original and cloned and given a reference to a node
     * target in the original tree.
     * 
     * The cloned tree is a copy of the original tree.
     * 
     * Return a reference to the same node in the cloned tree.
     * 
     * Note that you are not allowed to change any of the two trees or the target
     * node and the answer must be a reference to a node in the cloned tree.
     * 
     * Follow up: Solve the problem if repeated values on the tree are allowed.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null)
                return null;
            return find(cloned, target);
        }

        public TreeNode find(TreeNode t, TreeNode x) {
            if (t == null)
                return null;
            if (t.val == x.val) {
                if (sameTree(t, x))
                    return t;
            }
            TreeNode l = find(t.left, x);
            if (l != null)
                return l;
            else {
                return find(t.right, x);
            }
        }

        boolean sameTree(TreeNode a, TreeNode b) {
            if (a == null && b == null)
                return true;
            if ((a == null && b != null) || (a != null && b == null))
                return false;
            if (a.val == b.val)
                return sameTree(a.left, b.left) && sameTree(a.right, b.right);
            return false;
        }
    }
}
