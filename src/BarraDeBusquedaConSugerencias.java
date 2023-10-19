import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BarraDeBusquedaConSugerencias extends JFrame {
    private JTextField textField;
    private JList<String> suggestionList;
    private DefaultListModel<String> listModel;
    private List<String> sugerencias;

    public BarraDeBusquedaConSugerencias() {
        sugerencias = new ArrayList<>();
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSugerencias();
            }
        });

        suggestionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panel = new JPanel();
        panel.add(textField);

        JScrollPane scrollPane = new JScrollPane(suggestionList);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));

        panel.add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void actualizarSugerencias() {
        listModel.clear();
        String textoBusqueda = textField.getText().toLowerCase();
        for (String sugerencia : sugerencias) {
            if (sugerencia.toLowerCase().contains(textoBusqueda)) {
                listModel.addElement(sugerencia);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarraDeBusquedaConSugerencias barraDeBusqueda = new BarraDeBusquedaConSugerencias();
            barraDeBusqueda.setVisible(true);
        });
    }
}