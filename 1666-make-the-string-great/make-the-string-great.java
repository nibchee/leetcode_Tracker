class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Character atTop = (!st.isEmpty())?st.peek():' ';
            if (atTop >= 'a' && atTop <= 'z' && ch >= 'A' && ch <= 'Z' && ch + 32 == (int) atTop) {
                st.pop();
            } else if (ch >= 'a' && ch <= 'z' && atTop >= 'A' && atTop <= 'Z' && atTop + 32 == (int) ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }
        return res;
    }
}