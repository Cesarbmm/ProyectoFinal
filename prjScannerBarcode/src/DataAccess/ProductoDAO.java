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

import DataAccess.DTO.ProductoDTO;
import Framework.prjException;

public class ProductoDAO extends SQLiteDataHelper implements IDAO<ProductoDTO> {

    public Double readPrecioBy(String barcode) throws Exception {
        ProductoDTO productoDTO = new ProductoDTO();
        String query = "SELECT Precio FROM Producto WHERE Estado = 'A' AND BarCode = " + barcode;
        Double precio;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                productoDTO = new ProductoDTO(rs.getDouble(1));
            }
            precio = productoDTO.getPrecio();
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readPrecioBy()");
        }
        return precio;
        // retorna el precio del producto en double
    }

    public String readNombreBy(String barcode) throws Exception {
        ProductoDTO productoDTO = new ProductoDTO();
        String query = "SELECT Nombre FROM Producto WHERE Estado = 'A' AND BarCode = " + barcode;
        String nombre;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                productoDTO = new ProductoDTO(rs.getString(1));
            }
            nombre = productoDTO.getNombre();
        } catch (Exception e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readPrecioBy()");
        }
        return nombre;
        // retorna el nombre del producto escaneado en string
    }

    @Override
    public boolean create(ProductoDTO entity) throws Exception {
        String query = " INSERT INTO Producto (Nombre, BarCode, Precio, id_Seccion, id_Categoria) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getBarcode());
            pstmt.setDouble(3, entity.getPrecio());
            pstmt.setInt(4, entity.getIdSeccion());
            pstmt.setInt(5, entity.getIdCategoria());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ProductoDTO> readAll() throws Exception {
        List<ProductoDTO> lst = new ArrayList<>();
        String query = "SELECT nProducto "
                + ", Nombre         "
                + ", BarCode        "
                + ", Precio         "
                + ", id_Seccion     "
                + ", id_Categoria   "
                + ", Estado         "
                + ", FechaCrea      "
                + ", FechaModifica  "
                + "FROM Producto    "
                + "WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ProductoDTO productoDTO = new ProductoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                lst.add(productoDTO);
            }

        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ProductoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Producto SET Nombre = ?, Precio = ?, FechaModifica = ? WHERE BarCode = ?";

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setDouble(2, entity.getPrecio());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setString(4, entity.getBarcode());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(String barcode) throws Exception {
        String query = "UPDATE Producto SET Estado = ? WHERE BarCode = ? ";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setString(2, barcode);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public ProductoDTO readBy(String barcode) throws Exception {
        ProductoDTO productoDTO = new ProductoDTO();
        String query = "SELECT nProducto "
                + ", Nombre         "
                + ", BarCode        "
                + ", Precio         "
                + ", id_Seccion     "
                + ", id_Categoria   "
                + ", Estado         "
                + ", FechaCrea      "
                + ", FechaModifica  "
                + "FROM Producto WHERE Estado = 'A' AND BarCode = " + barcode;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                productoDTO = new ProductoDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            throw new prjException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return productoDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg "
                + " FROM    Producto         "
                + " WHERE   Estado ='A'      ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                return rs.getInt(1); // TotalReg
            }
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

}
