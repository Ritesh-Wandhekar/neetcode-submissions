class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      while ((!stack.isEmpty()) && heights[stack.peek()] > heights[i]) {
        int h = 0;
        int width = 0;

        int top = stack.pop();
        if (stack.isEmpty()) {
          width = i;
        } else {
          width = i - stack.peek() - 1;
        }
        h = heights[top];

        int area = h * width;
        if (area > max) {
          max = area;
        }
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      int h = 0;
      int width = 0;
      int area = 0;
      int top = stack.pop();
      h = heights[top];
      if (stack.isEmpty()) {
        width = heights.length;
      } else {
        width = heights.length - stack.peek() - 1;
      }

      area = h * width;
      if (area > max) {
        max = area;
      }
    }
    return max;
  }
}
