class Solution {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char currChar : expression.toCharArray()) {
            if (currChar == ')') {
                ArrayList<Character> values = new ArrayList<>();

                while (st.peek() != '(') {
                    values.add(st.pop());
                }
                st.pop(); 
                char op = st.pop();

                char result = evaluateSubExpr(op, values);
                st.push(result);
            } else if (currChar != ',') {
                st.push(currChar); 
            }
        }

        return st.peek() == 't';
    }

    private char evaluateSubExpr(char op, ArrayList<Character> values) {
        if (op == '!') return values.get(0) == 't' ? 'f' : 't';

        if (op == '&') {
            for (char value : values) {
                if (value == 'f') return 'f';
            }
            return 't';
        }

        if (op == '|') {
            for (char value : values) {
                if (value == 't') return 't';
            }
            return 'f';
        }

        return 'f'; 
    }
}