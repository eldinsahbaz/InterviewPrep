/*
Write a function to find the 2nd largest element in a binary search tree.
*/

public static class SecondLargestBinaryTreeValue {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
	
	public int secondLargest(BinaryTreeNode root)
	{
		BinaryTreeNode secondLargest = null;
		
		while(root.right != null)
		{
			secondLargest = root;
			root = root.right;
		}
		
		return secondLargest.value;
	}
}
