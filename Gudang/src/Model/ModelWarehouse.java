/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author user
 */
public interface ModelWarehouse {
    int getBanyakData(); //mengambil banyak data dari db
    String[][] readData(); //mengambil data dari db dengan return array string
    void insertData(String nama, int jumlah, String jenis, int harga); //memasukkan data ke db
    void updateData(int id, String nama, int jumlah, String jenis, int harga); //untuk update data
    void deleteData (int id); //untuk menghapus data
}
