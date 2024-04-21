class MinStack {
    int minEle;
    Stack<Long> s;

    public MinStack() {
        s = new Stack<Long>();
    }

    public void push(int val) {

        if (s.isEmpty()) {
            s.push((long) val);
            minEle = val;
            return;
        }

        if (val < minEle) {
            // create Hash with prev minEle & current min ele that is going to be
            // initialised & store it
            // val<minELe so that val-minEle<0 => would be less than both
            long hash = 2 * (long) val - minEle;
            s.push(hash);
            minEle = val;
        } else {
            // val>=s.peek()
            s.push((long) val);
        }

    }

    public void pop() {
        Long top = s.peek();

        if (top < minEle) {
            // this implies hash is created here with earlier minEle so decode it
            long hash = top;
            // finding last minEle using Hash & minEle
            int prevMin = (int) (2 * minEle - hash);
            // declaring earlier as current minEle removed
            minEle = prevMin;
        }

        s.pop();
    }

    public int top() {
        long top = s.peek();
        if (top < minEle) {
            return minEle;
        }
        return (int) top;
    }

    public int getMin() {
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */