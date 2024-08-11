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

import DataAccess.DTO.SeccionDTO;
import Framework.prjException;

public class SeccionDAO extends SQLiteDataHelper implements IDAOint<SeccionDTO> {

    @Override
    public boolean create(SeccionDTO entity) throws Exception {
        String query = "INSERT INTO Seccion (nombre, id_categoria) VALUES(?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new prjException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<SeccionDTO> readAll() throws Exception {
        List<SeccionDTO> lst = new ArrayList<>();
        String query = "SELECT id     "
                + ",nombre       "
                + ",id_categoria "
                + ",Estado       "
                + ",FechaCrea    "
                + ",FechaModifica"
                + "FROM Seccion WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SeccionDTO seccionDTO = new SeccionDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                lst.add(seccionDTO);
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(SeccionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Seccion SET nombre = ? , FechaModifica = ? WHERE id = ?";
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
        String query = "UPDATE Seccion SET estado = ? WHERE id = ?";
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
    public SeccionDTO readBy(Integer id) throws Exception {
        SeccionDTO seccionDTO = new SeccionDTO();
        String query = "SELECT id       "
                + ",nombre         "
                + ",id_catalogo    "
                + ",Estado         "
                + ",FechaCrea      "
                + ",FechaModifica  "
                + "FROM Seccion WHERE Estado 'A' AND id = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                seccionDTO = new SeccionDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "delete()");
        }
        return seccionDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*)          "
                + " FROM    Seccion          "
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
