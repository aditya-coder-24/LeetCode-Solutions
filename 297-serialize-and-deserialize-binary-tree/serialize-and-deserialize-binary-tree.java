import java.util.*;

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        Queue<String> queue = new LinkedList<>();

        for (String value : values) {
            queue.offer(value);
        }

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("N")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}