/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.ModelWarehouseImpls;
import View.ViewWarehouse;
/**
 *
 * @author user
 */
public class ControllerWarehouse {
    ModelWarehouseImpls modelWarehouse;
    ViewWarehouse gudangView;
    private int dataTerpilih;
    private String namaBarangTerpilih;
    private String[] dataClicked = new String[7];
    public ControllerWarehouse(ModelWarehouseImpls modelWarehouse, ViewWarehouse gudangView) {
        this.modelWarehouse = modelWarehouse;
        this.gudangView = gudangView;
        
        if (modelWarehouse.getBanyakData()!=0) {
            String dataWarehouse[][] = modelWarehouse.readData();
            gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
            gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        gudangView.tabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mousePressed(e);
               String data;
               int baris = gudangView.tabel.getSelectedRow();
               data = gudangView.tabel.getModel().getValueAt(gudangView.tabel.getSelectedRow(),6).toString();
               dataTerpilih = Integer.parseInt(data);
               dataClicked[6] = gudangView.tabel.getModel().getValueAt(gudangView.tabel.getSelectedRow(),6).toString();
               dataClicked[0] = gudangView.tabel.getValueAt(baris, 0).toString();
               dataClicked[1] = gudangView.tabel.getValueAt(baris, 1).toString();
               dataClicked[2] = gudangView.tabel.getValueAt(baris, 2).toString();
               dataClicked[3] = gudangView.tabel.getValueAt(baris, 3).toString();
               dataClicked[4] = gudangView.tabel.getValueAt(baris, 4).toString();
               dataClicked[5] = gudangView.tabel.getValueAt(baris, 5).toString();
               namaBarangTerpilih = gudangView.tabel.getValueAt(baris, 0).toString();
               gudangView.setNbarang(dataClicked[0]);
               gudangView.setJbarang(dataClicked[1]);
               gudangView.setJenisbarang(dataClicked[2]);
               gudangView.setHbarang(dataClicked[3]);
   }
        });

        gudangView.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String nama = gudangView.getNamaBarang();
                int jumlah = Integer.parseInt(gudangView.getJumlahBarang());
                String jenis = gudangView.getJenisBarang();
                int harga = Integer.parseInt(gudangView.getHargaBarang());
                modelWarehouse.insertData(nama, jumlah, jenis, harga);
                String dataWarehouse[][] = modelWarehouse.readData();
                gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
            }
        });
        
        gudangView.btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){

                int id = dataTerpilih;


                String nama = gudangView.getNamaBarang();
                int jumlah = Integer.parseInt(gudangView.getJumlahBarang());
                String jenis = gudangView.getJenisBarang();
                int harga = Integer.parseInt(gudangView.getHargaBarang());
                modelWarehouse.updateData(id, nama, jumlah, jenis, harga);

                String dataWarehouse[][] = modelWarehouse.readData();
                gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));

            }
        });
        
        gudangView.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                gudangView.setNbarang("");
                gudangView.setJbarang("");
                gudangView.setJenisbarang("");
                gudangView.setHbarang("");
            }
        });
        
        gudangView.btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               
                int id = dataTerpilih;
                String namaBarang = namaBarangTerpilih;
                int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus barang " + namaBarang + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if(input == 0){
                    modelWarehouse.deleteData(id);
                    String dataWarehouse[][] = modelWarehouse.readData();
                    gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                    gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
                   
              
            }
        });
    }
    
    
}
