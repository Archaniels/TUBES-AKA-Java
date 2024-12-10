package com.method.tubesaka;

import java.util.Scanner;

public class TUBESAKA {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            GerakanKuda testBFS = new GerakanKuda();
            GerakanKuda testDFS = new GerakanKuda();
            System.out.println("================== Menu Pilihan ==================");
            System.out.println("1. Hitung jumlah cara (BFS)");
            System.out.println("2. Hitung jumlah cara (DFS)");
            System.out.println("3. Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih opsi (1-3): ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n=== BFS ===");
                    System.out.print("Masukkan ukuran papan (N): ");
                    int n = input.nextInt();
                    System.out.print("Masukkan posisi awal (x1 y1): ");
                    int x1 = input.nextInt();
                    int y1 = input.nextInt();
                    System.out.print("Masukkan posisi tujuan (x2 y2): ");
                    int x2 = input.nextInt();
                    int y2 = input.nextInt();
                    System.out.print("Masukkan langkah maksimal (k): ");
                    int k = input.nextInt();
                    /////////////////////////////////////////////////////////////////////////// BELOM
                }
                case 2 -> {
                    System.out.println("\n=== DFS ===");
                    System.out.print("Masukkan ukuran papan (N): ");
                    int n = input.nextInt();
                    System.out.print("Masukkan posisi awal (x1 y1): ");
                    int x1 = input.nextInt();
                    int y1 = input.nextInt();
                    System.out.print("Masukkan posisi tujuan (x2 y2): ");
                    int x2 = input.nextInt();
                    int y2 = input.nextInt();
                    System.out.print("Masukkan langkah maksimal (k): ");
                    int k = input.nextInt();

                    /////////////////////////////////////////////////////////////////////////// BELOM
                }
                case 3 -> {
                    System.out.println("Keluar program. Terima kasih!");
                    input.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
