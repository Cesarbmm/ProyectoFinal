package DataAccess.DTO;

public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private String estado;
    private String FechaCrea;
    private String FechaModifica;

    public CategoriaDTO(Integer id, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public CategoriaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
