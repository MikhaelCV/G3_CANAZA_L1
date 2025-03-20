import java.util.Scanner;

public class PrincipalMain {
	// Método para calcular el área de intersección entre dos rectángulos
	public static double rectanguloSobre(Rectangulo r1, Rectangulo r2) {
		// Obteniendo las coordenadas de los rectángulos
		Coordenada rect1Cord1 = r1.getEsquina1();
		Coordenada rect1Cord2 = r1.getEsquina2();
		Coordenada rect2Cord1 = r2.getEsquina1();
		Coordenada rect2Cord2 = r2.getEsquina2();
		
		// Coordenadas del rectángulo 1
		double x1 = rect1Cord1.getx();  
		double y1 = rect1Cord1.gety();
		double x2 = rect1Cord2.getx();
		double y2 = rect1Cord2.gety();

		// Coordenadas del rectángulo 2
		double x3 = rect2Cord1.getx();  
		double y3 = rect2Cord1.gety();
		double x4 = rect2Cord2.getx();
		double y4 = rect2Cord2.gety();
		
		// Calculando los puntos de intersección
		double inicioXInterseccion = Math.max(x1, x3);
        double finXInterseccion = Math.min(x2, x4);    
	   	double inicioYInterseccion = Math.max(y4, y2);
	    double finYInterseccion = Math.min(y1, y3);
	    
	    // Creando un nuevo rectángulo con los puntos de intersección
	    Coordenada c1 = new Coordenada(inicioXInterseccion,inicioYInterseccion);
	    Coordenada c2 = new Coordenada(finXInterseccion,finYInterseccion);
	    Rectangulo rectanguloInterseccion = new Rectangulo(c1,c2);
	    
	    // Calculando el área de intersección
	    double areaSobrepuesta = rectanguloInterseccion.calculoArea();
	    return areaSobrepuesta;
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int i;
		// Declarando las variables para las coordenadas
		double x1,x2,x3, y3, y1, y2, x4,y4;
		Coordenada c1;
		Coordenada c2;
		Rectangulo rec1;
		Coordenada c3;
		Coordenada c4;
		Rectangulo rec2;		
		
		// Pidiendo al usuario cuántos rectángulos desea mostrar
		System.out.println("¿Cuántos rectángulos desea mostrar?");
		int n = Scanner.nextInt();
		ContainerRect cr = new ContainerRect(n*2);
		for (i = 0;i < n; i++){
			// Pidiendo al usuario las coordenadas de los rectángulos
			System.out.println("Ingrese una esquina del primer rectángulo: ");
			x1 = Scanner.nextDouble();
			y1 = Scanner.nextDouble();
			System.out.println();
 
			System.out.println("Ingrese la esquina opuesta del primer rectángulo: ");
			x2 = Scanner.nextDouble();
			y2 = Scanner.nextDouble();
			System.out.println();
			System.out.print("Ingrese una esquina del segundo rectángulo:");
			x3 = Scanner.nextDouble();
			y3 = Scanner.nextDouble();
			System.out.println();
 
			System.out.println("Ingrese la esquina opuesta del segundo rectángulo: ");
			x4 = Scanner.nextDouble();
			y4 = Scanner.nextDouble();
			
			// Creando los rectángulos con las coordenadas ingresadas
			rec1 = new Rectangulo(new Coordenada(x1,y1),new Coordenada(x2,y2));
			rec2 = new Rectangulo(new Coordenada(x3,y3),new Coordenada(x4,y4));
			
			// Mostrando los rectángulos creados
			System.out.println("Rectángulo A = "+ rec1.toString());
			System.out.println("Rectángulo B = "+ rec2.toString());
			
			// Añadiendo los rectángulos al contenedor
			cr.addRectagulo(rec1);
			cr.addRectagulo(rec2);
			
			// Verificando si los rectángulos se interceptan
			Verificador ver=new Verificador(rec1, rec2);
			System.out.println(ver.verificar(rec1, rec2));
			
		}
		System.out.println();
		// Mostrando todos los rectángulos en el contenedor
		System.out.println(cr.toString());
	}
}
