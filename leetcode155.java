import java.util.ArrayList;
import java.util.List;

public class leetcode155 {
    class MinStack {
        // {min, val}
        private List<int[]> ms;

        public MinStack() {
            ms = new ArrayList<>();
        }

        public void push(int val) {
            if (ms.isEmpty()) {
                ms.add(new int[] { val, val });
            } else {
                int[] top = ms.get(ms.size() - 1);
                if (val < top[0]) {
                    ms.add(new int[] { val, val });
                    ;
                } else {
                    ms.add(new int[] { top[0], val });
                }
            }
        }

        public void pop() {
            ms.remove(ms.size() - 1);
        }

        public int top() {
            return ms.get(ms.size() - 1)[1];
        }

        public int getMin() {
            return ms.get(ms.size() - 1)[0];
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
}
