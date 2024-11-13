public class Task2 {
    public static class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int value, BinaryNode left, BinaryNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinaryTree {
        BinaryNode root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryNode(7,
                new BinaryNode(4,
                        new BinaryNode(3,
                                new BinaryNode(2,
                                        new BinaryNode(1, null, null),
                                        null),
                                null),
                        null),
                new BinaryNode(28,
                        null,
                        new BinaryNode(55,
                                new BinaryNode(51,
                                        new BinaryNode(48,
                                                new BinaryNode(40,
                                                        new BinaryNode(35, null, null),
                                                        null),
                                                null),
                                        null),
                                new BinaryNode(60,
                                        new BinaryNode(58,
                                                new BinaryNode(57, null, null),
                                                null),
                                        new BinaryNode(69, null, null))
                                )));
        System.out.println("Number of branches: " + countBranches(tree.root));
    }

    public static int countBranches(BinaryNode node) {
        if (node == null) {
            return 0;
        }

        //We check if the node has only one child
        BinaryNode onlyChild = getOnlyChild(node);
        if (onlyChild != null) {
            //Then we check if the only child has exactly one child that is a leaf
            BinaryNode grandChild = getOnlyChild(onlyChild);
            if (grandChild != null && grandChild.left == null && grandChild.right == null) {
                //then this node is part of a branch
                return 1 + countBranches(onlyChild);
            }
        }

        //We recursively check the left and right child nodes
        return countBranches(node.left) + countBranches(node.right);
    }

    public static BinaryNode getOnlyChild(BinaryNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.right == null) {
            return node.left;
        }
        if (node.left == null && node.right != null) {
            return node.right;
        }
        return null;
    }
}
