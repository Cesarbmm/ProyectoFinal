package DataAccess.DTO;

public class SeccionDTO {

    private Integer id;
    private String nombre;
    private Integer idCategoria;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    public SeccionDTO() {
    }

    public SeccionDTO(Integer id, String nombre, Integer idCategoria, String estado, String fechaCrea,
            String fechaModifica) {
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

}
