
package newpackage;

import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DashKitapSorgu extends javax.swing.JFrame {
    
    DB db = new DB();

 
    public DashKitapSorgu() {
        initComponents();
        String arama = null;
        kitapSorgula(arama);
        kitapKontrol();
        kategoriKontrol();
        btnSettings();
        btnOff();


    }
    
    private void btnSettings() {
        int offset = btnSettings.getInsets().left;
        btnSettings.setIcon(resizeIcon((ImageIcon) btnSettings.getIcon(),
        btnSettings.getWidth() - offset - 24, 
        btnSettings.getHeight() - offset));
    }
        
    private void btnOff() {
        int offset = btnOff.getInsets().left;
        btnOff.setIcon(resizeIcon((ImageIcon) btnOff.getIcon(),
        btnOff.getWidth() - offset - 24, 
        btnOff.getHeight() - offset));
    }
    
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}
    
    private void kitapSorgula(String arama) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("bookId");
        dtm.addColumn("kitapTur");
        dtm.addColumn("kitapAdi");
        dtm.addColumn("kisaAciklama");
        dtm.addColumn("yazarAdi");
        dtm.addColumn("yayinevi");
        dtm.addColumn("kitapDili");
        dtm.addColumn("rafNo");
        
        
        try {
            String query = "SELECT * FROM `tbl_sonuc` WHERE `kitapAdi` LIKE ?";
            PreparedStatement pre = db.preBaglan(query); 
            pre.setString(1, '%' + arama + '%');
            ResultSet rs = pre.executeQuery();

            while(rs.next()) { 
                String book_id = rs.getString("bookId");
                String kitap_turu = rs.getString("kitapTur");
                String kitap_adi = rs.getString("kitapAdi");
                String kisa_aciklama = rs.getString("kisaAciklama");
                String yazar_adi = rs.getString("yazarAdi");
                String yayin_evi = rs.getString("yayinevi");
                String kitap_dili = rs.getString("kitapDili");
                String raf_no = rs.getString("rafNo");
                
                String [] row = {book_id, kitap_turu, kitap_adi,kisa_aciklama, yazar_adi, yayin_evi, kitap_dili, raf_no };
                dtm.addRow(row);

            }
            
        } catch (Exception e) {
            System.err.println("Kitap Sorgula Error : " + e );
        }
        tableSorgula.setModel(dtm);
    } 
    
    private void kitapKontrol() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("bookId");
        dtm.addColumn("kitapTur");
        dtm.addColumn("kitapAdi");
        dtm.addColumn("kisaAciklama");
        dtm.addColumn("yazarAdi");
        dtm.addColumn("yayinevi");
        dtm.addColumn("kitapDili");
        dtm.addColumn("rafNo");
        
        
        try {
            String query = "SELECT * FROM `tbl_sonuc`";
            PreparedStatement pre = db.preBaglan(query); 
            ResultSet rs = pre.executeQuery();

            while(rs.next()) { 
                String book_id = rs.getString("bookId");
                String kitap_turu = rs.getString("kitapTur");
                String kitap_adi = rs.getString("kitapAdi");
                String kisa_aciklama = rs.getString("kisaAciklama");
                String yazar_adi = rs.getString("yazarAdi");
                String yayin_evi = rs.getString("yayinevi");
                String kitap_dili = rs.getString("kitapDili");
                String raf_no = rs.getString("rafNo");
                
                String [] row = {book_id, kitap_turu, kitap_adi,kisa_aciklama, yazar_adi, yayin_evi, kitap_dili, raf_no };
                dtm.addRow(row);

            }
            
        } catch (Exception e) {
            System.err.println("Kitap Sorgula Error : " + e );
        }
        tableKitapKontrol.setModel(dtm);
        
    }
    
     private void kategoriKontrol() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("kategoriId");
        dtm.addColumn("turAdi");
        dtm.addColumn("stantNo");
        dtm.addColumn("stantAdres");
        try {
            String query = "SELECT * FROM `kategori`";
            PreparedStatement pre = db.preBaglan(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String kId = rs.getString("kategoriId");
                String kAd = rs.getString("turAdi");
                String sNo = rs.getString("stantNo");
                String sAdr = rs.getString("stantAdres");

                String[] row = {kId, kAd, sNo, sAdr};
                dtm.addRow(row);

            }
        } catch (Exception e) {
            System.err.println("Kategori Kontrol Error : " + e);
        }
        tableKategoriKontrol.setModel(dtm);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anaEkran = new javax.swing.JTabbedPane();
        kitapSorgula = new javax.swing.JPanel();
        txt_ara = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSorgula = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_kitap_adi = new javax.swing.JTextField();
        txt_kitap_turu = new javax.swing.JTextField();
        txt_yazar_adi = new javax.swing.JTextField();
        txt_kitap_dili = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_yayin_evi = new javax.swing.JTextField();
        txt_raf_no = new javax.swing.JTextField();
        txt_kisa_aciklama = new javax.swing.JTextField();
        kitapKontrol = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_kad = new javax.swing.JTextField();
        txt_yad = new javax.swing.JTextField();
        txt_kdil = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_aciklama = new javax.swing.JTextField();
        txt_yevi = new javax.swing.JTextField();
        txt_rno = new javax.swing.JTextField();
        txt_ktur = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_yeni_ekle = new javax.swing.JButton();
        btn_duzenle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_temizle = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKitapKontrol = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_kategori_adi = new javax.swing.JTextField();
        txt_stant_no = new javax.swing.JTextField();
        txt_stant_adres = new javax.swing.JTextField();
        btn_ekle = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKategoriKontrol = new javax.swing.JTable();
        btn_silme = new javax.swing.JButton();
        btn_duzen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSettings = new javax.swing.JButton();
        btnOff = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_ara.setText("Ara");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });

        jLabel1.setText("Arama");

        tableSorgula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableSorgula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSorgulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSorgula);

        jLabel5.setText("Sonuçlar");

        jLabel6.setText("Detay");

        jLabel7.setText("Kitap Adı");

        jLabel8.setText("Kitap Türü");

        jLabel9.setText("Yazar Adı");

        jLabel10.setText("Kitap Dili");

        txt_kitap_adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kitap_adiActionPerformed(evt);
            }
        });

        jLabel11.setText("Yayın Evi");

        jLabel12.setText("Raf No:");

        jLabel13.setText("Kısa Açkl");

        txt_yayin_evi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_yayin_eviActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(33, 33, 33)
                            .addComponent(txt_kitap_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kitap_dili, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txt_yazar_adi)
                            .addComponent(txt_kitap_turu))
                        .addGap(2, 2, 2)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_yayin_evi)
                    .addComponent(txt_raf_no)
                    .addComponent(txt_kisa_aciklama, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_kitap_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_yayin_evi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_kitap_turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_raf_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_yazar_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_kisa_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_kitap_dili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kitapSorgulaLayout = new javax.swing.GroupLayout(kitapSorgula);
        kitapSorgula.setLayout(kitapSorgulaLayout);
        kitapSorgulaLayout.setHorizontalGroup(
            kitapSorgulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kitapSorgulaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kitapSorgulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(kitapSorgulaLayout.createSequentialGroup()
                        .addComponent(txt_ara)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kitapSorgulaLayout.createSequentialGroup()
                        .addGroup(kitapSorgulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kitapSorgulaLayout.setVerticalGroup(
            kitapSorgulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kitapSorgulaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(kitapSorgulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ara))
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        anaEkran.addTab("Kitap Sorgula", kitapSorgula);

        jLabel14.setText("Kitap Ekle");

        jLabel15.setText("Kitap Türü: ");

        jLabel16.setText("Kitap Adı:");

        jLabel17.setText("Yazar Adı:");

        jLabel18.setText("Kitap Dili:");

        txt_kad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kadActionPerformed(evt);
            }
        });

        jLabel19.setText("Kısa Açıklama:");

        jLabel20.setText("Yayın Evi:");

        jLabel21.setText("Raf No:");

        txt_yevi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_yeviActionPerformed(evt);
            }
        });

        txt_rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kad)
                            .addComponent(txt_yad)
                            .addComponent(txt_kdil)
                            .addComponent(txt_ktur, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txt_aciklama))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_rno, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(txt_yevi))))))
                .addGap(44, 44, 44))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_ktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_kad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_aciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_yad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txt_yevi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_kdil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txt_rno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel2.setText("Bilgilendirme ve Hareketler");

        btn_yeni_ekle.setText("Yeni Ekle");
        btn_yeni_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yeni_ekleActionPerformed(evt);
            }
        });

        btn_duzenle.setText("Düzenle");
        btn_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_duzenleActionPerformed(evt);
            }
        });

        btn_sil.setText("Sil");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_temizle.setText("Temizle");
        btn_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizleActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Bilgilendirme");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_yeni_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_duzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_temizle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_yeni_ekle)
                    .addComponent(btn_duzenle)
                    .addComponent(btn_sil)
                    .addComponent(btn_temizle))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableKitapKontrol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableKitapKontrol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKitapKontrolMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKitapKontrol);

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel22.setText("Kitaplar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 458, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout kitapKontrolLayout = new javax.swing.GroupLayout(kitapKontrol);
        kitapKontrol.setLayout(kitapKontrolLayout);
        kitapKontrolLayout.setHorizontalGroup(
            kitapKontrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kitapKontrolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kitapKontrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kitapKontrolLayout.setVerticalGroup(
            kitapKontrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kitapKontrolLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        anaEkran.addTab("Kitap Kontrol", kitapKontrol);

        jLabel23.setText("Kategori Ekle");

        jLabel24.setText("Kategori Adı:");

        jLabel25.setText("Stant No:");

        jLabel26.setText("Stant Adres:");

        btn_ekle.setText("Ekle");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 51));
        jLabel27.setText("Kategoriyi Seçin!");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_stant_no)
                    .addComponent(txt_stant_adres)
                    .addComponent(txt_kategori_adi))
                .addGap(18, 18, 18)
                .addComponent(btn_ekle)
                .addGap(30, 30, 30)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_kategori_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txt_stant_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txt_stant_adres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jLabel28.setText("Kategori Türleri");

        tableKategoriKontrol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableKategoriKontrol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKategoriKontrolMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableKategoriKontrol);

        btn_silme.setText("Sil");
        btn_silme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silmeActionPerformed(evt);
            }
        });

        btn_duzen.setText("Düzenle");
        btn_duzen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_duzenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_duzen)
                        .addGap(18, 18, 18)
                        .addComponent(btn_silme)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_silme)
                    .addComponent(btn_duzen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        anaEkran.addTab("Kategori Kontrol", jPanel5);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 255));
        jLabel4.setText("Kütüphane Otomasyonu");

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/icon_setting.png"))); // NOI18N
        btnSettings.setPreferredSize(new java.awt.Dimension(100, 100));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/icon_off.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addComponent(anaEkran))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(anaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rnoActionPerformed

    private void txt_yayin_eviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_yayin_eviActionPerformed

    }//GEN-LAST:event_txt_yayin_eviActionPerformed

    private void txt_kitap_adiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kitap_adiActionPerformed

    }//GEN-LAST:event_txt_kitap_adiActionPerformed

    private void tableSorgulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSorgulaMouseClicked

        int row = tableSorgula.getSelectedRow();
        bookId = "" + tableSorgula.getValueAt(row, 0);
        String kitapTur = "" + tableSorgula.getValueAt(row, 1);
        String kitapAdi = "" + tableSorgula.getValueAt(row, 2);
        String kisaAciklama = "" + tableSorgula.getValueAt(row, 3);
        String yazarAdi = "" + tableSorgula.getValueAt(row, 4);
        String yayinevi = "" + tableSorgula.getValueAt(row, 5);
        String kitapDili = "" + tableSorgula.getValueAt(row, 6);
        String rafNo = "" + tableSorgula.getValueAt(row, 7);
        
        txt_kitap_turu.setText(kitapTur);
        txt_kitap_adi.setText(kitapAdi);
        txt_kisa_aciklama.setText(kisaAciklama);
        txt_yazar_adi.setText(yazarAdi);
        txt_yayin_evi.setText(yayinevi);
        txt_kitap_dili.setText(kitapDili);
        txt_raf_no.setText(rafNo);
    }//GEN-LAST:event_tableSorgulaMouseClicked

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed
      String arama = txt_ara.getText().trim();
      kitapSorgula(arama);
    }//GEN-LAST:event_btn_araActionPerformed

    private void btn_yeni_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yeni_ekleActionPerformed
       
        String kitapTur = txt_ktur.getText().trim();
        String kitapAdi = txt_kad.getText().trim();
        String kisaAciklama = txt_aciklama.getText().trim();
        String yazarAdi = txt_yad.getText().trim();
        String yayinevi = txt_yevi.getText().trim();
        String kitapDili = txt_kdil.getText().trim();
        String rafNo = txt_rno.getText().trim();
       
        if (kitapTur.equals("")) {
            txt_ktur.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen kitap türünü giriniz !");
        } else if (kitapAdi.equals("")) {
            txt_kad.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen kitap adını giriniz !");
        } else if (kisaAciklama.equals("")) {
            txt_aciklama.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen kitap açıklamasını giriniz !");
        } else if (yazarAdi.equals("")) {
            txt_yad.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen yazar adını giriniz !");
        } else if (yayinevi.equals("")) {
            txt_yevi.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen yayınevi adını giriniz !");
        } else if (kitapDili.equals("")) {
            txt_kdil.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen kitap dilini giriniz !");
        }else if (rafNo.equals("")) {
            txt_rno.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen raf numarasını giriniz !");
        } else {
            
            try {
                String query = "INSERT INTO `tbl_sonuc` (`bookId`, `kitapTur`, `kitapAdi`, `kisaAciklama`, `yazarAdi`, `yayinevi`, `kitapDili`, `rafNo`) VALUES (NULL, ?,?, ?, ?, ?, ?,? );";
                PreparedStatement pre = db.preBaglan(query);
                pre.setString(1, kitapTur);
                pre.setString(2, kitapAdi);
                pre.setString(3, kisaAciklama);
                pre.setString(4, yazarAdi);
                pre.setString(5, yayinevi);
                pre.setString(6, kitapDili);
                pre.setString(7, rafNo);
           int insertStatu = pre.executeUpdate();
                if (insertStatu > 0) {
                    kitapKontrol();
                    JOptionPane.showMessageDialog(this, "Kitap Eklendi !");
                }
            } catch (Exception e) {
                System.err.println("Kitap Ekleme Hatası : " + e);
            }
            txt_ktur.setText("");
            txt_kad.setText("");
            txt_aciklama.setText("");
            txt_yad.setText("");
            txt_yevi.setText("");
            txt_kdil.setText("");
            txt_rno.setText("");
        }    
    }//GEN-LAST:event_btn_yeni_ekleActionPerformed

    private void txt_yeviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_yeviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_yeviActionPerformed

    private void txt_kadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kadActionPerformed
    private void btn_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_duzenleActionPerformed
       
        String kitapAdi = txt_kad.getText().trim();
        String kitapTur = txt_ktur.getText().trim();
        String kisaAciklama = txt_aciklama.getText().trim();
        String yazarAdi = txt_yad.getText().trim();
        String yayinevi = txt_yevi.getText().trim();
        String kitapDili = txt_kdil.getText().trim();
        String rafNo = txt_rno.getText().trim();
        
        try {
                String query = "UPDATE `tbl_sonuc` SET `kitapTur` = ?, `kitapAdi` = ?, `kisaAciklama` = ?, `yazarAdi` = ?, `yayinevi` = ?, `rafNo` = ? WHERE `tbl_sonuc`.`bookId` = ?;";
                PreparedStatement pre = db.preBaglan(query);
                pre.setString(1, kitapTur);
                pre.setString(2, kitapAdi);
                pre.setString(3, kisaAciklama);
                pre.setString(4, yazarAdi);
                pre.setString(5, yayinevi);
                pre.setString(6, kitapDili);
                pre.setString(7, rafNo);
                pre.setInt(8, Integer.valueOf(bookId));
           int insertStatu = pre.executeUpdate();
                if (insertStatu > 0) {
                    kitapKontrol();
                    JOptionPane.showMessageDialog(this, "Kitap Düzenlendi !");
                }
            } catch (Exception e) {
                System.err.println("Kitap Düzenleme Hatası : " + e);
            }
            txt_ktur.setText("");
            txt_kad.setText("");
            txt_aciklama.setText("");
            txt_yad.setText("");
            txt_yevi.setText("");
            txt_kdil.setText("");
            txt_rno.setText("");
            
    }//GEN-LAST:event_btn_duzenleActionPerformed

    private void tableKitapKontrolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKitapKontrolMouseClicked
        int row = tableKitapKontrol.getSelectedRow();
        bookId = "" + tableKitapKontrol.getValueAt(row, 0);
        String kitapTur = "" + tableKitapKontrol.getValueAt(row, 1);
        String kitapAdi = "" + tableKitapKontrol.getValueAt(row, 2);
        String kisaAciklama = "" + tableKitapKontrol.getValueAt(row, 3);
        String yazarAdi = "" + tableKitapKontrol.getValueAt(row, 4);
        String yayinevi = "" + tableKitapKontrol.getValueAt(row, 5);
        String kitapDili = "" + tableKitapKontrol.getValueAt(row, 6);
        String rafNo = "" + tableKitapKontrol.getValueAt(row, 7);
        
        txt_ktur.setText(kitapTur);
        txt_kad.setText(kitapAdi);
        txt_aciklama.setText(kisaAciklama);
        txt_yad.setText(yazarAdi);
        txt_yevi.setText(yayinevi);
        txt_kdil.setText(kitapDili);
        txt_rno.setText(rafNo);
    }//GEN-LAST:event_tableKitapKontrolMouseClicked

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        try {
                String query = "DELETE FROM `tbl_sonuc` WHERE `tbl_sonuc`.`bookId` = ?";
                PreparedStatement pre = db.preBaglan(query);
                pre.setString(1, bookId);
           int deleteStatu = pre.executeUpdate();
                if (deleteStatu > 0) {
                    bookId="";
                    kitapKontrol();
                    JOptionPane.showMessageDialog(this, "Kitap Silindi !");
                }
            } catch (Exception e) {
                System.err.println("Kitap Silme Hatası : " + e);
            }
            txt_ktur.setText("");
            txt_kad.setText("");
            txt_aciklama.setText("");
            txt_yad.setText("");
            txt_yevi.setText("");
            txt_kdil.setText("");
            txt_rno.setText("");
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizleActionPerformed
            txt_ktur.setText("");
            txt_kad.setText("");
            txt_aciklama.setText("");
            txt_yad.setText("");
            txt_yevi.setText("");
            txt_kdil.setText("");
            txt_rno.setText("");
    }//GEN-LAST:event_btn_temizleActionPerformed

    private void tableKategoriKontrolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKategoriKontrolMouseClicked
        int row = tableKategoriKontrol.getSelectedRow();
        kategoriId = "" + tableKategoriKontrol.getValueAt(row, 0);
        String turAdi = "" + tableKategoriKontrol.getValueAt(row, 1);
        String stantNo = "" + tableKategoriKontrol.getValueAt(row, 2);
        String stantAdres = "" + tableKategoriKontrol.getValueAt(row, 3);

        txt_kategori_adi.setText(turAdi);
        txt_stant_no.setText(stantNo);
        txt_stant_adres.setText(stantAdres);
    }//GEN-LAST:event_tableKategoriKontrolMouseClicked
