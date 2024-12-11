package com.method.tubesaka;

public class GerakanKuda {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public int HitungLangkahBFS_Iteratif(int n, int x1, int y1, int x2, int y2, int k) {
        /*
        n = Ukuran papan catur (N x N)
        (x1, y1) = Koordinat awal kuda
        (x2, y2) = Koordinat tujuan kuda
        k = jumlah step yang diinginkan
        */
        
        // array 3D
        int[][][] status = new int[n][n][k + 1];
        status[x1][y1][0] = 1;

        for (int steps = 1; steps <= k; steps++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (status[x][y][steps - 1] > 0) {
                        for (int i = 0; i < 8; i++) {
                            int nx = x + dx[i];
                            int     ny = y + dy[i];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                status[nx][ny][steps] += status[x][y][steps - 1];
                            }
                        }
                    }
                }
            }
        }
        int hasil = 0;
        for (int steps = 0; steps <= k; steps++) {
            hasil += status[x2][y2][steps];
        }
        return hasil;
    }
    
    public int HitungLangkahDFS_Rekursif(int n, int x, int y, int x2, int y2, int k) {
        /////////////////////////////////////////////////////////////////////////// BELOM
        
}
