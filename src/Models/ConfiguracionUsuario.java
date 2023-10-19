package Models;

/**
 *
 * @author César Eduardo
 */
public class ConfiguracionUsuario 
{
    int IDUsuario;
    int Tema;
    int Componente1;
    int Componente2;

    public int getComponente1() {
        return Componente1;
    }

    public void setComponente1(int Componente1) {
        this.Componente1 = Componente1;
    }

    public int getComponente2() {
        return Componente2;
    }

    public void setComponente2(int Componente2) {
        this.Componente2 = Componente2;
    }

    public int getTema() {
        return Tema;
    }

    public void setTema(int Tema) {
        this.Tema = Tema;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
}
