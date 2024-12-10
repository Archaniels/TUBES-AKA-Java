# [TUBES] Analisis Kompleksitas Algoritma dalam Java

![strategy_horse_chess_icon_187180](https://github.com/user-attachments/assets/1fb39449-632b-4fb3-8ca6-f4e524b7040a)

## Menentukan Jumlah Cara Kuda Dapat Mencapai Kotak Tertentu di Papan Catur
Deskripsi Masalah: Pada permainan catur, bidak kuda memiliki pola gerakan unik yang berbentuk huruf "L". Studi kasus ini berfokus pada menghitung jumlah cara kuda dapat mencapai suatu kotak tertentu pada papan catur berukuran N * N  posisi awal tertentu, dalam beberapa langkah tertentu. Studi kasus ini bisa digunakan untuk mempelajari pola gerakan bidak kuda serta penerapan algoritma pencarian jalur.

Algoritma yang Dipilih:
1. Iteratif (Breadth-First Search - BFS): Algoritma BFS dapat diterapkan untuk menghitung semua kemungkinan gerakan kuda dari posisi awal hingga mencapai target. Algoritma ini melibatkan eksplorasi semua kemungkinan gerakan pada setiap langkah.
2. Rekursif (Depth-First Search - DFS): Algoritma DFS rekursif akan menelusuri setiap jalur gerakan kuda secara mendalam, memeriksa apakah setiap gerakan dapat membawa kuda ke target.
