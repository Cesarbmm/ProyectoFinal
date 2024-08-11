package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.AdministradorTipoDTO;
import Framework.prjException;

public class AdministradorTipoDAO extends SQLiteDataHelper implements IDAOint<AdministradorTipoDTO> {

    @Override
    public boolean create(AdministradorTipoDTO entity) throws Exception {
        String query = "INSERT INTO AdministradorTipo (nombre) VALUES(?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new prjException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<AdministradorTipoDTO> readAll() throws Exception {
        List<AdministradorTipoDTO> lst = new ArrayList<>();
        String query = "SELECT id     "
                + ",nombre       "
                + ",Estado       "
                + ",FechaCrea    "
                + ",FechaModifica"
                + "FROM AdministradorTipo WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                AdministradorTipoDTO seccionDTO = new AdministradorTipoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                lst.add(seccionDTO);
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(AdministradorTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE AdministradorTipo SET nombre = ? , FechaModifica = ? WHERE id = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getId());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE AdministradorTipo SET Estado = ? WHERE id = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public AdministradorTipoDTO readBy(Integer id) throws Exception {
        AdministradorTipoDTO administradorTipoDTO = new AdministradorTipoDTO();
        String query = "SELECT id       "
                + ",nombre         "
                + ",Estado         "
                + ",FechaCrea      "
                + ",FechaModifica  "
                + "FROM AdministradorTipo WHERE Estado 'A' AND id = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                administradorTipoDTO = new AdministradorTipoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "delete()");
        }
        return administradorTipoDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*)          "
                + " FROM    AdministradorTipo"
                + " WHERE   Estado ='A'      ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
