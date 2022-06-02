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
    private Integer dataTerpilih;
    private String namaBarangTerpilih;
    
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
               namaBarangTerpilih = gudangView.tabel.getValueAt(baris, 0).toString();          
               gudangView.setNbarang(gudangView.tabel.getValueAt(baris, 0).toString());
               gudangView.setJbarang(gudangView.tabel.getValueAt(baris, 1).toString());
               gudangView.setJenisbarang(gudangView.tabel.getValueAt(baris, 2).toString());
               gudangView.setHbarang(gudangView.tabel.getValueAt(baris, 3).toString());
   }
        });

        gudangView.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                if(gudangView.getNamaBarang().isBlank()){ 
                    throw new IllegalArgumentException("Nama Barang belum terisi");
                }
                if(gudangView.getJumlahBarang().isBlank()){
                     throw new IllegalArgumentException("Jumlah Barang belum terisi");
                }
                if(gudangView.getJenisBarang().isBlank()){
                    
                     throw new IllegalArgumentException("Jenis Barang belum terisi");
                }
                if(gudangView.getHargaBarang().isBlank()){
                     throw new IllegalArgumentException("Harga Barang belum terisi");
                }
               
                
                String nama = gudangView.getNamaBarang();
                int jumlah = Integer.parseInt(gudangView.getJumlahBarang());
                String jenis = gudangView.getJenisBarang();
                int harga = Integer.parseInt(gudangView.getHargaBarang());
                modelWarehouse.insertData(nama, jumlah, jenis, harga);
                String dataWarehouse[][] = modelWarehouse.readData();
                gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
                gudangView.setNbarang("");
                gudangView.setJbarang("");
                gudangView.setJenisbarang("");
                gudangView.setHbarang("");
            }catch(Exception error){
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        }
            
        });
        
        gudangView.btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                if(dataTerpilih == null){
                    throw new IllegalArgumentException("Anda belum memilih barang yang ingin di-update");
                }
                int id = dataTerpilih;

                if(gudangView.getNamaBarang().isBlank()){ 
                    throw new IllegalArgumentException("Nama Barang belum terisi");
                }
                if(gudangView.getJumlahBarang().isBlank()){
                     throw new IllegalArgumentException("Jumlah Barang belum terisi");
                }
                if(gudangView.getJenisBarang().isBlank()){
                    
                     throw new IllegalArgumentException("Jenis Barang belum terisi");
                }
                if(gudangView.getHargaBarang().isBlank()){
                     throw new IllegalArgumentException("Harga Barang belum terisi");
                }
                String nama = gudangView.getNamaBarang();
                int jumlah = Integer.parseInt(gudangView.getJumlahBarang());
                String jenis = gudangView.getJenisBarang();
                int harga = Integer.parseInt(gudangView.getHargaBarang());
                modelWarehouse.updateData(id, nama, jumlah, jenis, harga);
                String dataWarehouse[][] = modelWarehouse.readData();
                gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
                dataTerpilih = null;
                gudangView.setNbarang("");
                gudangView.setJbarang("");
                gudangView.setJenisbarang("");
                gudangView.setHbarang("");
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, error.getMessage());
                }
                
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
               try{
                if(dataTerpilih == null){
                    throw new IllegalArgumentException("Anda belum memilih barang yang ingin dihapus");
                }
                int id = dataTerpilih;
                
                String namaBarang = namaBarangTerpilih;
                int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus barang " + namaBarang + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if(input == 0){
                    modelWarehouse.deleteData(id);
                    String dataWarehouse[][] = modelWarehouse.readData();
                    gudangView.tabel.setModel((new JTable(dataWarehouse, gudangView.namaKolom)).getModel());
                    gudangView.tabel.removeColumn(gudangView.tabel.getColumnModel().getColumn(6));
                    dataTerpilih = null;
                    gudangView.setNbarang("");
                    gudangView.setJbarang("");
                    gudangView.setJenisbarang("");
                    gudangView.setHbarang("");
                }else{
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
            }
        });
    }
    
    
}
