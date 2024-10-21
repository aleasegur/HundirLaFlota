import java.util.Random;
import java.util.Scanner;
//ALEJANDRO ASENCIO GURAU
public class BattleShipV2 {

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
            fila = rand.nextInt(tablero.length);
            columna = rand.nextInt(tablero[0].length);
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
            System.out.println();//Hace la funcion de salto de linea para colocarlo en forma cuadrado o rectangulo
        }
    }

    public static void main(String[] args) {
        int filas, columnas, numBarcos, intentos = 0, barcosHundidos = 0, fila, columna;
        char tablero[][];
        Scanner sc = new Scanner(System.in);
        /*Le pido al usurio la cantidad deseada de filas,columnas y barcos que quiera*/
        System.out.print("Introduce la cantidad de filas: ");
        filas = sc.nextInt();

        System.out.print("Introduce la cantidad de columnas: ");
        columnas = sc.nextInt();

        System.out.print("Introduce el número de barcos: ");
        numBarcos = sc.nextInt();

        tablero = new char[filas][columnas];

        initTablero(tablero);
        colocarBarcos(tablero, numBarcos);
        mostrarTablero(tablero);

        while (barcosHundidos < numBarcos) {
            /*El -1 se usa para ajustar las entradas del usuario. Los usuarios ingresan filas y columnas en el rango de 1 a 5,
            pero los índices de los arrays en Java empiezan en 0.
            Cuando el usuario ingresa 1 para la primera fila, se refiere al índice 0 del array.
            Cuando el usuario ingresa 2 para la segunda fila, se refiere al índice 1 del array.
            Y así sucesivamente.a*/
            System.out.println("Introduce fila(1-" + filas + " para filas): ");
            fila = sc.nextInt() - 1;
            System.out.println("Introduce columna(1-" + columnas + "para columnas): ");
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
