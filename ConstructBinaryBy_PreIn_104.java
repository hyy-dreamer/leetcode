package leetcode;

public class ConstructBinaryBy_PreIn_104 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
	{
		if(preStart > preEnd) return null;
		
		//find the corresponding index under in_order
		int rootVal = preorder[preStart];
		int index = -1;
		for(int i = inStart;i <= inEnd; i ++)
		{
			if(rootVal == inorder[i])
			{
				index = i;
				break;
			}
		}
		
		//create the current root node
		TreeNode root = new TreeNode(rootVal);
		int leftSize = index - inStart;
		root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
		root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
		return root;
	}
}
