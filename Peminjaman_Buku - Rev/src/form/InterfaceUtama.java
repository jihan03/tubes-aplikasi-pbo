/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JIHAN
 */
public class InterfaceUtama extends javax.swing.JFrame {
    Mahasiswa[] dataMahasiswa = {
        new Mahasiswa(117705001, "Aaz", "Teknik Informatika"),
        new Mahasiswa(116706003, "Rizal", "Teknik Elektro"),
        new Mahasiswa(117704012, "Jihan", "Teknik Informatika"),
        new Mahasiswa(1114020567, "Jennie", "Teknik Elektro"), 
        new Mahasiswa(1177050205, "Sharon","Teknik Informatika" )
    };
        
    Buku[] dataBuku = {
        new Buku(1, "Harry Potter"),
        new Buku(2, "Kalkulus", 2013, "Rinaldi Munir"),
        new Buku(3, "Laskar Penlangi", 2005, "Melani"),
        new Buku(4, "Hujan", 2018, "awkarin")    
    };
    Peminjam[] dataPeminjam = {
        new Peminjam(1177050205, "Sharon", "Teknik Informatika", 5, "Sang Pemimpi", 2009, 23),
        new Peminjam(1177050010, "Mina", "Teknik Informatika", 9, "Dear Nathan", 2016, 3),
        new Peminjam(1114020567, "Jennie", "Teknik Elektro", 4, "Dear Salma", 2018, 2),
        new Peminjam(1120020549, "Lisa", "Biologi", 3, "That Night", 2018, 14)
        
    };
    private Buku hasilCariBuku;
    private Mahasiswa hasilCariMahasiswa;
    private Peminjam hasilCariPeminjam;
    
    /**
     * Creates new form form_utama
     */
    public InterfaceUtama() {
        initComponents();
        tampilTabelMahasiswa();
        tampilTabelBuku();
        tampilTabelPeminjam();
    }
    
    public void tampil_tb_peminjaman(){
        Object []baris = {"NIM","Nama","Jurusan","Kode Buku","Judul Buku","Tahun Terbit","Tanggal Pinjam"};
        DefaultTableModel tabmode = new DefaultTableModel(null, baris);
        //tb_peminjaman.setModel(tabmode);
        Connection con = new koneksi_mysql().getConnection();
        try {
            String sql = "select * from tb_peminjaman order by no_bp asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){

                String nim = hasil.getString("nim");
                String nama = hasil.getString("nama");
                String jurusan = hasil.getString("jurusan");
                String kode_buku = hasil.getString("kode_buku");
                String judul_buku = hasil.getString("judul_buku");
                String tanggal_terbit = hasil.getString("tanggal_terbit");
                String tanggal_pinjam = hasil.getString("tanggal_pinjam");
                String[] data = {nim, nama, jurusan, kode_buku, judul_buku, tanggal_terbit, tanggal_pinjam};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tb_buku(){
        Object []baris = {"Kode Buku","Judul Buku","Tanggal Terbit","Pengarang"};
        DefaultTableModel tabmode = new DefaultTableModel(null, baris);
        //tb_buku.setModel(tabmode);
        Connection con = new koneksi_mysql().getConnection();
        try {
            String sql = "select * from tb_buku order by kode_buku asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String kode_buku = hasil.getString("kode_buku");
                String judul_buku = hasil.getString("judul_buku");
                String tanggal_terbit = hasil.getString("tanggal_terbit");
                String pengarang = hasil.getString("pengarang");
                String[] data = {kode_buku, judul_buku, tanggal_terbit, pengarang};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void tampilTabelBuku(){
        for(int i = 0 ; i < dataBuku.length ; i++){
            // Kode Buku
            jTable3.setValueAt(dataBuku[i].getKodeBuku(), i, 0);
            // Judul Buku
            jTable3.setValueAt(dataBuku[i].getJudulBuku(), i, 1);
            // Tahun Terbit
            jTable3.setValueAt(dataBuku[i].getTahunTerbit(), i, 2);
            // Pengarang
            jTable3.setValueAt(dataBuku[i].getPengarang(), i, 3);
        }
    }    
    public void tampilTabelMahasiswa(){
        for(int i = 0 ; i < dataMahasiswa.length ; i++){
            // NIM
            jTable1.setValueAt(dataMahasiswa[i].getNim(), i, 0);
            // Nama
            jTable1.setValueAt(dataMahasiswa[i].getNama(), i, 1);
            // Jurusan
            jTable1.setValueAt(dataMahasiswa[i].getJurusan(), i, 2);
        }
    }
    public void tampilTabelPeminjam(){
        for(int i = 0; i < dataPeminjam.length; i++){
            // NIM
            jTable2.setValueAt(dataPeminjam[i].getNim(), i, 0);
            // Nama
            jTable2.setValueAt(dataPeminjam[i].getNama(), i, 1);
            // Jurusan
            jTable2.setValueAt(dataPeminjam[i].getJurusan(), i, 2);
            // Kode Buku
            jTable2.setValueAt(dataPeminjam[i].getKodeBuku(), i, 3);
            // Judul Buku
            jTable2.setValueAt(dataPeminjam[i].getJudulBuku(), i, 4);
            // Tahun Terbit
            jTable2.setValueAt(dataPeminjam[i].getTahunTerbit(), i, 5);
            // Tanggal Pinjam
            jTable2.setValueAt(dataPeminjam[i].getTanggalPinjam(), i, 6);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        data_mahasiswa = new javax.swing.JPanel();
        cari = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Peminjaman = new javax.swing.JPanel();
        pencarian = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        data_buku = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        tombol_pencarian1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        data_mahasiswa.setBackground(new java.awt.Color(255, 204, 204));

        cari.setText("Cari");
        cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cariMousePressed(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIM", "Nama ", "Jurusan "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/proses_1.png"))); // NOI18N
        jButton1.setText("Refresh Tabel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout data_mahasiswaLayout = new javax.swing.GroupLayout(data_mahasiswa);
        data_mahasiswa.setLayout(data_mahasiswaLayout);
        data_mahasiswaLayout.setHorizontalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                .addContainerGap(648, Short.MAX_VALUE)
                .addGroup(data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cari)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_mahasiswaLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(63, 63, 63))))
            .addComponent(jScrollPane1)
        );
        data_mahasiswaLayout.setVerticalGroup(
            data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mahasiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_mahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(96, 96, 96))
        );

