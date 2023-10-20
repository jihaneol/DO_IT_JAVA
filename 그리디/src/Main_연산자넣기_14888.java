package 그리디.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_연산자넣기_14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums[] = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.valueOf(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int oper[] = new int[4];
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.valueOf(st.nextToken());
        }

        solution(nums, oper, 1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void solution(int[] nums, int[] oper, int idx, int total) {
        if (idx == nums.length) {
            if (max < total) max = total;
            if (min > total) min = total;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) continue;

            oper[i]--;

            switch (i) {
                case 0: solution(nums, oper, idx + 1, total + nums[idx]);break;
                case 1: solution(nums, oper, idx + 1, total - nums[idx]); break;
                case 2: solution(nums, oper, idx + 1, total * nums[idx]);break;
                case 3: solution(nums, oper, idx + 1, total / nums[idx]);break;
            }

            oper[i]++;

        }

    }
}