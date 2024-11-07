/**
* nombreClase: VectorAula.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 10 set. 2024
* @version 1
*/
package Clases.Progra2;

public class VectorAula{
	private Aula x[];

	public VectorAula() {
		x = new Aula[0];
	}
	public VectorAula(Aula va[]){
		x = va;
	}
	public void agregarAula(){
		int i;
		i = x.length;
		Aula a = new Aula();
		redimensionar1();
		a.leerAula();
		x[i] = a;
	}

	public Aula[] leerVector(){
		int i,n;
		Aula a = new Aula();
		System.out.print("Numero de aulas para el vector ---> ");
		n = Leer.datoInt();
		Aula v[]=new Aula[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Aula "+(i+1)+": ");
			a.leerAula();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Aula dato, int posi){
		int i;
		redimensionar1();
		i = x.length-1;
		if(posi >= 0 && posi < x.length){
			while(i > posi){
				x[i] = x[i-1];
				i = i-1;
			}
			x[posi] = dato;
		}
		else{
			System.out.println("Dimension o Posicion fuera de Rango");
		}
	}

	private void redimensionar1() {
		int n=x.length;
		n=n+1;
		Aula y[]=new Aula[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Aula v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void raya1(){
		int i;
		for(i=0;i<40;){
		System.out.print("-");
		i=i+1;
		}
		System.out.print("\n");
	}
	public void raya2(){
		int i;
		for(i=0;i<40;){
		System.out.print("=");
		i=i+1;
		}
		System.out.print("\n");
	}

	public void encabezado1(){
		String t1="RELACION DE AulaS EN STOCK";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="CAPACIDAD";
		String s3="TIPO DE EQUIPO";
		String s4="PABELLON";
		String s5="DISPONIBLE";
		raya2();
		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			i=i+1;
		}
		return(cad);
	} 
	public void ordenarAula(List<Aula> aa){
		Collections.sort(aa);
		mostrarVector();
	}

	public void ordenarPorTEquipo(List<Aula> aa){
		Collections.sort(aa, comparaTEquipo);
		mostrarVector();
	}
	public void ordenarPorPabellon(List<Aula> aa){
		Collections.sort(aa, comparaPabellon);
		mostrarVector();
	}
	public void ordenarPorDisponible(List<Aula> aa){
		Collections.sort(aa, comparaDisponible);
		mostrarVector();
	}
	
	private Comparator<Aula> comparaTEquipo=new Comparator<Aula>(){
		@Override
		public int compare(Docente a1, Docente a2){
			int iv;
			iv=a1.getTequipo().compareTo(a2.getTequipo());
			return iv;
		}
	};
	private Comparator<Aula> comparaPabellon=new Comparator<Aula>(){
		@Override
		public int compare(Docente a1, Docente a2){
			int iv;
			iv=a1.getPabellon().compareTo(a2.getPabellon());
			return iv;
		}
	};	
	private Comparator<Aula> comparaDisponible=new Comparator<Aula>(){
		@Override
		public int compare(Docente a1, Docente a2){
			int iv;
			iv=a1.getDisponible().compareTo(a2.getDisponible());
			return iv;
		}
	};
	
	public Aula buscarAulaxTequipo(Aula a[], String tequipo) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(tequipo.equals(a[i].getTequipo())) {
					return a[i];
				}
			}		
		}
		return null;
	}
	public Aula buscarAulaxCapacidad(Aula a[], int capacidad) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(capacidad == a[i].getCapacidad()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Aula buscarAulaxPabellon(Aula a[], String pabellon) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(pabellon.equals(a[i].getPabellon())) {
					return a[i];
				}
				
			}
			
		}
		return null;
	}
	public Aula buscarAulaxDisponible(Aula a[], boolean disponible) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(disponible == a[i].getDisponible()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public void redimensionar(int nl) {
	    Aula[] nuevoArray = new Aula[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	public Aula[] eliminarAulaxPos(Aula a[], int pos) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		if(pos >= 0 && pos < dx){
			for(i = pos ; i < dx - 1 ;i++) {
				a[i] = a[i + 1]; 
			}
			redimensionar(dx - 1);
		}else {
			 System.out.println("Posicion fuera de rango");
	       return a;
		}
		return a;		
	}
	public Alumno editarAlumno(Alumno edit) {
		int op,opc;
		String cap = "Capacidad  ";
		String te = "Tipo de equipo ";
		String pabe = "Pabellon ";
		String disp = "Disponibilidad ";
		Alumno temp;
		int vcap;
		String vte,vpabe;
		boolean vdisp;
		temp = edit;
		do{
			System.out.printf("\n\t\tR U T I N A  E D I C I O N\n\n");
			System.out.printf("\t0. SALIR\n");
			System.out.printf("\t1. %-16s: %d\n",cap,temp.getCapacidad());
			System.out.printf("\t2. %-16s: %s\n",te,temp.getTequipo());
			System.out.printf("\t3. %-16s: %s\n",pabe,temp.getPabellon());
			System.out.printf("\t1. %-16s: %d\n",disp,temp.getDisponibilidad());
			System.out.printf("Digite su opcion : ");
			opc = Leer.datoInt();
			switch(opc){
				case 0:
					break;
				case 1:
					System.out.printf("\nNUEVA capacidad ---> ");
					vcap= Leer.datoInt();
					temp.setCapacidad(vcap);
					break;
				case 2:
					System.out.printf("\nNUEVO tipo de equipo  ---> ");
					vte= Leer.dato();
					temp.setTequipo(vte);
					break;
				case 3:
					System.out.printf("\nNUEVA pabellon  ---> ");
					vpabe= Leer.dato();
					temp.setPabellon(vpabe);
					break;
				case 4:
					System.out.printf("\nNUEVA disponibilidad  ---> ");
					vdisp= Leer.datoBoolean();
					temp.setDisponible(vdisp);
					break;
				default :
					System.out.printf("\n\t...Opcion invalida...\n\n");
					break;
			}
		}while(opc!=0);   
		do {
			System.out.println("Esta seguro de editar? Si[1] No[2]: ");
			op = Leer.datoInt();	
		}while(op != 1 && op != 2);
		if(op == 1) {
			edit=temp;
		}
		return edit;
	}
}