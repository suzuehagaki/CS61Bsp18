public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> cDeque = new LinkedListDeque<>();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            cDeque.addLast(word.charAt(i));
        }
        return cDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> cDeque = wordToDeque(word);
        while (cDeque.size() > 1) {
            if (cDeque.removeFirst() != cDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /**
    public boolean isPalindromeRecursiveHelper(Deque<Character> cDeque) {
        if (cDeque.size() <= 1) {
            return true;
        } else if (cDeque.removeFirst() != cDeque.removeLast()) {
            return false;
        }
        return isPalindromeRecursiveHelper(cDeque);
    }
    public boolean isPalindromeRecursive(String word) {
        Deque<Character> cDeque = wordToDeque(word);
        return isPalindromeRecursiveHelper(cDeque);
    }
     */

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> cDeque = wordToDeque(word);
        while (cDeque.size() > 1) {
            if (!cc.equalChars(cDeque.removeFirst(), cDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
