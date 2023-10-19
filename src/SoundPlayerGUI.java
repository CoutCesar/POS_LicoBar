import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SoundPlayerGUI extends JFrame {

    public SoundPlayerGUI() {
        setTitle("Reproductor de Sonidos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new GridLayout(2, 4));

        JButton playButton1 = new JButton("Sonido 1");
        JButton playButton2 = new JButton("Sonido 2");
        JButton playButton3 = new JButton("Sonido 3");
        JButton playButton4 = new JButton("Sonido 4");
        JButton playButton5 = new JButton("Sonido 5");
        JButton playButton6 = new JButton("Sonido 6");
        JButton playButton7 = new JButton("Sonido 7");
        JButton playButton8 = new JButton("Sonido 8");

        panel.add(playButton1);
        panel.add(playButton2);
        panel.add(playButton3);
        panel.add(playButton4);
        panel.add(playButton5);
        panel.add(playButton6);
        panel.add(playButton7);
        panel.add(playButton8);

        playButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido1.wav");
            }
        });

        playButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido2.wav");
            }
        });

        playButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido3.wav");
            }
        });

        playButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido4.wav");
            }
        });

        playButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido5.wav");
            }
        });

        playButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido6.wav");
            }
        });

        playButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido7.wav");
            }
        });

        playButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("sonido8.wav");
            }
        });
    }

    private void playSound(String soundFileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SoundPlayerGUI soundPlayer = new SoundPlayerGUI();
                soundPlayer.setVisible(true);
            }
        });
    }
}
