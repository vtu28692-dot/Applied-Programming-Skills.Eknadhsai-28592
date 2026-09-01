import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> s1; // Input stack
    private Deque<Integer> s2; // Output stack

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        moveInputToOutput();
        return s2.pop();
    }
    
    public int peek() {
        moveInputToOutput();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Helper method to transfer elements from s1 to s2 when s2 is empty
    private void moveInputToOutput() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}