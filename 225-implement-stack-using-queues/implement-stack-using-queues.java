class MyStack {
  Queue<Integer> queue1 , queue2 ;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
      while(queue1.size() > 0)
      {
        queue2.add(queue1.peek());   // just for reverse
        queue1.poll();
      }  
      queue1.add(x);
      while(queue2.size()>0){
        queue1.add(queue2.peek());
        queue2.poll();
      }

    }
    
    public int pop() {
     return queue1.poll();
    }
    
    public int top() {
      return queue1.peek();  
    }
    
    public boolean empty() {
        return queue1.isEmpty(); 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */