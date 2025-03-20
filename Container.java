public class ContainerRect {
	// Atributos de la clase ContainerRect
	int n,i = 0; // n es el máximo de cantidad de elementos e i es el índice que indica hasta qué valor está lleno 
	Rectangulo arrRec[]; // Array para almacenar los rectángulos
	double arrDist[]; // Array para almacenar las distancias de los rectángulos
	double arrArea[]; // Array para almacenar las áreas de los rectángulos

	// Constructor que toma un entero como parámetro
	public ContainerRect(int n) {
        this.n = n;
        this.arrRec = new Rectangulo[n];
        this.arrDist = new double[n];
        this.arrArea = new double[n];
        this.i = 0; // esto para evitar que se crea que se relleno
    }

	// Métodos getter para obtener los valores de n e i
	public int getMaximoDeRectangulos() {
		return n;
	}
	public int getRectangulos() {
		return i;
	}

	// Método setter para establecer el valor de n
	public void setN(int n) {
		this.n = n;
	}

	// Método toString para representar un elemento del array en forma de texto
	public String toString(int i) {
		return this.i + "["+arrRec[i]+"]"+"["+arrDist[i]+"]"+"["+arrArea[i]+"]";
	 }

	// Método para añadir un rectángulo al array
	public void addRectagulo(Rectangulo r1) {
		if (i < n) { // para que no exceda el número 
			arrRec[i] = r1;
			arrDist[i] = Coordenada.distancia(r1.getEsquina1(), r1.getEsquina2());
			arrArea[i] = r1.calculoArea();
			i++; // se agrega uno para que en el siguiente se rellene el siguiente
		}
				
	}

	// Método toString para representar el ContainerRect en forma de texto
	public String toString() {
		String result = "Rectangulo\tCoordenadas\t\tDistancia\tÁrea\n";
		for (int j=0;j<i;j++) {
			Rectangulo r1 = arrRec[j];
			Coordenada c1 =r1.getEsquina1(), c2 = r1.getEsquina2();
			double area = r1.calculoArea();
			result += (formatoTabla(j+1, r1.toString(), Coordenada.distancia(c1,c2), area))+"\n";
			j++;
		}
		return result;
	}

	// Método para formatear la tabla de salida
	public String formatoTabla(int numeroRectangulo, String coordenadas, double distancia,double area) {
		return String.format("%d\t\t%s\t\t\t%.3f\t\t%.2f", numeroRectangulo, coordenadas, distancia, area);
	}
}
