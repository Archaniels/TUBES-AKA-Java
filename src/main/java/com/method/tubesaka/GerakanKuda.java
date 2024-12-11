package com.method.tubesaka;

public class GerakanKuda {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public int HitungLangkahBFS_Iteratif(int n, int x1, int y1, int x2, int y2, int k) {
        int[][][] dp = new int[n][n][k + 1];
        dp[x1][y1][0] = 1;

        for (int steps = 1; steps <= k; steps++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (dp[x][y][steps - 1] > 0) {
                        for (int i = 0; i < 8; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                dp[nx][ny][steps] += dp[x][y][steps - 1];
                            }
                        }
                    }
                }
            }
        }
        int hasil = 0;
        for (int steps = 0; steps <= k; steps++) {
            hasil += dp[x2][y2][steps];
        }
        return hasil;
    }
    
    public int HitungLangkahDFS_Rekursif(int n, int x, int y, int x2, int y2, int k) {
        /////////////////////////////////////////////////////////////////////////// BELOM
        
}
