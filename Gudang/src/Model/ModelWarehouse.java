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
    int getBanyakData();
    String[][] readData();
    void insertData(String nama, int jumlah, String jenis, int harga);
    void updateData(int id, String nama, int jumlah, String jenis, int harga);
    void deleteData (int id);
}
