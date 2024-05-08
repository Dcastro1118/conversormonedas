import ConsultasYCalculos.Consultas;
import Modelos.ResultadoMoneda;

import javax.swing.*;

public class Main {
    static Consultas consulta = new Consultas();
    public static void main(String[] args) {
        String[] opciones = {"Consultar tipo de cambio", "Realizar conversion", "Salir"};
        JComboBox<String> comboBoxInicio = new JComboBox<>(opciones);
        int opcion;

        do {
            opcion = (JOptionPane.showConfirmDialog(null, comboBoxInicio, "Bienvenido al sistema tipos de cambio", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE));
            menu(comboBoxInicio.getSelectedIndex());
        } while (opcion != 2);

    }
    static void menu(int opcion){

        switch (opcion){
            case 0:
            String[] monedasElegidas = consulta.solicitarTipoDeCambio();
            ResultadoMoneda resultadoMoneda = consulta.consultarMoneda(monedasElegidas[0]);
            JOptionPane.showMessageDialog(null, "El tipo de cambio solicitado de " + monedasElegidas[0] + " a " + monedasElegidas[1] + " es de: " + resultadoMoneda.conversionRates().get(monedasElegidas[1]));
                break;
            case 1:
                break;
            case 2:
                System.exit(0);
                break;

        }
    }
}











//  87bd9b17f46d2a4580299e29