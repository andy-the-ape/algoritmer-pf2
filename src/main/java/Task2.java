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

        @Override
        public String toString() {
            return "BinaryNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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
        System.out.println(walkTheTree(tree.root));
    }

    public static BinaryNode walkTheTree(BinaryNode node) {
        if (getOnlyChild(node) != null) {
            return getOnlyChild(node);
        }
        return null;
    }

    public static BinaryNode getOnlyChild(BinaryNode node) {
        if (node.left == null && node.right == null) {
            return null;
        }
        else if (node.left != null && node.right == null) {
            return node.left;
        }

        else {
            getOnlyChild(node.left);
            getOnlyChild(node.right);
        }

    }
}
