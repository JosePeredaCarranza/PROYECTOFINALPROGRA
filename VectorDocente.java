/**
* nombreClase: VectorDocente.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 14 set. 2024
* @version 1
*/
package Clases.Progra2;

public class VectorDocente {
	private Docente x[];

	public VectorDocente() {
		x = new Docente[0];
	}
	public VectorDocente(Docente va[]){
		x = va;
	}
	public void agregarDocente(){
		int i;
		i = x.length;
		Docente a = new Docente();
		redimensionar1();
		a.leerDocente();
		x[i] = a;
	}

	public Docente[] leerVector(){
		int i,n;
		Docente a = new Docente();
		System.out.print("Numero de Docentes para el vector ---> ");
		n = Leer.datoInt();
		Docente v[]=new Docente[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Docente "+(i+1)+": ");
			a.leerDocente();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Docente dato, int posi){
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
		Docente y[]=new Docente[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Docente v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
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
		String t1="RELACION DE DocenteS";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="Nombre";
		String s3="ID";
		String s4="CREDITOS";
		String s5="DOCENTE ASIGNADO";
		raya2();
		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
			i=i+1;
		}
		return(cad);
	} 
	public void ordenarDocentes(List<Docente> aa){
		Collections.sort(aa);
		mostrarVector();
	}

	public void ordenarPorCantCursos(List<Docente> aa){
		Collections.sort(aa, comparaCantCurso);
		mostrarVector();
	}
	public void ordenarPorSeccion(List<Docente> aa){
		Collections.sort(aa, comparaSeccion);
		mostrarVector();
	}
	private Comparator<Docente> comparaCantCurso=new Comparator<Docente>(){
		@Override
		public int compare(Docente a1, Docente a2){
			int iv;
			iv=a1.getCantCursos().compareTo(a2.getCantCursos());
			return iv;
		}
	};
	private Comparator<Docente> comparaSeccion=new Comparator<Docente>(){
		@Override
		public int compare(Docente a1, Docente a2){
			int iv;
			iv=a1.getSeccion().compareTo(a2.getSeccion());
			return iv;
		}
	};
	public Docente buscarDocentexNombre(Docente a[], String Nombre) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(Nombre.equals(a[i].getNombre())) {
					return a[i];
				}
			}		
		}
		return null;
	}
	public Docente buscarDocentexID(Docente a[], int id) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(id == a[i].getID()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Docente buscarDocentexArea(Docente a[], String area) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(area == a[i].getArea()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Docente buscarDocentextipoDeContrato(Docente a[], String tipoDeContrato) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(tipoDeContrato.equals(a[i].getTipoDeContrato())) {
					return a[i];
				}
			}
		}
		return null;
	}
	public void redimensionar(int nl) {
	    Docente[] nuevoArray = new Docente[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	public Docente[] eliminarDocentexPos(Docente a[], int pos) {
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
		String dni = "DNI ";
		String apat = "Apell pat. ";
		String amat = "Apell mat. ";
		String nom = "Nombre ";
		String edad = "Edad ";
		String sex = "Sexo ";
		String ide = "ID ";
		String cantcursos = "Cantidad de Cursos ";
		String seccion = "Seccion ";
		Alumno temp;
		int vide,vedad,cantcursos,seccion;
		String vdni,vapat,vamat,vnom,vsexo;
		temp = edit;
		do{
			System.out.printf("\n\t\tR U T I N A  E D I C I O N\n\n");
			System.out.printf("\t0. SALIR\n");
			System.out.printf("\t1. %-16s: %d\n",dni,temp.getDni());
			System.out.printf("\t2. %-16s: %s\n",apat,temp.getApat());
			System.out.printf("\t3. %-16s: %s\n",amat,temp.getAmat());
			System.out.printf("\t1. %-16s: %d\n",nom,temp.getNombre());
			System.out.printf("\t2. %-16s: %s\n",edad,temp.getEdad());
			System.out.printf("\t3. %-16s: %s\n",sex,temp.getSexo());
			System.out.printf("\t1. %-16s: %d\n",ide,temp.getId());
			System.out.printf("\t2. %-16s: %s\n",cantcursos,temp.getCantCursos());
			System.out.printf("\t3. %-16s: %s\n\n",seccion,temp.getSeccion());
			System.out.printf("Digite su opcion : ");
			opc = Leer.datoInt();
			switch(opc){
				case 0:
					break;
				case 1:
					System.out.printf("\nNUEVO DNI ---> ");
					vdni= Leer.dato();
					temp.setDni(vdni);
					break;
				case 2:
					System.out.printf("\nNUEVO apell pat.  ---> ");
					vapat= Leer.dato();
					temp.setApat(vapat);
					break;
				case 3:
					System.out.printf("\nNUEVA apell mat.  ---> ");
					vamat= Leer.dato();
					temp.setAmat(vamat);
					break;
				case 4:
					System.out.printf("\nNUEVO nombre  ---> ");
					vnom= Leer.dato();
					temp.setNombre(vnom);
					break;
				case 5:
					System.out.printf("\nNUEVA edad ---> ");
					vedad= Leer.datoInt();
					temp.setEdad(vedad);
					break;
				case 6:
					System.out.printf("\nNUEVO sexo ---> ");
					vsexo= Leer.dato();
					temp.setSexo(vsexo);
					break;
				case 7:
					System.out.printf("\nNUEVO ID ---> ");
					vide= Leer.datoInt();
					temp.setId(vide);
					break;
				case 8:
					System.out.printf("\nNUEVA cantidad de cursos ---> ");
					cantcursos= Leer.datoInt();
					temp.setNota(cantcursos);
					break;
				case 9:
					System.out.printf("\nNUEVO seccion ---> ");
					seccion= Leer.datoBoolean();
					temp.setEstado(seccion);
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
