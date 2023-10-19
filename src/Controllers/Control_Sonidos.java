package Controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author César Eduardo
 */
public class Control_Sonidos 
{
    public void ReproducirCorrecto() 
    {
        String ruta = "src\\Resources\\Sounds\\Correcto.wav"; // Ajusta la ruta según tu estructura de directorios

        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void ReproducirInicio() 
    {
        String ruta = "src\\Resources\\Sounds\\Inicio.wav"; // Ajusta la ruta según tu estructura de directorios

        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    
    public void ReproducirError1()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo1.wav";
        
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void ReproducirError2()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo2.wav";
        
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void ReproducirError3()
    {
        String ruta = "src\\Resources\\Sounds\\ErrorTipo3.wav";
        
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void ReproducirAdvertencia()
    {
        String ruta = "src\\Resources\\Sounds\\Advertencia.wav";
        
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.err.println("El archivo de sonido no existe en la ruta especificada.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
