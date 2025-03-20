public class Rectangulo {
	// Atributos de la clase Rectangulo
	private Coordenada esquina1; // Coordenada de una esquina del rectángulo
	private Coordenada esquina2; // Coordenada de la esquina opuesta del rectángulo
	private Rectangulo rec1; // Atributo de tipo Rectangulo

	// Constructor que toma dos Coordenadas como parámetros
	public Rectangulo(Coordenada c1, Coordenada c2) {
		setEsquina1(c1);
		setEsquina2(c2);
	}

	// Constructor que toma un Rectangulo como parámetro
	public Rectangulo( Rectangulo rec1) {
		this.rec1 = rec1;
	}

	// Método setter para establecer el valor del atributo rec1
	void setR(Rectangulo rec1) {
		this.rec1 = rec1;
	}

	// Métodos setter para establecer los valores de esquina1 y esquina2
	public void setEsquina1 (Coordenada coo) {
		this.esquina1 = coo;
	}
	public void setEsquina2 (Coordenada coo) {
		this.esquina2 = coo;
	}

	// Métodos getter para obtener los valores de esquina1 y esquina2
	public Coordenada getEsquina1 () {
		return esquina1;
	}
	Coordenada getEsquina2 () {
		return esquina2;
	}

	// Método para calcular el área del rectángulo
	public double calculoArea() {
		double area,x,y;
		Coordenada c1 = this.getEsquina1();
		Coordenada c2 = this.getEsquina2();
		x = c1.getx() - c2.getx();
		y = c1.gety() - c2.gety();
		if (x < 0) {
			x = x * -1;
		}
		else if(y < 0) {
			y = y * -1;
		}
		area = Math.abs(x * y); // se saca valor absoluto para que no de negativo
		return area;
	}
	
	// Método toString para representar el Rectangulo en forma de texto
	public String toString() {
		return"[ (" + this.esquina1 + ";" + this.esquina2 + ") ]";
	}
}
