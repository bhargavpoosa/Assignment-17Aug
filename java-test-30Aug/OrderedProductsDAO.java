package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderedProductsDAO {
    private static String url = "jdbc:mysql://localhost:3306/Gainsight";
    public void displayOrderedProductById(int productId){
        try(Connection con = DriverManager.getConnection(url, "root", "Bh@rgav2811");
            PreparedStatement pt = con.prepareStatement("select P.prod_id, prod_name,prod_desc,prod_price,prod_quantity,O.order_date from Product P, ordered_products OP, orders O where P.prod_id = OP.prod_id and OP.order_id = O.order_id and P.prod_id = ?")){
            pt.setInt(1,productId);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4)+ " " +rs.getInt(5) + " " + rs.getString(6));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void displayOrderedProductsByOrderDate(String orderDate){
        try(Connection con = DriverManager.getConnection(url, "root", "Bh@rgav2811");
            PreparedStatement pt = con.prepareStatement("select P.prod_id, prod_name,prod_desc,prod_price,prod_quantity,O.order_date from Product P, ordered_products OP, orders O where P.prod_id = OP.prod_id and OP.order_id = O.order_id and O.order_date = ?")){
            pt.setString(1,orderDate);
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDouble(4)+ " " +rs.getInt(5) + " " + rs.getString(6));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
