public class Coordenada {
	// Atributos de la clase Coordenada
	private double x; // Coordenada en el eje X
	private double y; // Coordenada en el eje Y
	private Coordenada c; // Atributo de tipo Coordenada

	// Constructor por defecto, inicializa los atributos x, y a cero
	public Coordenada( ){
		x = 0;
		y = 0;
	}

	// Constructor con parámetros, inicializa los atributos x, y con los valores proporcionados
	public Coordenada(double x, double y ){
		this.x = x;
		this.y = y;
	}

	// Constructor con parámetro de tipo Coordenada, inicializa el atributo co con el valor proporcionado
	public Coordenada(Coordenada c ){
		this.c = c;
	}

	// Métodos setter para establecer los valores de x e y
	void setx(int x) {
		this.x = x;
	}
	void sety(int y){
		this.y = y;
	}

	// Métodos getter para obtener los valores de x e y
	double getx(){
	 return x;
	}
	double gety(){
	 return y;
	}

	// Método para el cálculo de la distancia euclideana entre esta Coordenada y otra proporcionada como parámetro
	public double distancia(Coordenada c){
		double Distx, Disty, distancia;
	    Distx = c.getx();
	    Disty = c.gety();
	    distancia = Distx - Disty;
	    if (distancia < 0){
	          distancia = distancia * -1;
	     }
	     return distancia;
	}

	// Método de clase que calcula la distancia euclideana entre dos Coordenadas proporcionadas como parámetros
	public static double distancia(Coordenada c1, Coordenada c2){
	    double Distx = 0,Disty = 0, distancia;
	    Distx = c1.getx()-c2.getx();
	    Distx = c1.gety()-c2.gety();
	   // Obtener valores absolutos
	   if(Distx < 0){
	      Distx=(Distx * -1);
	    }
	   if(Disty < 0){
	      Disty = (Distx * -1);
	     }
	     distancia=Math.sqrt(Distx * Distx + Disty * Disty);
	      return distancia;
	}

	// Método toString para representar la Coordenada en forma de texto
	public String toString(){
		return"("+ x + ";" + y + ")";
	}
}
