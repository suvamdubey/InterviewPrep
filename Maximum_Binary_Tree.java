public class Maximum_Binary_Tree {
    /**
     * You are given an integer array nums with no duplicates. A maximum binary tree
     * can be built recursively from nums using the following algorithm:
     * 
     * Create a root node whose value is the maximum value in nums. Recursively
     * build the left subtree on the subarray prefix to the left of the maximum
     * value. Recursively build the right subtree on the subarray suffix to the
     * right of the maximum value.
     * 
     * Return the maximum binary tree built from nums.
     * https://leetcode.com/problems/maximum-binary-tree/
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
        public TreeNode constructMaximumBinaryTree(int[] a) {
            int n = a.length;
            if (n == 0)
                return null;
            if (n == 1)
                return new TreeNode(a[0]);
            int m = a[0], p = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] > m) {
                    m = a[i];
                    p = i;
                }
            }
            int l[] = new int[p], r[] = new int[n - p - 1];
            for (int i = 0; i < p; i++)
                l[i] = a[i];
            for (int i = 0; i < r.length; i++)
                r[i] = a[p + 1 + i];
            return new TreeNode(m, constructMaximumBinaryTree(l), constructMaximumBinaryTree(r));
        }
    }
}
