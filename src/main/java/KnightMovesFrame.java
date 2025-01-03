/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author L E N O V O
 */
    import java.io.BufferedReader;
import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.PrintWriter;

    import javax.swing.JTextArea;
    import javax.swing.JTextField;
    import java.util.ArrayList;
    import java.util.List;

public class KnightMovesFrame extends javax.swing.JFrame {
    private List<Long> executionTimes = new ArrayList<>();
    private List<Integer> inputSizes = new ArrayList<>();
    
    GerakanKuda gerakan = new GerakanKuda();
    private JTextField inputFilePath;
    private JTextArea outputArea;
    private JTextField langkahInput; // Deklarasi untuk input langkah
    private JTextField langkahField;
    
    // Konstruktor
    public KnightMovesFrame() {
        initComponents();
        outputArea = jTextArea1;
        inputFilePath = jTextField1;
        langkahField = langkahInput;
    }

    private void HitungKuda(boolean useBFS) {
        String filePath = jTextField1.getText().trim();
        if (filePath.isEmpty()) {
            outputArea.setText("File path tidak boleh kosong.");
            return;
        }

        String langkahText = langkahField.getText().trim();
        int langkah;
        try {
            langkah = Integer.parseInt(langkahText);
            if (langkah < 0) {
                outputArea.setText("Jumlah langkah harus angka positif.");
                return;
            }
        } catch (NumberFormatException e) {
            outputArea.setText("Jumlah langkah tidak valid.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            outputArea.setText(""); // Clear output area
            
            // Start timing for the entire operation
            long start = System.nanoTime();
            
            int totalOperations = 0; // Counter for total operations
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 6) {
                    outputArea.append("Format data tidak valid: " + line + "\n");
                    continue;
                }

                try {
                    int ukuranPapan = Integer.parseInt(data[0].trim());
                    int awalX = Integer.parseInt(data[1].trim());
                    int awalY = Integer.parseInt(data[2].trim());
                    int endX = Integer.parseInt(data[3].trim());
                    int endY = Integer.parseInt(data[4].trim());

                    int hasil;
                    if (useBFS) {
                        hasil = gerakan.HitungLangkahBFS_Iteratif(ukuranPapan, awalX, awalY, endX, endY, langkah);
                    } else {
                        hasil = gerakan.HitungLangkahDFS_Rekursif(ukuranPapan, awalX, awalY, endX, endY, langkah);
                    }

                    outputArea.append(String.format("Papan %dx%d, Dari (%d, %d) ke (%d, %d) dalam %d langkah: %d cara\n",
                            ukuranPapan, ukuranPapan, awalX, awalY, endX, endY, langkah, hasil));
                    totalOperations++;
                } catch (NumberFormatException ex) {
                    outputArea.append("Format angka tidak valid pada baris: " + line + "\n");
                }
            }
            
            long end = System.nanoTime();
            long executionTime = (end - start) / 1_000_000; // Convert to milliseconds
            
            // Add single entry for this batch of operations
            inputSizes.add(langkah);
            executionTimes.add(executionTime);
            
            outputArea.append(String.format("\nWaktu eksekusi: %d ms untuk input size %d\n", 
                                          executionTime, langkah));
            
        } catch (IOException e) {
            outputArea.setText("Terjadi kesalahan membaca file: " + e.getMessage());
        }
    }
    
    private void exportExecutionTimes() {
    try (PrintWriter writer = new PrintWriter(new File("execution_times.csv"))) {
        writer.println("InputSize,ExecutionTime");
        for (int i = 0; i < executionTimes.size(); i++) {
            writer.println(inputSizes.get(i) + "," + executionTimes.get(i));
        }
        outputArea.append("\nData running time diekspor ke execution_times.csv\n");
    } catch (Exception e) {
        outputArea.append("\nGagal mengekspor data: " + e.getMessage() + "\n");
    }
}
    
    // Main untuk menjalankan aplikasi
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new KnightMovesFrame().setVisible(true));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFS = new javax.swing.JButton();
        DFS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        langkahInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(15, 15, 15));

        BFS.setText("BFS");
        BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSActionPerformed(evt);
            }
        });

        DFS.setText("DFS");
        DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSActionPerformed(evt);
            }
        });

        exportButton = new javax.swing.JButton();
        exportButton.setText("Ekspor Running Time");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExecutionTimes();
            }
        });

        jLabel1.setText("Kalkulator Gerakan Kuda di Papan Catur");

        langkahInput.setText("Masukkan langkah di sini"); // Label langkahInput

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(15, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(96, 96, 96))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(langkahInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE) // Tambahkan langkahInput
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DFS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BFS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(164, 164, 164))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())))
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addComponent(jLabel1)
            .addGap(43, 43, 43)
            .addComponent(BFS)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(DFS)
            .addGap(27, 27, 27)
            .addComponent(exportButton)
            .addGap(10) // Tambahkan jarak vertikal (opsional)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(langkahInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Tambahkan langkahInput
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSActionPerformed
        HitungKuda(true); // bfs
    }//GEN-LAST:event_BFSActionPerformed

    private void DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSActionPerformed
        HitungKuda(false); // dfs
    }//GEN-LAST:event_DFSActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFS;
    private javax.swing.JButton DFS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton exportButton;
    // End of variables declaration//GEN-END:variables
}
