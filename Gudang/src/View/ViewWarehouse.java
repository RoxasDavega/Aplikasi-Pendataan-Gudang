package View;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewWarehouse extends JFrame {

    private JPanel contentPane;

    private JTextField Nbarang;
    private JTextField Jbarang;
    private JTextField Jenisbarang;
    private JTextField Hbarang;
    public JTable tabel;

    // tambah
    ImageIcon img2 = new ImageIcon(ImageIO.read(new File("./asset/image-removebg-preview.png")));
    public JButton btnTambah = new JButton(img2);

    // Delete
    ImageIcon img3 = new ImageIcon(ImageIO.read(new File("./asset/del.png")));
    public JButton btnDelete = new JButton(img3);

    // Update
    ImageIcon img4 = new ImageIcon(ImageIO.read(new File("./asset/up.png")));
    public JButton btnUpdate = new JButton(img4);

    // Clear
    ImageIcon img5 = new ImageIcon(ImageIO.read(new File("./asset/clear.png")));
    public JButton btnClear = new JButton(img5);

    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama Barang", "Jumlah Barang", "Jenis Barang", "Harga Per-satuan",
            "Tanggal Ditambahkan", "Tanggal Diupdate", ""};

    public ViewWarehouse() throws IOException {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm)
        {
            public boolean isCellEditable(int row, int column)
            {
              return false;//This causes all cells to be not editable
            }
  
        };
        scrollPane = new JScrollPane(tabel);
        tabel.removeColumn(tabel.getColumnModel().getColumn(6));
        
        tabel.setFocusable(false);
        tabel.setRowSelectionAllowed(true);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1149, 598);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel bg = new JPanel();
        bg.setBounds(0, 0, 1135, 561);
        contentPane.add(bg);
        bg.setLayout(null);
        ImageIcon img = new ImageIcon(ImageIO.read(new File("./asset/gud.png")));
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(161, 166, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);

        scrollPane.setBounds(227, 122, 733, 439);
        bg.add(scrollPane);

        JLabel labelnamabarang = new JLabel("Nama Barang");
        labelnamabarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelnamabarang.setForeground(Color.GRAY);
        labelnamabarang.setBounds(970, 134, 85, 17);
        bg.add(labelnamabarang);

        Nbarang = new JTextField();
        Nbarang.setBounds(970, 161, 143, 25);
        bg.add(Nbarang);
        Nbarang.setColumns(10);

        JLabel labeljumlahbarang = new JLabel("Jumlah Barang");
        labeljumlahbarang.setForeground(Color.GRAY);
        labeljumlahbarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labeljumlahbarang.setBounds(970, 196, 94, 17);
        bg.add(labeljumlahbarang);

        Jbarang = new JTextField();
        Jbarang.setColumns(10);
        Jbarang.setBounds(970, 223, 143, 25);
        bg.add(Jbarang);

        JLabel labeljenisbarang = new JLabel("Jenis Barang");
        labeljenisbarang.setForeground(Color.GRAY);
        labeljenisbarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labeljenisbarang.setBounds(970, 258, 80, 17);
        bg.add(labeljenisbarang);

        Jenisbarang = new JTextField();
        Jenisbarang.setColumns(10);
        Jenisbarang.setBounds(970, 285, 143, 25);
        bg.add(Jenisbarang);

        JLabel labelharga = new JLabel("Harga Barang Per-Satuan");
        labelharga.setForeground(Color.GRAY);
        labelharga.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelharga.setBounds(970, 320, 159, 17);
        bg.add(labelharga);

        Hbarang = new JTextField();
        Hbarang.setColumns(10);
        Hbarang.setBounds(970, 347, 143, 25);
        bg.add(Hbarang);

        // Button Tambah
        btnTambah.setBounds(970, 394, 36, 32);
        bg.add(btnTambah);

        JLabel lblNewLabel_3 = new JLabel("Tambah");
        lblNewLabel_3.setBounds(970, 425, 45, 13);
        bg.add(lblNewLabel_3);

        // button delete

        btnDelete.setBounds(1049, 394, 36, 32);
        bg.add(btnDelete);

        JLabel lblNewLabel_3_1 = new JLabel("Hapus");
        lblNewLabel_3_1.setBounds(1049, 425, 45, 13);
        bg.add(lblNewLabel_3_1);

        // Button Update
        btnUpdate.setBounds(970, 467, 36, 32);
        bg.add(btnUpdate);

        JLabel lblNewLabel_3_2 = new JLabel("Update");
        lblNewLabel_3_2.setBounds(970, 498, 45, 13);
        bg.add(lblNewLabel_3_2);

        // Button Clear
        btnClear.setBounds(1049, 467, 36, 32);
        bg.add(btnClear);

        JLabel lblNewLabel_3_2_1 = new JLabel("Clear");
        lblNewLabel_3_2_1.setBounds(1049, 498, 45, 13);
        bg.add(lblNewLabel_3_2_1);

        // Panel
        JPanel side = new JPanel();
        side.setBackground(new Color(54, 33, 89));
        side.setBounds(0, 0, 227, 561);
        bg.add(side);
        side.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(img);
        lblNewLabel.setBounds(28, 168, 161, 166);
        side.add(lblNewLabel);

        JLabel sidelabel1 = new JLabel("APLIKASI PENDATAAN");
        sidelabel1.setFont(new Font("Tahoma", Font.BOLD, 18));
        sidelabel1.setForeground(Color.LIGHT_GRAY);
        sidelabel1.setBounds(10, 64, 211, 22);
        side.add(sidelabel1);

        JLabel sidelabel2 = new JLabel("GUDANG\r\n");
        sidelabel2.setForeground(Color.LIGHT_GRAY);
        sidelabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
        sidelabel2.setBounds(56, 96, 82, 22);
        side.add(sidelabel2);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(122, 72, 221));
        panel.setBounds(227, 48, 908, 76);
        bg.add(panel);
        panel.setLayout(null);

        JLabel datagudang = new JLabel("DATA GUDANG");
        datagudang.setBounds(350, 25, 174, 28);
        datagudang.setForeground(Color.WHITE);
        datagudang.setFont(new Font("Tahoma", Font.BOLD, 23));
        panel.add(datagudang);

        setVisible(true);
    }

    public String getNamaBarang() {
        return Nbarang.getText();
    }

    public String getJumlahBarang() {
        return Jbarang.getText();
    }

    public String getJenisBarang() {
        return Jenisbarang.getText();
    }

    public String getHargaBarang() {
        return Hbarang.getText();
    }

    public void setNbarang(String string) {
        this.Nbarang.setText(string);
    }

    public void setJbarang(String string) {
        this.Jbarang.setText(string);
    }

    public void setJenisbarang(String string) {
        this.Jenisbarang.setText(string);
    }

    public void setHbarang(String string) {
        this.Hbarang.setText(string);
    }

   
}
