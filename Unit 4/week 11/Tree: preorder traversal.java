import java.util.*;

public class Solution {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static Node buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            Node current = queue.poll();

            if (i < values.length && !values[i].equals("-1")) {
                current.left = new Node(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("-1")) {
                current.right = new Node(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] values = sc.nextLine().trim().split("\\s+");

        Node root = buildTree(values);

        preOrder(root);
        System.out.println();

        sc.close();
    }
}
