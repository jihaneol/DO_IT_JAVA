package 트리.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진트리1991 {
    static int[][] tree;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.valueOf(br.readLine());
        // idx 찾기용

        tree = new int[27][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A'+1;
            int left = st.nextToken().charAt(0);
            int right = st.nextToken().charAt(0);

            if (left != '.') {
                tree[root][0] = left - 'A' + 1;
            }
            if (right != '.') {
                tree[root][1] = right - 'A' + 1;
            }
        }

        sb = new StringBuilder();
        // 전위 루트 왼 오
        find(1);
        sb.append("\n");
        // 중위 왼 루트 오
        in(1);
        sb.append("\n");
        // 후위
        post(1);
        System.out.println(sb.toString());

    }

    static void find(int node) {

        if( node == 0) return;
        sb.append((char)(node-1+'A'));
        int n = tree[node][0];
        find(n);

        int n1 = tree[node][1];
        find(n1);

    }
    static void in(Integer node) {


        if( node == 0) return;
        int n = tree[node][0];
        in(n);
        sb.append((char)(node-1+'A'));

        int n1 = tree[node][1];
        in(n1);

    }
    static void post(Integer node) {


        if( node == 0) return;
        int n = tree[node][0];
        post(n);

        int n1 = tree[node][1];
        post(n1);
        sb.append((char)(node-1+'A'));
    }
}
