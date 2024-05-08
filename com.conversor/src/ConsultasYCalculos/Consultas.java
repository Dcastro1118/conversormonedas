package ConsultasYCalculos;
import Modelos.ResultadoMoneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consultas {

    String[] monedas = {};
    HttpClient client = HttpClient.newHttpClient();
    String direccion = "https://v6.exchangerate-api.com/v6/87bd9b17f46d2a4580299e29/";




    void actualizarMonedas(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccion + "codes"))
            .build();
        try {
            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ResultadoMoneda tipoDeCambio = gson.fromJson(json, ResultadoMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResultadoMoneda consultarMoneda(String codigoMoneda) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion + codigoMoneda))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ResultadoMoneda resultadoMoneda = gson.fromJson(json, ResultadoMoneda.class);
            return resultadoMoneda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public String[] solicitarTipoDeCambio(){


            JComboBox<String> comboBoxBase = new JComboBox<>(monedas);
            JComboBox<String> comboBoxCambio = new JComboBox<>(monedas);

            int monedaBase = JOptionPane.showConfirmDialog(null, comboBoxBase, "Selecciona una moneda base",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            int monedaCambio = JOptionPane.showConfirmDialog(null, comboBoxCambio, "Selecciona una moneda cambio",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String[] monedasElegidas = {monedas[comboBoxBase.getSelectedIndex()], monedas[comboBoxCambio.getSelectedIndex()]};
            return  monedasElegidas;

        }
        }