String kategoriId = "";
    private void btn_duzenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_duzenActionPerformed
        String turAdi = txt_kategori_adi.getText().trim();
        String stantNo = txt_stant_no.getText().trim();
        String stantAdres = txt_stant_adres.getText().trim();
        
        try {
            String query = "UPDATE `kategori` SET `turAdi` = ?, `stantNo` = ?, `stantAdres` = ? WHERE `kategori`.`kategoriId` = ?;";
            PreparedStatement pre = db.preBaglan(query);
            pre.setString(1, turAdi);
            pre.setString(2, stantNo);
            pre.setString(3, stantAdres);
            pre.setInt(4, Integer.valueOf(kategoriId));
            int updateStatu = pre.executeUpdate();
            if (updateStatu > 0) {
                kategoriKontrol();
                jLabel27.setText("Kategori düzenlendi!");
            }
        } catch (Exception e) {
            System.err.println("Kategori Düzenleme Hatası :" +e);
        }
    }//GEN-LAST:event_btn_duzenActionPerformed

    private void btn_silmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silmeActionPerformed
         try {
            String query = "DELETE FROM `kategori` WHERE `kategori`.`kategoriId` = ?";
            PreparedStatement pre = db.preBaglan(query);
            pre.setInt(1, Integer.valueOf(kategoriId));
            int updateStatu = pre.executeUpdate();
            if (updateStatu > 0) {
                kategoriKontrol();
                kategoriId = "";
                jLabel27.setText("Kategori Silindi!");
            }
        } catch (Exception e) {
            System.err.println("Kategori Silme Hatası :  " + e);
        }
        txt_kategori_adi.setText("");
        txt_stant_no.setText("");
        txt_stant_adres.setText("");
    }//GEN-LAST:event_btn_silmeActionPerformed

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
        String turAdi = txt_kategori_adi.getText().trim();
        String stantNo = txt_stant_no.getText().trim();
        String stantAdres = txt_stant_adres.getText().trim();
        if (turAdi.equals("")) {
            txt_kategori_adi.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen kategori adı giriniz !");
        } else if (stantNo.equals("")) {
            txt_stant_no.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen stant numarası giriniz !");
        } else if (stantAdres.equals("")) {
            txt_stant_adres.requestFocus();
            JOptionPane.showMessageDialog(this, "Lütfen stant adresi giriniz !");
        } else {
            try {
                String query = "INSERT INTO `kategori` (`kategoriId`, `turAdi`, `stantNo`, `stantAdres`) VALUES (NULL, ?, ?, ?);";
                PreparedStatement pre = db.preBaglan(query);
                pre.setString(1, turAdi);
                pre.setString(2, stantNo);
                pre.setString(3, stantAdres);
                int InsertStatu = pre.executeUpdate();
                if (InsertStatu > 0) {
                    kategoriKontrol();
                    jLabel27.setText("Kategori Eklendi!");
                }
            } catch (Exception e) {
                System.err.println("Category İnsert Error :  " + e);
            }
            txt_kategori_adi.setText("");
            txt_stant_no.setText("");
            txt_stant_adres.setText("");
        }
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSettingsActionPerformed
String bookId = "";
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashKitapSorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashKitapSorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashKitapSorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashKitapSorgu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashKitapSorgu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane anaEkran;
    private javax.swing.JButton btnOff;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_duzen;
    private javax.swing.JButton btn_duzenle;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_silme;
    private javax.swing.JButton btn_temizle;
    private javax.swing.JButton btn_yeni_ekle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel kitapKontrol;
    private javax.swing.JPanel kitapSorgula;
    private javax.swing.JTable tableKategoriKontrol;
    private javax.swing.JTable tableKitapKontrol;
    private javax.swing.JTable tableSorgula;
    private javax.swing.JTextField txt_aciklama;
    private javax.swing.JTextField txt_ara;
    private javax.swing.JTextField txt_kad;
    private javax.swing.JTextField txt_kategori_adi;
    private javax.swing.JTextField txt_kdil;
    private javax.swing.JTextField txt_kisa_aciklama;
    private javax.swing.JTextField txt_kitap_adi;
    private javax.swing.JTextField txt_kitap_dili;
    private javax.swing.JTextField txt_kitap_turu;
    private javax.swing.JTextField txt_ktur;
    private javax.swing.JTextField txt_raf_no;
    private javax.swing.JTextField txt_rno;
    private javax.swing.JTextField txt_stant_adres;
    private javax.swing.JTextField txt_stant_no;
    private javax.swing.JTextField txt_yad;
    private javax.swing.JTextField txt_yayin_evi;
    private javax.swing.JTextField txt_yazar_adi;
    private javax.swing.JTextField txt_yevi;
    // End of variables declaration//GEN-END:variables

}