        jTabbedPane1.addTab("Data Mahasiswa", data_mahasiswa);

        Peminjaman.setBackground(new java.awt.Color(255, 204, 204));

        pencarian.setText("Cari");
        pencarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pencarianMousePressed(evt);
            }
        });
        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama ", "Jurusan", "Kode Buku ", "Judul Buku", "Tahun Terbit", "Tanggal Pinjam"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/proses_1.png"))); // NOI18N
        jButton4.setText("Refresh Tabel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout PeminjamanLayout = new javax.swing.GroupLayout(Peminjaman);
        Peminjaman.setLayout(PeminjamanLayout);
        PeminjamanLayout.setHorizontalGroup(
            PeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PeminjamanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PeminjamanLayout.createSequentialGroup()
                        .addGroup(PeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PeminjamanLayout.createSequentialGroup()
                                .addGap(0, 531, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addComponent(pencarian)))
                .addContainerGap())
        );
        PeminjamanLayout.setVerticalGroup(
            PeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PeminjamanLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pencarian)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton4)
                .addGap(70, 70, 70))
        );

        jTabbedPane1.addTab("Peminjaman", Peminjaman);

        data_buku.setBackground(new java.awt.Color(255, 102, 102));

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tombol_pencarian1.setText("Cari");
        tombol_pencarian1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tombol_pencarian1MousePressed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Buku ", "Judul Buku ", "Tahun Terbit", "Pengarang"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/proses_1.png"))); // NOI18N
        jButton6.setText("Refresh Tabel");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout data_bukuLayout = new javax.swing.GroupLayout(data_buku);
        data_buku.setLayout(data_bukuLayout);
        data_bukuLayout.setHorizontalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_bukuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_bukuLayout.createSequentialGroup()
                        .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(data_bukuLayout.createSequentialGroup()
                                .addGap(0, 542, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(tombol_pencarian1)
                        .addContainerGap())))
        );
        data_bukuLayout.setVerticalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_pencarian1))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Data Buku", data_buku);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("APLIKASI PEMINJAMAN BUKU ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 913, 626);
    }// </editor-fold>//GEN-END:initComponents

    // Mencari Nim Mahasiswa
    private void cariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariMousePressed
        hasilCariMahasiswa = null;
        
        // Mengkosongkan nilai tabel
        for (int i = 0 ; i < dataMahasiswa.length ; i++){
            jTable1.setValueAt( null, i, 0);
            jTable1.setValueAt( null, i, 1);
            jTable1.setValueAt( null, i, 2);
        }
        int pencarian = Integer.parseInt(jTextField1.getText());
        for (int i = 0 ; i < dataMahasiswa.length ; i++){
            if (dataMahasiswa[i].getNim() == pencarian){
                hasilCariMahasiswa = dataMahasiswa[i];
            }
        }
        if (hasilCariMahasiswa != null){
            jTable1.setValueAt(hasilCariMahasiswa.getNim(), 0, 0);
            jTable1.setValueAt(hasilCariMahasiswa.getNama(), 0, 1);
            jTable1.setValueAt(hasilCariMahasiswa.getJurusan(), 0, 2);
        }
    }//GEN-LAST:event_cariMousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        tampilTabelMahasiswa();
    }//GEN-LAST:event_jButton1MousePressed

    private void tombol_pencarian1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombol_pencarian1MousePressed
        hasilCariBuku = null;
        
        // Mengkosongkan nilai tabel
        for (int i = 0 ; i < dataBuku.length ; i++){
            jTable3.setValueAt( null, i, 0);
            jTable3.setValueAt( null, i, 1);
            jTable3.setValueAt( null, i, 2);
            jTable3.setValueAt( null, i, 3);
        }
        int pencarian = Integer.parseInt(jTextField3.getText());
        for (int i = 0 ; i < dataBuku.length ; i++){
            if (dataBuku[i].getKodeBuku()== pencarian){
                hasilCariBuku = dataBuku[i];
            }
        }
        if (hasilCariBuku != null){
            jTable3.setValueAt(hasilCariBuku.getKodeBuku(), 0, 0);
            jTable3.setValueAt(hasilCariBuku.getJudulBuku(), 0, 1);
            jTable3.setValueAt(hasilCariBuku.getTahunTerbit(), 0, 2);
            jTable3.setValueAt(hasilCariBuku.getPengarang(), 0, 3);
        }
    }//GEN-LAST:event_tombol_pencarian1MousePressed

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        tampilTabelBuku();
    }//GEN-LAST:event_jButton6MousePressed

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pencarianActionPerformed

    private void pencarianMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pencarianMousePressed
        hasilCariPeminjam = null;
        
        // Mengkosongkan nilai tabel
        for (int i = 0 ; i < dataPeminjam.length ; i++){
            jTable2.setValueAt( null, i, 0);
            jTable2.setValueAt( null, i, 1);
            jTable2.setValueAt( null, i, 2);
            jTable2.setValueAt( null, i, 3);
            jTable2.setValueAt( null, i, 4);
            jTable2.setValueAt( null, i, 5);
            jTable2.setValueAt( null, i, 6);
            
        }
        int pencarian = Integer.parseInt(jTextField2.getText());
        for (int i = 0 ; i < dataBuku.length ; i++){
            if (dataPeminjam[i].getNim() == pencarian){
                hasilCariPeminjam = dataPeminjam[i];
            }
        }
        if (hasilCariPeminjam != null){
            jTable2.setValueAt(hasilCariPeminjam.getNim(), 0, 0);
            jTable2.setValueAt(hasilCariPeminjam.getNama(), 0, 1);
            jTable2.setValueAt(hasilCariPeminjam.getJurusan(), 0, 2);
            jTable2.setValueAt(hasilCariPeminjam.getKodeBuku(), 0, 3);
            jTable2.setValueAt(hasilCariPeminjam.getJudulBuku(), 0, 4);
            jTable2.setValueAt(hasilCariPeminjam.getTahunTerbit(), 0, 5);
            jTable2.setValueAt(hasilCariPeminjam.getTanggalPinjam(), 0, 6);
        }
    }//GEN-LAST:event_pencarianMousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        tampilTabelPeminjam();
    }//GEN-LAST:event_jButton4MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfaceUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Peminjaman;
    private javax.swing.JButton cari;
    private javax.swing.JPanel data_buku;
    private javax.swing.JPanel data_mahasiswa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton pencarian;
    private javax.swing.JButton tombol_pencarian1;
    // End of variables declaration//GEN-END:variables
}
