import java.util.*;

public class leetcode133 {
    /*
     * topics Hash Table, DFS, BFS, Graph
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /*
     * DFS
     * O(V + E)
     * V : 정점수 (각 노드 한번씩 방문)
     * E : 간선수 (각 노드의 이웃탐색시 한번씩)
     */
    class Solution {
        Map<Node, Node> map = new HashMap<>(); // visited 역할을 하는 map

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node)) {
                return map.get(node); // 이미 방문한 노드이면 map에서 꺼내서 반환
            }

            Node newNode = new Node(node.val);
            map.put(node, newNode); // 방문한적 없으면 방문처리

            for (Node neighbor : node.neighbors) {
                Node cloneNode = cloneGraph(neighbor);
                newNode.neighbors.add(cloneNode);
            }

            return newNode;
        }
    }
}
