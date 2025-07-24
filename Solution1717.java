class Solution17171 {

    // Convert stack to string
    static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }

    // Remove "ab" pairs and return: remaining_string + gain
    static String xl(String s, int y) {
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                st.pop();
                ans += y;
            } else {
                st.push(ch);
            }
        }

        return stackToString(st) + ans;  // remaining + gain
    }

    // Remove "ba" pairs and return: remaining_string + gain
    static String xg(String s, int x) {
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && ch == 'b' && st.peek() == 'a') {
                st.pop();
                ans += x;
            } else {
                st.push(ch);
            }
        }

        return stackToString(st) + ans;  // remaining + gain
    }

    public int maximumGain(String s, int x, int y) {
    int totalGain = 0;

    if (x > y) {
        // 1st method: xg (higher priority)
        String temp = xg(s, x);
        totalGain += extractTrailingNumber(temp);

        // directly call xl with leftover string
        totalGain += extractTrailingNumber(xl(removeTrailingNumber(temp), y));
    } else {
        // 1st method: xl (higher priority)
        String temp = xl(s, y);
        totalGain += extractTrailingNumber(temp);

        // directly call xg with leftover string
        totalGain += extractTrailingNumber(xg(removeTrailingNumber(temp), x));
    }

    return totalGain;
}

    // Helper to extract number from end of string
    static int extractTrailingNumber(String s) {
        int i = s.length() - 1;
        while (i >= 0 && Character.isDigit(s.charAt(i))) i--;
        return Integer.parseInt(s.substring(i + 1));
    }

    // Helper to remove number from end of string
    static String removeTrailingNumber(String s) {
        int i = s.length() - 1;
        while (i >= 0 && Character.isDigit(s.charAt(i))) i--;
        return s.substring(0, i + 1);
    }
}