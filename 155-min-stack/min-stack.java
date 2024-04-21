class MinStack {
    Long minEle;
    Stack<Long> s;
    public MinStack() {
        s=new Stack<Long>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long)val);
            minEle=(long)val;
        }else{
            if(val<minEle){
              s.push(2*(long)val-minEle);
              minEle=(long)val;
            }else{
            s.push((long)val);
            }
        }
    }
    
    public void pop() {
        Long top=s.peek();
        if(top<minEle){
            minEle=2*minEle-top;
        }
       s.pop();
    }
    
    public int top() {
          Long top=s.peek();
        if(top<minEle){
           return minEle.intValue();
        }
        return s.peek().intValue();
    }
    
    public int getMin() {
        return minEle.intValue();
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