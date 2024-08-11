package DataAccess.DTO;

public class ProductoDTO {
    private Integer nProducto;
    private String Nombre;
    private String Barcode;
    private Double Precio;
    private Integer idSeccion;
    private Integer idCategoria;
    private String Estado;
    private String FechaCrea;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, Double precio, String barcode) {
        Nombre = nombre;
        Barcode = barcode;
        Precio = precio;
    }

    public ProductoDTO(String nombre) {
        Nombre = nombre;
    }

    public ProductoDTO(Double precio) {
        Precio = precio;
    }

    public ProductoDTO(String nombre, String barcode, Double precio, Integer idSeccion, Integer idCategoria) {
        Nombre = nombre;
        Barcode = barcode;
        Precio = precio;
        this.idSeccion = idSeccion;
        this.idCategoria = idCategoria;
    }

    public ProductoDTO(Integer nProducto, String nombre, String barcode, Double precio, Integer idSeccion,
            Integer idCategoria, String estado, String fechaCrea, String fechaModifica) {
        this.nProducto = nProducto;
        Nombre = nombre;
        Barcode = barcode;
        Precio = precio;
        this.idSeccion = idSeccion;
        this.idCategoria = idCategoria;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    private String FechaModifica;

    public Integer getnProducto() {
        return nProducto;
    }

    public void setnProducto(Integer nProducto) {
        this.nProducto = nProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
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

    @Override
    public String toString() {
        return getClass().getName() +
                "\n nProducto:  " + getnProducto() +
                "\n Nombre:     " + getNombre() +
                "\n Barcode:    " + getBarcode() +
                "\n Precio:     " + getPrecio() +
                "\n idSeccion:  " + getIdSeccion() +
                "\n idCategoria:" + getIdCategoria() +
                "\n Estado:     " + getEstado() +
                "\n Creado:     " + getFechaCrea() +
                "\n Modificado: " + getFechaModifica() + "\n";
    }

}
