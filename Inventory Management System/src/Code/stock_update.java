/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kavishika
 */
public class stock_update {
    public void stock_update(){
        try {
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM cart");

            while (rs.next()) {

                String pid=rs.getString(2);
                int quantitiy=Integer.parseInt(rs.getString(4));
                try {
                    Statement search_st = db.mycon().createStatement();
                    search_st.executeQuery("SELECT quantitiy FROM inventory  WHERE pid='"+ pid + "'");
                    
                    int search_quantity=Integer.parseInt(rs.getString(1));
                    
                    quantitiy=quantitiy-search_quantity;
                    
                    Statement update_st = db.mycon().createStatement();
                    update_st.executeUpdate("UPDATE inventory SET quantity='"+quantitiy+"' WHERE pid='"+ pid + "'");
                    
                    Statement del_st = db.mycon().createStatement();
                    del_st.executeUpdate("DELETE FROM cart WHERE INID='" + pid + "'");
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
