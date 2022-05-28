/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import View.ViewWarehouse;
import Controller.ControllerWarehouse;
import Model.ModelWarehouseImpls;
import java.io.IOException;
/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       
        ViewWarehouse view = new ViewWarehouse();
        ModelWarehouseImpls modelWarehouse = new ModelWarehouseImpls();
        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(modelWarehouse, view);
        
    }
    
}
