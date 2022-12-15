import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Board board1 = new Board();

        int fila, columna;
        boolean posValida, correcto;

        while (!board1.finPartida()) {
            do {
                board1.mostrarTurnoActual();
                board1.mostrarTablero();

                correcto = false;
                fila = pedirInteger("Escribe la fila (0-2)");
                columna = pedirInteger ("Escribe la columna (0-2)");

                posValida = board1.validarPosicion(fila, columna);

                if (posValida) {
                    if (!board1.hayValorPosicion(fila, columna)) {
                        correcto = true;
                    } else {
                        System.out.println("ya hay una marca");
                    }
                } else {
                    System.out.println("posicion no valida");
                }
            } while (!correcto);
            board1.insertarEn(fila, columna);
            board1.cambiaTurno();
        }
        board1.mostrarTablero();
        board1.mostrarGanador();
    }
    static Scanner scan = new Scanner(System.in);
    public static int pedirInteger(String mensaje) {
        System.out.println(mensaje);
        int numero = scan.nextInt();
        return numero;
    }
}
