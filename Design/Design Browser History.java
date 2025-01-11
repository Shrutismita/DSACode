Q:- https://leetcode.com/problems/design-browser-history/
 Company Tags                : META
 ***************************************************************************************
  class BrowserHistory {
      Stack<String> past = new Stack<>(); //back
        Stack<String> future = new Stack<>(); //future
        String curr;
    public BrowserHistory(String homepage) {
        curr = homepage;
    }
    
    public void visit(String url) {
        past.push(curr);
        curr = url;
        future = new Stack<>();
    }
    
    public String back(int steps) {
        while(steps > 0 && !past.isEmpty()) {
            future.push(curr);
            curr = past.peek();
            past.pop();
            steps--;
        }
        return curr;
    }
    
    public String forward(int steps) {
        while(steps > 0 && !future.isEmpty())
        {
            past.push(curr);
            curr = future.peek();
            future.pop();
            steps--;
        }
        return curr;
    }
}
