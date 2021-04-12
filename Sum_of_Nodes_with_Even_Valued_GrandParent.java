public class Sum_of_Nodes_with_Even_Valued_GrandParent {
    /*
     * Given a binary tree, return the sum of values of nodes with even-valued
     * grandparent. (A grandparent of a node is the parent of its parent, if it
     * exists.)
     * 
     * If there are no nodes with an even-valued grandparent, return 0.
     * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            if (root == null)
                return 0;
            int t = 0;
            if (root.val % 2 == 0)
                t = gce(root);
            return t + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);

        }

        public int gce(TreeNode root) {
            TreeNode l = root.right, r = root.left;
            int s = 0;
            if (l != null) {
                if (l.left != null)
                    s += l.left.val;
                if (l.right != null)
                    s += l.right.val;
            }
            if (r != null) {
                if (r.left != null)
                    s += r.left.val;
                if (r.right != null)
                    s += r.right.val;
            }
            return s;
        }
    }
}
