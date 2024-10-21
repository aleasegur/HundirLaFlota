import java.util.Random;
import java.util.Scanner;

//ALEJANDRO ASENCIO GURAU
public class BattleShipV1 {

    //Inicializa el tablero llenándolo con el carácter '-' para representar posiciones vacías
    static void initTablero(char tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    //Coloca un número específico de barcos 'B' en posiciones aleatorias del tablero.
    static void colocarBarcos(char tablero[][], int numBarcos) {
        Random rand = new Random();
        int barcosColo = 0, fila, columna;
        while (barcosColo < numBarcos) {
            fila = rand.nextInt(5);
            columna = rand.nextInt(5);
            if (tablero[fila][columna] == '-') {
                tablero[fila][columna] = 'B';
                barcosColo++;
            }
        }
    }

    //Metodo muestra el tablero y " " representa los espacios
    static void mostrarTablero(char tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();//Hace la funcion de salto de linea
        }
    }

    public static void main(String[] args) {
        char tablero[][] = new char[5][5];
        int intentos = 0, barcosHundidos = 0, fila, columna;
        initTablero(tablero);
        colocarBarcos(tablero, 3);
        mostrarTablero(tablero);
        Scanner sc = new Scanner(System.in);

        while (barcosHundidos < 3) {
            /*El -1 se usa para ajustar las entradas del usuario. Los usuarios ingresan filas y columnas en el rango de 1 a 5,
            pero los índices de los arrays en Java empiezan en 0.
            Cuando el usuario ingresa 1 para la primera fila, se refiere al índice 0 del array.
            Cuando el usuario ingresa 2 para la segunda fila, se refiere al índice 1 del array.
            Y así sucesivamente.a*/
            System.out.println("Introduce fila (1-5): ");
            fila = sc.nextInt() - 1;
            System.out.println("Introduce fila (1-5): ");
            columna = sc.nextInt() - 1;

            if (tablero[fila][columna] == 'B') {
                System.out.println("¡Tocado y Hundido!");
                tablero[fila][columna] = 'X';
                barcosHundidos++;
            } else {
                System.out.println("Agua....");
                tablero[fila][columna] = '*';
            }
            intentos++;
            mostrarTablero(tablero);
        }

        System.out.println("Has hundido todos los barcos en " + intentos + " intentos");
    }
}
