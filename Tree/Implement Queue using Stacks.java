Q:- https://leetcode.com/problems/implement-queue-using-stacks/

T.C:- O(n)
S.C:- O(n)

====================================================================================
  class MyQueue {
private Stack<Integer> input;
    private Stack<Integer> output;
    private int peekEl;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
        peekEl = -1;
    }

    public void push(int x) {
        if (input.empty()) {
            peekEl = x;
        }
        input.push(x);
    }

    // Amortized O(1)
    public int pop() {
        if (output.empty()) {
            // Transfer elements from input to output (O(n))
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        int val = output.pop();
        return val;
    }

    public int peek() {
        if (output.empty()) {
            return peekEl;
        }

        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
