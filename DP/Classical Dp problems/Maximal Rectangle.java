Q:- https://leetcode.com/problems/maximal-rectangle/
*******************************************************************************
  class Solution {
    int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Pair<Integer, Integer>> stack = new LinkedList<>(); // index,height

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> pair = stack.pop();
                Integer index = pair.getKey();
                Integer height = pair.getValue();

                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new Pair<>(start, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            Integer index = pair.getKey();
            Integer height = pair.getValue();
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1')
                height[i] += 1;
            else
                height[i] = 0;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[] height = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1')
                height[i] = 1;
        }

        int result = largestRectangleArea(height);

        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix,height,i);
            result = Math.max(result, largestRectangleArea(height));
        }
        return result;
    }
}
