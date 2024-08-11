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

import DataAccess.DTO.CategoriaDTO;
import Framework.prjException;

public class CategoriaDAO extends SQLiteDataHelper implements IDAOint<CategoriaDTO> {

    @Override
    public boolean create(CategoriaDTO entity) throws Exception {
        String query = "INSERT INTO Categoria (nombre) VALUES(?)";
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
    public List<CategoriaDTO> readAll() throws Exception {
        List<CategoriaDTO> lst = new ArrayList<>();
        String query = "SELECT id     "
                + ",nombre       "
                + ",Estado       "
                + ",FechaCrea    "
                + ",FechaModifica"
                + "FROM Categoria WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoriaDTO seccionDTO = new CategoriaDTO(rs.getInt(1),
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
    public boolean update(CategoriaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Categoria SET nombre = ? , FechaModifica = ? WHERE id = ?";
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
        String query = "UPDATE Categoria SET Estado = ? WHERE id = ?";
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
    public CategoriaDTO readBy(Integer id) throws Exception {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        String query = "SELECT id       "
                + ",nombre         "
                + ",Estado         "
                + ",FechaCrea      "
                + ",FechaModifica  "
                + "FROM Categoria WHERE Estado 'A' AND id = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                categoriaDTO = new CategoriaDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "delete()");
        }
        return categoriaDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*)          "
                + " FROM    Categoria          "
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
