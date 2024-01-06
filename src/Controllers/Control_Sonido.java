//Este codigo ya fue optimizado
//Falta Mejorar Exepciones
package Controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author César Eduardo
 */
public class Control_Sonido 
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Metodo para Reproducir el Sonido al realizar una Accion Correctamente
    public void reproducirSonidoCorrecto() 
    {
        String ruta = "src\\Resources\\Sounds\\Correcto.wav";

        try 
        {
            File archivo = new File(ruta);

            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Reproducir el Sonido de Inicio al Iniciar el Sistema
    public void reproducirSonidoInicio() 
    {
        String ruta = "src\\Resources\\Sounds\\Inicio.wav"; // Ajusta la ruta según tu estructura de directorios

        try 
        {
            File archivo = new File(ruta);
            
            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Reproducir el Sonido de Error o Advertencia
    public void reproducirSonidoError1()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo1.wav";
        
        try 
        {
            File archivo = new File(ruta);
            
            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Reproducir el Sonido de Error (Sin Uso por Ahora)
    public void reproducirSonidoError2()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo2.wav";
        
        try 
        {
            File archivo = new File(ruta);
            
            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }    
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Reproducir el Sonido de Error (Sin Uso por Ahora)
    public void reproducirSonidoError3()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo3.wav";
        
        try 
        {
            File archivo = new File(ruta);
            
            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Metodo para Reproducir el Sonido de Advertencia (Sin Uso por Ahora)
    public void reproducirSonidoAdvertencia()
    {
        String ruta = "src\\Resources\\Sounds\\Advertencia.wav";
        
        try 
        {
            File archivo = new File(ruta);
            
            if (archivo.exists()) 
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } 
            
            else 
            {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
        }
    }
}
