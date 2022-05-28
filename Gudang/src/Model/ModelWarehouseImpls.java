/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 *
 * @author user
 */
public class ModelWarehouseImpls implements ModelWarehouse{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/warehouse_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    public ModelWarehouseImpls() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    @Override
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM gudang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    @Override
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][7]; 
            
            String query = "SELECT * FROM gudang"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][6] = String.valueOf(resultSet.getInt("id"));
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = String.valueOf(resultSet.getInt("jumlah"));                
                data[jmlData][2] = resultSet.getString("jenis");
                data[jmlData][3] = String.valueOf(resultSet.getInt("harga_satuan"));
                data[jmlData][4] = resultSet.getString("tanggal_ditambahkan");
                data[jmlData][5] = resultSet.getString("terakhir_update");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    @Override
    public void insertData(String nama, int jumlah, String jenis, int harga){
        int jmlData=0;
        Date dateNow = new Date();
        try {
           
            String query = "INSERT INTO gudang(nama,jumlah,jenis,harga_satuan,tanggal_ditambahkan, terakhir_update)"
                    + " VALUES('"+nama+"','"+jumlah+"','"+jenis+"','"+harga+"','"+formatter.format(dateNow)+"','"+formatter.format(dateNow)+"')";
           
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    @Override
    public void updateData(int id, String nama, int jumlah, String jenis, int harga){
        int jmlData=0;
        Date dateNow = new Date();
         try {
           String query = "SELECT * FROM gudang WHERE id='" + id +"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE gudang SET nama='" + nama + "', jumlah='" + jumlah +  "', jenis='"+ jenis +"', harga_satuan='"+ harga+"', terakhir_update='"+formatter.format(dateNow)+"' WHERE id='" + id+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    @Override
    public void deleteData (int id) {
        try{
            String query = "DELETE FROM gudang WHERE id = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
