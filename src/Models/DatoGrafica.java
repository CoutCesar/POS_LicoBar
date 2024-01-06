package Models;

import java.time.LocalDate;

public class DatoGrafica 
{
    String Fecha;
    float Cantidad;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public DatoGrafica(String Fecha, float Cantidad) {
        this.Fecha = Fecha;
        this.Cantidad = Cantidad;
    }
}
