package ejercicio_thread_ddr_4;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caballo extends Observable implements Runnable {

    private String nombre; /// Variable nombre

    public Caballo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() { /// como si fuera el main

        int porcentaje = 0; // el porcentaje empieza en 0 %
        int numAleatorio;
        try {
            while (porcentaje < 100) {
                numAleatorio = generaNumeroAleatorio(1, 15);
                System.out.println("Caballo " + nombre + " ha aumentado en " + numAleatorio); // para darle seguimiento y saber los numero que se estan desenvolviendo
                porcentaje += numAleatorio; // el porcentaje que estaba en 0%, aumenta lo que haya salido del numero aleatorio

                this.setChanged(); // para hacer el cambio
                this.notifyObservers(porcentaje); // y notificar o avisar sobre el cambio el cual va a ser el "porcentaje"
                this.clearChanged(); //cerramos cambios

                Thread.sleep(1000); /// para que se pueda ver el proceso mas lento

            }
        } catch (InterruptedException ex) { /// al acabar la carrera se deben interrumpir a los demas caballos, por lo tanto sale este aviso
            System.out.println("Hilo interrumpido");
        }

    }
        /// RANDOM
    public static int generaNumeroAleatorio(int minimo, int maximo) { // Funcion para hacer numero aleatorios entre 1 y 15
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
