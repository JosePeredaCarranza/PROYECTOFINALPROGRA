package Clases.Progra2;

public class TMain {
	public static void main(String args[]) {
		Alumno prueba = new Alumno("76905373","PEREDA","CARRANZA","Jose",20,"Masculino",23200044,14,true);
		Alumno prueba1 = new Alumno("73232233","HUANACUNI","GOMEZ","Jean",19,"Masculino",23200181,13,true);
		//prueba.mostrarAlu();
		VectorAlumno a=new VectorAlumno();
		Alumno prueba3[] = {
				new Alumno("76905373","PEREDA","CARRANZA","D",20,"Masculino",23200044,14,true),
				new Alumno("73232233","HUANACUNI","GOMEZ","A",19,"Masculino",23200181,13,true),
		};
		a.agregarAlumno(prueba);
		a.agregarAlumno(prueba1);
		a.mostrarVector();
		a.quickSort(0,a.getDimension() - 1, 1);
		a.mostrarVector();
		a.mostrarVector(prueba3);
		a.quickSort(prueba3,0, prueba3.length - 1, 1);
		a.mostrarVector(prueba3);
		
		//valum = a.leerVector();
	}
}
