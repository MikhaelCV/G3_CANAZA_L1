public class Verificador {
	
	// Atributos de la clase Verificador
	private Rectangulo rec1; // Primer rectángulo a verificar
	private Rectangulo rec2; // Segundo rectángulo a verificar
	private Verificador ver; // Atributo de tipo Verificador
	
	// Constructor que toma dos rectángulos como parámetros
	public Verificador(Rectangulo rec1, Rectangulo rec2) {
		setrec1(rec1);
		setrec2(rec2);
	}
	
	// Métodos setter para establecer los valores de rec1 y rec2
	public void setrec1 (Rectangulo rec1) {
		this.rec1 = rec1;
	}
	public void setrec2 (Rectangulo rec2) {
		this.rec2 = rec2;
	}
	
	// Método para verificar si dos rectángulos se interceptan
	public String verificar(Rectangulo rect1,Rectangulo rect2) {
		Rectangulo rec1, rec2;
		
		// Lógica para tener el orden izquierda superior derecha inferior
		
		// Rectángulo 1
		Coordenada rect1Cord1 = rect1.getEsquina1();
		Coordenada rect1Cord2 = rect1.getEsquina2();
		
		// Rectángulo 2
		Coordenada rect2Cord1 = rect2.getEsquina1();
		Coordenada rect2Cord2 = rect2.getEsquina2();
		
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
		
		// Lógica para que se escoja la esquina superior izquierda como C1 y la esquina inferior derecha como C2
		// Para el rectángulo 1
		if (x1<x2) {
			if( y1> y2) {
				rec1 = new Rectangulo(new Coordenada(x1,y1), new Coordenada(x2,y2));
			} else {
				rec1 = new Rectangulo(new Coordenada(x1,y2), new Coordenada(x2,y1));
			}
		} else {
			if(y1> y2) {
				rec1 = new Rectangulo(new Coordenada(x2,y1), new Coordenada(x1,y2));
			} else {
				rec1 = new Rectangulo(new Coordenada(x2,y2), new Coordenada(x1,y1));
			}				
		}
		
		// Lógica para que se escoja la esquina superior izquierda como C1 y la esquina inferior derecha como C2
		// Para el rectángulo 2
		if (x3<x4) {
			if(y3> y4) {
				rec2 = new Rectangulo(new Coordenada(x3,y3), new Coordenada(x4,y4));
			} else {
				rec2 = new Rectangulo(new Coordenada(x3,y4), new Coordenada(x4,y3));
			}
		} else {
			if(y3> y4) {
				rec2 = new Rectangulo(new Coordenada(x4,y3), new Coordenada(x3,y4));
			} else {
				rec2 = new Rectangulo(new Coordenada(x4,y4), new Coordenada(x3,y3));
			}				
		}
		
		// Vuelvo a escribir los nuevos valores de x y y
		// Para el rectángulo 1
		rect1Cord1 = rec1.getEsquina1();
		rect1Cord2 = rec1.getEsquina2();
		
		// Para el rectángulo 2
		rect2Cord1 = rec2.getEsquina1();
		rect2Cord2 = rec2.getEsquina2();
		
		x1 = rect1Cord1.getx();  
		y1 = rect1Cord1.gety();
		x2 = rect1Cord2.getx();
		y2 = rect1Cord2.gety();

		x3 = rect2Cord1.getx();  
		y3 = rect2Cord1.gety();
		x4 = rect2Cord2.getx();
		y4 = rect2Cord2.gety();

        // Verificar si los rectángulos se interceptan
        if(noSeInterceptanLosRectangulos(rec1,rec2)) {
        	return "Rectángulos A y B son disjuntos";
        } else {
        	double areaSobre = PrincipalMain.rectanguloSobre(rec1, rec2);
        	if (areaSobre == 0) {
        		return "Rectángulos A y B se juntan";        		
        	}
        	return "Rectángulos A y B se sobreponen\nÁrea de sobreposicion ="+ String.format("%.2f", areaSobre);      	
        } 
        
        
	}
	
	// Método para verificar si dos rectángulos no se interceptan
	public boolean noSeInterceptanLosRectangulos(Rectangulo r1, Rectangulo r2) {
		// Verificar si uno de los rectángulos está completamente a la izquierda o derecha del otro
		boolean r1EstaALaIzqDeR2 = r1.getEsquina2().getx() < r2.getEsquina1().getx();
		boolean r1EstaALaDerechaDeR2= r1.getEsquina1().getx() > r2.getEsquina2().getx();
        if (r1EstaALaIzqDeR2 || r1EstaALaDerechaDeR2) {
            return true;
        }
        boolean r1EstaArribaDeR2 = r1.getEsquina2().gety() > r2.getEsquina1().gety();
		boolean r1EstaDebajoDeR2 = r1.getEsquina1().gety() < r2.getEsquina2().gety();
        // Verificar si uno de los rectángulos está completamente arriba o abajo del otro
        if (r1EstaArribaDeR2 || r1EstaDebajoDeR2) {
            return true;
        }

        // Si ninguno de los casos anteriores se cumple, los rectángulos chocan entre sí
        return false;

    }
}
