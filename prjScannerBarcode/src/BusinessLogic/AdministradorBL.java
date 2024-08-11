package BusinessLogic;

import java.util.List;

import DataAccess.AdministradorDAO;
import DataAccess.DTO.AdministradorDTO;

public class AdministradorBL {
    private AdministradorDTO administrador;
    private AdministradorDAO administradorDAO = new AdministradorDAO();

    public boolean tipoAdmin(String barcode) throws Exception {
        int tipo = administradorDAO.readTipo(barcode);
        if (tipo == 1)
            return true;
        else
            return false;
    }

    public boolean add(AdministradorDTO administradorDTO) throws Exception {
        return administradorDAO.create(administradorDTO);
    }

    public List<AdministradorDTO> getAll() throws Exception {
        List<AdministradorDTO> lst = administradorDAO.readAll();
        return lst;
    }

    public boolean update(AdministradorDTO administradorDTO) throws Exception {
        return administradorDAO.update(administradorDTO);
    }

    public boolean delete(String barcode) throws Exception {
        return administradorDAO.delete(barcode);
    }

    public AdministradorDTO getBy(String barcode) throws Exception {
        administrador = administradorDAO.readBy(barcode);
        return administrador;
    }

    public Integer getRowCount() throws Exception {
        return administradorDAO.getMaxRow();
    }
}
