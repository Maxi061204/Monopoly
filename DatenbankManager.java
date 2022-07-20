
/**
 * Klasse DatenbankManager.
 *  
 * @author 
 */

import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.sql.ResultSet;
public class DatenbankManager {
    //Ne
    MySQL mysql;
    public DatenbankManager() {
        mysql = new MySQL();
    }

    public void addEreignisKarte(int ID, String KartenText, int aktionsID) {
        try {
            PreparedStatement statement = mysql.getConnection().prepareStatement("INSERT INTO Ereigniskarten(KartenID, KartenText, AktionID) VALUES (?, ?, ?)");

            statement.setInt(1, ID);
            statement.setString(2, KartenText);
            statement.setInt(3, aktionsID);

            statement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public String getKartenText(String tabelle, int id) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM " + tabelle + " WHERE KartenID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getString(2);
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return null; 
    }

    //noo
    public Integer getKartenAktionsID(String tabelle, int id) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM " + tabelle +" WHERE KartenID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(3);
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return -1; 
    }

    //Noo
    public String getGrundstückString(int id, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM Grundstücke WHERE GrundstückID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getString(column);
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return null; 
    }

    public Integer getGrundstückInt(int id, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM Grundstücke WHERE GrundstückID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(column);
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return -1; 
    }

    public Integer getGrundstückID(String grundstückName, String column) {
        try 
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM Gundstücke WHERE GrundstückName=?");
            ps.setString(1, grundstückName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getInt(column);
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return -1;
    }

    public void addGrundstückInt(int id, int zahl, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE Grundstücke SET " + column + "=? WHERE GrundstückID=?");
            ps.setInt(1, zahl + getGrundstückInt(id, column));
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

    }

    public void removeGrundstückInt(int id, int zahl, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE Grundstücke SET " + column + "=? WHERE GrundstückID=?");
            ps.setInt(1,getGrundstückInt(id, column) - zahl);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

    }

    public void setGrundstückInt(int id, int zahl, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE Grundstücke SET " + column + "=? WHERE GrundstückID=?");
            ps.setInt(1, zahl);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

    }

    public void setGrundstückString(int id, String text, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE Grundstücke SET " + column + "=? WHERE GrundstückID=?");
            ps.setString(1, text);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

    }

    public void setGrundstückBoolean(int id, Boolean bool, String column) {
        try
        {
            PreparedStatement ps = mysql.getConnection().prepareStatement("UPDATE Grundstücke SET " + column + "=? WHERE GrundstückID=?");
            ps.setBoolean(1, bool);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }

    }

}
