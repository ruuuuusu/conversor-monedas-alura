import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaConversor {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Conversor de Monedas");
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(248,215,218));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("Conversor de Monedas", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(199,21,133));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        gbc.gridwidth = 1;

        JLabel labelCantidad = new JLabel("Cantidad");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelCantidad, gbc);

        JTextField cantidad = new JTextField();
        gbc.gridx = 1;
        panel.add(cantidad, gbc);

        JLabel labelOrigen = new JLabel("De");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelOrigen, gbc);

        String[] monedas = {"USD","ARS","BRL","EUR"};

        JComboBox<String> origen = new JComboBox<>(monedas);
        gbc.gridx = 1;
        panel.add(origen, gbc);

        JLabel labelDestino = new JLabel("A");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelDestino, gbc);

        JComboBox<String> destino = new JComboBox<>(monedas);
        gbc.gridx = 1;
        panel.add(destino, gbc);

        JButton convertir = new JButton("Convertir");
        convertir.setBackground(new Color(255,105,180));
        convertir.setForeground(Color.WHITE);
        convertir.setFont(new Font("Segoe UI", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(convertir, gbc);

        JLabel resultado = new JLabel("Resultado:", SwingConstants.CENTER);
        resultado.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultado.setForeground(new Color(138,43,226));

        gbc.gridy = 5;
        panel.add(resultado, gbc);

        ventana.add(panel);

        convertir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    double valor = Double.parseDouble(cantidad.getText());

                    String base = origen.getSelectedItem().toString();
                    String cambio = destino.getSelectedItem().toString();

                    ConsultaMoneda consulta = new ConsultaMoneda();
                    Moneda datos = consulta.buscarMoneda(base);

                    double tasa = datos.conversion_rates.get(cambio);

                    double total = valor * tasa;

                    resultado.setText("Resultado: " + total + " " + cambio);

                } catch (Exception ex) {

                    resultado.setText("Error en la conversión");

                }

            }

        });

        ventana.setVisible(true);
    }
}