package DataAccess.DTO;

public class AdministradorDTO {
    private Integer nAdmin;
    private String barcode;
    private Integer tipo;
    private String estado;
    private String FechaCrea;
    private String FechaModifica;

    public AdministradorDTO() {
    }

    public AdministradorDTO(Integer tipo) {
        this.tipo = tipo;
    }

    public AdministradorDTO(String barcode, Integer tipo) {
        this.barcode = barcode;
        this.tipo = tipo;
    }

    public AdministradorDTO(Integer nAdmin, String barcode, Integer tipo, String estado, String fechaCrea,
            String fechaModifica) {
        this.nAdmin = nAdmin;
        this.barcode = barcode;
        this.tipo = tipo;
        this.estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getnAdmin() {
        return nAdmin;
    }

    public void setnAdmin(Integer nAdmin) {
        this.nAdmin = nAdmin;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
}
