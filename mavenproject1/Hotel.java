/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

class Hotel {

    public Habitacion[][] matrizHabitaciones;

    public Hotel() {
        matrizHabitaciones = new Habitacion[5][5];
        cargarHabitaciones();
    }

    private void cargarHabitaciones() {

        int base = 101;
        double[] precios = {30, 40, 50, 50, 50};
        String[] estados = {"Libre", "Libre", "Libre", "Libre", "Sucia"};

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                String tipo = (j % 2 == 0) ? "Simple" : "Doble";

                matrizHabitaciones[i][j] = new Habitacion(base + j, tipo, precios[i]);

                matrizHabitaciones[i][j].setEstado(estados[j]);
            }

            base += 100;
        }

        matrizHabitaciones[1][0].setEstado("Ocupada");
        matrizHabitaciones[2][0].setEstado("Sucia");
    }

    public void mostrarEstadoHabitaciones() {

        String texto = "Estado actual del hotel\n";

        for (int i = 4; i >= 0; i--) {

            texto += "\nPiso " + (i + 1) + "\n";

            for (int j = 0; j < 5; j++) {

                Habitacion h = matrizHabitaciones[i][j];

                texto += "Hab " + h.getNumero()
                        + " | " + h.getTipo()
                        + " | " + h.getEstado()
                        + " | $" + h.getPrecio() + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    public void modificarHabitacion(int numero) {

        Habitacion h = buscarHabitacion(numero);

        if (h == null) {
            JOptionPane.showMessageDialog(null, "Habitación no existe");
            return;
        }

        String estado = JOptionPane.showInputDialog("Nuevo estado:");
        String tipo = JOptionPane.showInputDialog("Nuevo tipo:");
        double precio = Double.parseDouble(
                JOptionPane.showInputDialog("Nuevo precio:")
        );

        h.setEstado(estado);
        h.setTipo(tipo);
        h.setPrecio(precio);

        JOptionPane.showMessageDialog(null, "Datos actualizados");
    }

    public Habitacion buscarHabitacion(int numero) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (matrizHabitaciones[i][j].getNumero() == numero) {
                    return matrizHabitaciones[i][j];
                }
            }
        }

        return null;
    }

    public void mostrarResumenHotel() {

        int libres = 0;
        int ocupadas = 0;
        int sucias = 0;

        double ganancia = 0;

        double variableHabitacionesTodos = 0;
        int variableNumeroHabitacion = 0;
        int variableUno = 20;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                Habitacion h = matrizHabitaciones[i][j];

                variableHabitacionesTodos += h.getPrecio();
                variableNumeroHabitacion += h.getNumero();

                switch (h.getEstado()) {
                    case "Libre" ->
                        libres++;
                    case "Ocupada" -> {
                        ocupadas++;
                        ganancia += h.getPrecio();
                    }
                    case "Sucia" ->
                        sucias++;
                }
            }
        }

        int total = libres + ocupadas + sucias;

        double pLibres = (libres * 100.0) / total;
        double pOcupadas = (ocupadas * 100.0) / total;
        double pSucias = (sucias * 100.0) / total;

        String resultado = """
                Resumen del Hotel
                Libres: """ + libres + " (" + pLibres + "%)\n"
                + "Ocupadas: " + ocupadas + " (" + pOcupadas + "%)\n"
                + "Sucias: " + sucias + " (" + pSucias + "%)\n"
                + "Ganancia actual: $" + ganancia + "\n\n"
                + "Suma precios habitaciones: $" + variableHabitacionesTodos + "\n"
                + "Suma numeros habitaciones: " + variableNumeroHabitacion + "\n"
                + "VariableUno: " + variableUno;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
