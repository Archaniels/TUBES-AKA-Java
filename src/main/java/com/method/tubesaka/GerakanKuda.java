package com.method.tubesaka;

public class GerakanKuda {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public int HitungLangkahBFS_Iteratif(int ukuranPapan, int awalX, int awalY, int tujuanX, int tujuanY, int jumlahLangkah) {
        /*
        n = Ukuran papan catur (N x N)
        (x1, y1) = Koordinat awal kuda
        (x2, y2) = Koordinat tujuan kuda
        k = jumlah step yang diinginkan
        */
        
        // representasi array 3D
        int[][][] dp = new int[ukuranPapan][ukuranPapan][jumlahLangkah + 1];
        dp[awalX][awalY][0] = 1;

        for (int langkahSaatIni = 1; langkahSaatIni <= jumlahLangkah; langkahSaatIni++) {
            for (int posisiX = 0; posisiX < ukuranPapan; posisiX++) {
                for (int posisiY = 0; posisiY < ukuranPapan; posisiY++) {
                    if (dp[posisiX][posisiY][langkahSaatIni - 1] > 0) {
                        for (int arah = 0; arah < 8; arah++) {
                            int posisiBaruX = posisiX + dx[arah];
                            int posisiBaruY = posisiY + dy[arah];
                            if (posisiBaruX >= 0 && posisiBaruX < ukuranPapan && posisiBaruY >= 0 && posisiBaruY < ukuranPapan) {
                                dp[posisiBaruX][posisiBaruY][langkahSaatIni] += dp[posisiX][posisiY][langkahSaatIni - 1];
                            }
                        }
                    }
                }
            }
        }
        
        int totalLangkah = 0;
        for (int langkahSaatIni = 0; langkahSaatIni <= jumlahLangkah; langkahSaatIni++) {
            totalLangkah += dp[tujuanX][tujuanY][langkahSaatIni];
        }
        return totalLangkah;
    }
    
    public int HitungLangkahDFS_Rekursif(int n, int x, int y, int x2, int y2, int k) {
        /////////////////////////////////////////////////////////////////////////// BELOM  
    }
}