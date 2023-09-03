package 트라이.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 문자열찾기14425 {

    static class Node {
        private final Map<Character, Node> children = new HashMap<>(); // 자식 노드들에 대한 포인터
        private boolean isLeaf; // 현재 노드까지의 문자열이 완성된 문자열인지 여부

        public Map<Character, Node> getChildren() {
            return children;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }

    }

    static class Trie {
        private final Node root = new Node();

        /**
         * Trie에 문자열을 삽입한다.
         *
         * @param word 삽입할 문자열
         */
        public void insert(String word) {
            Node curNode = root;
            for (char ch : word.toCharArray()) {
                curNode = curNode.getChildren().computeIfAbsent(ch, c -> new Node());
            }
            curNode.setLeaf(true);
        }

        /**
         * Trie내의 문자열을 탐색한다.
         *
         * @param word 탐색할 문자열
         * @return 문자열 존재여부
         */
        public boolean find(String word) {
            Node curNode = root;

            for (char ch : word.toCharArray()) {
                Node nextNode = curNode.getChildren().get(ch);
                if (nextNode == null) {
                    return false;
                }
                curNode = nextNode;
            }

            return curNode.isLeaf();
        }

        /**
         * Trie내의 문자열을 삭제한다
         *
         * @param word 삭제할 문자열
         * @return 삭제성공 여부
         */
        public boolean delete(String word) {
            return delete(root, word, 0);
        }

        private boolean delete(Node curNode, String word, int index) {
            if (index == word.length()) {
                if (!curNode.isLeaf()) {
                    return false;
                }
                curNode.setLeaf(false);
                return curNode.getChildren().isEmpty();
            }

            char ch = word.charAt(index);
            Node node = curNode.getChildren().get(ch);
            if (node == null) {
                return false;
            }

            boolean shouldBeDeleted = delete(node, word, index + 1) && !node.isLeaf();
            if (shouldBeDeleted) {
                curNode.getChildren().remove(ch);
                return curNode.getChildren().isEmpty();
            }

            return false;
        }

    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Trie root = new Trie();
        for (int i = 0; i < tmp[0]; i++) {
            root.insert(br.readLine());
        }

        int answer = 0;
        // 문자 찾기
        for (int i = 0; i < tmp[1]; i++) {
            if(root.find(br.readLine())){
                answer++;
            }

        }
        System.out.println(answer);

    }
}
