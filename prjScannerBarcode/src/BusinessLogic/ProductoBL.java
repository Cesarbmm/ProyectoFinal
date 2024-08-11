package BusinessLogic;

import java.util.List;

import DataAccess.ProductoDAO;
import DataAccess.DTO.ProductoDTO;

public class ProductoBL {
    private ProductoDTO producto;
    private ProductoDAO productoDAO = new ProductoDAO();

    public ProductoBL() {
    }

    public String getPrecioBy(String barcode) throws Exception {
        Double precio = productoDAO.readPrecioBy(barcode);
        return "$" + precio.toString(); // retorna el precio en tipo string y formato $x.xx
    }

    public String getNombreBy(String barcode) throws Exception {
        String nombre = productoDAO.readNombreBy(barcode);
        return nombre;
    }

    public boolean add(ProductoDTO productoDTO) throws Exception {
        return productoDAO.create(productoDTO);
    }

    public List<ProductoDTO> getAll() throws Exception {
        List<ProductoDTO> lst = productoDAO.readAll();
        return lst;
    }

    public boolean update(ProductoDTO productoDTO) throws Exception {
        return productoDAO.update(productoDTO);
    }

    public boolean delete(String barcode) throws Exception {
        return productoDAO.delete(barcode);
    }

    public ProductoDTO getBy(String barcode) throws Exception {
        producto = productoDAO.readBy(barcode);
        return producto;
    }

    public Integer getRowCount() throws Exception {
        return productoDAO.getMaxRow();
    }

}
