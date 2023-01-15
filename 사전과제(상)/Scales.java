import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Scales {
    static int tc, N, res, arr[], weight[];
    static boolean used[];
 
    private static void balances(int cnt) {
        if (cnt == N) {
            check(0, 0, 0);
            return;
        }
 
        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            weight[cnt] = arr[i];
            balances(cnt + 1);
            used[i] = false;
        }
    }
 
    public static void check(int idx, int sumL, int sumR) {
        if (idx == N) {
            res++;
            return;
        }
        check(idx + 1, sumL + weight[idx], sumR);
        if (sumR + weight[idx] <= sumL) {
            check(idx + 1, sumL, sumR + weight[idx]);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            res = 0;
            N = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            weight = new int[N];
 
            for (int j = 0; j < weight.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
 
            used = new boolean[N];
            balances(0);
            System.out.println("#" + i + " " + res);
        }
    }
 
}