class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        // Remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                result.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }

        // Remove extra '(' from right to left
        for (int i = result.length() - 1; i >= 0 && balance > 0; i--) {
            if (result.charAt(i) == '(') {
                result.deleteCharAt(i);
                balance--;
            }
        }

        return result.toString();
    }
}