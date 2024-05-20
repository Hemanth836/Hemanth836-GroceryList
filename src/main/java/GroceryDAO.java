import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroceryDAO {

    public List<String> getAllGroceries(){
        Connection connection = ConnectionUtil.getConnection();
        List<String> groceries = new ArrayList<>();
        try {
            String sql = "SELECT grocery_name FROM Grocery";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                groceries.add(rs.getString("grocery_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return groceries;
    }

    public void addGrocery(String groceryName){
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO Grocery (grocery_name) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, groceryName);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
