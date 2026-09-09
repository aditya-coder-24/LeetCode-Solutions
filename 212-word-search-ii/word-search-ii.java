import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode root = new TrieNode();
    private char[][] board;
    private List<String> result = new ArrayList<>();
    private int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(int row, int col, TrieNode node) {

        // Out of bounds
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        char c = board[row][col];

        // Already visited
        if (c == '#') {
            return;
        }

        int index = c - 'a';

        // Character not present in Trie
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark cell as visited
        board[row][col] = '#';

        // Explore 4 directions
        dfs(row - 1, col, next); // up
        dfs(row + 1, col, next); // down
        dfs(row, col - 1, next); // left
        dfs(row, col + 1, next); // right

        // Restore cell
        board[row][col] = c;
    }
}