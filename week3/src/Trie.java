public class Trie {
    private Trie next[];
    private boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
