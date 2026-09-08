class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word to the Trie
    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search for a word, where '.' can match any character
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // Reached the end of the word
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {
            TrieNode next = node.children[ch - 'a'];

            if (next == null) {
                return false;
            }

            return dfs(word, index + 1, next);
        }

        // '.' can represent any character
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}