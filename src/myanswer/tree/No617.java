package myanswer.tree;

public class No617 {

    // 给定两个二叉树，
    // 想象当你将它们中的一个覆盖到另一个上时，
    // 两个二叉树的一些节点便会重叠。
    //
    //你需要将他们合并为一个新的二叉树。
    // 合并的规则是如果两个节点重叠，
    // 那么将他们的值相加作为节点合并后的新值，
    // 否则不为 NULL 的节点将直接作为新二叉树的节点。
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            t1 = new TreeNode(t2.val);
        } else if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t2.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}