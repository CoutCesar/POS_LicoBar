package Controllers;

/**
 *
 * @author César Eduardo
 */
public class Control_Validacion 
{
    public boolean TextFieldEntero(String Texto) 
    {
        boolean Error = false;

        for (char c : Texto.toCharArray()) {
            if (!Character.isDigit(c)) {
                Error = true;
                break;
            }
        }

        return Error;
    }
    
    
    public boolean TextFieldFloat(String Texto) 
    {
        boolean Error = false;
        int puntos = 0;

        for (char c : Texto.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && puntos < 1) {
                    puntos++;
                } else {
                    Error = true;
                    break;
                }
            }
        }

        return Error;
    }
}
