package Models;

/**
 *
 * @author César Eduardo
 */
public class Producto 
{
    int ID_Producto;
    String Nombre_Producto;
    float Costo;
    float CostoVenta;

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public float getCostoVenta() {
        return CostoVenta;
    }

    public void setCostoVenta(float CostoVenta) {
        this.CostoVenta = CostoVenta;
    }
}
