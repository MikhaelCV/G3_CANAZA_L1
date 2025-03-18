import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada del Rectángulo A
        System.out.println("Ingrese las coordenadas del Rectángulo A (x1 y1 x2 y2):");
        Coordenada c1_A = new Coordenada(scanner.nextInt(), scanner.nextInt());
        Coordenada c2_A = new Coordenada(scanner.nextInt(), scanner.nextInt());
        Rectangulo A = new Rectangulo(c1_A, c2_A);

        // Entrada del Rectángulo B
        System.out.println("Ingrese las coordenadas del Rectángulo B (x1 y1 x2 y2):");
        Coordenada c1_B = new Coordenada(scanner.nextInt(), scanner.nextInt());
        Coordenada c2_B = new Coordenada(scanner.nextInt(), scanner.nextInt());
        Rectangulo B = new Rectangulo(c1_B, c2_B);

        // Verificar relación entre los rectángulos
        int resultado = Verificador.determinarRelacion(A, B);

        // Mostrar resultado
        switch (resultado) {
            case 1:
                System.out.println("Caso 1: Los rectángulos A y B se sobreponen.");
                break;
            case 2:
                System.out.println("Caso 2: Los rectángulos A y B están juntos.");
                break;
            case 3:
                System.out.println("Caso 3: Los rectángulos A y B son disjuntos.");
                break;
        }

        scanner.close();
    }
}
