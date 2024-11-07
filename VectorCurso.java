/**
* nombreClase: VectorCurso.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 14 set. 2024
* @version 1
*/
package Clases.Progra2;

public class VectorCurso {
	private Curso x[];
	
	public VectorCurso() {
		x = new Curso[0];
	}
	public VectorCurso(Curso va[]){
		x = va;
	}
	public void agregarCurso(){
		int i;
		i = x.length;
		Curso a = new Curso();
		redimensionar1();
		a.leerCurso();
		x[i] = a;
	}
	public void agregarCurso(Curso c){
		int i;
		i = x.length;
		redimensionar1();
		x[i] = c;
	}

	public Curso[] leerVector(){
		int i,n;
		Curso a = new Curso();
		System.out.print("Numero de Cursos para el vector ---> ");
		n = Leer.datoInt();
		Curso v[]=new Curso[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Curso "+(i+1)+": ");
			a.leerCurso();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Curso dato, int posi){
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
		Curso y[]=new Curso[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15s %7d\n", i + 1,x[i].getNombre().toString(),x[i].getSeccion());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Curso v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15s %7d\n", i + 1,x[i].getNombre().toString(),x[i].getSeccion());
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
		String t1="RELACION DE CURSOS";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="ASIGNATURA";
		String s3="CODIGO";
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
			cad=cad+String.format("%4d %-15s %7d\n", i + 1,x[i].getNombre().toString(),x[i].getSeccion());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Curso[] arr, int low, int high,int opc) {
      if (low < high) {
      	switch(opc) {
      		case 1:
      			int pi = sortCursoxAsignatura(arr, low, high);
               quickSort(arr, low, pi - 1,opc);
               quickSort(arr, pi + 1, high,opc);
      		case 2:
      			int pi1 = sortCursoxCodigo(arr, low, high);
               quickSort(arr, low, pi1 - 1,opc);
               quickSort(arr, pi1 + 1, high,opc);
      		case 3:
      			int pi2 = sortCursoxCreditos(arr, low, high);
               quickSort(arr, low, pi2 - 1,opc);
               quickSort(arr, pi2 + 1, high,opc);
      		case 4:
      			int pi3 = sortCursoxDocenteAsignado(arr, low, high);
               quickSort(arr, low, pi3 - 1,opc);
               quickSort(arr, pi3 + 1, high,opc);
      	}
      }
  }

  private static int sortCursoxAsignatura(Curso[] arr, int low, int high) {
      Curso pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getAsignatura().compareTo(pivot.getAsignatura()) <= 0) {
              i++;
              Curso temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      Curso temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
  }
  private static int sortCursoxCodigo(Curso[] arr, int low, int high) {
	  Curso pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getCodigo() < pivot.getCodigo()) {
			  i++;
			  Curso temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Curso temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortCursoxCreditos(Curso[] arr, int low, int high) {
	  Curso pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getCreditos() < pivot.getCreditos() ) {
			  i++;
			  Curso temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Curso temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortCursoxDocenteAsignado(Curso[] arr, int low, int high) {
	  Curso pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getDocenteAsignado().compareTo(pivot.getDocenteAsignado()) <= 0) {
			  i++;
			  Curso temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  Curso temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  return i + 1;
  }
  public Curso buscarCursoxAsignatura(Curso a[], String asignatura) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(asignatura.equals(a[i].getAsignatura())) {
				  return a[i];
				}
			}		
		}
		return null;
  }
  public boolean buscarCursoxAsignatura(String ev) {
	  int i;
	  for(i = 0 ; i < x.length ;i++) {
		  if(ev.equals(x[i].getNombre())) {
			  return true;
		  }
	  }
	  return false;
  }
	 
  public Curso buscarCursoxCodigo(Curso a[], int id) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(id == a[i].getCodigo()) {
				  return a[i];
			  }
		  }
	  }
	  return null;
  }
  public Curso buscarCursoxCreditos(Curso a[], int creditos) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(creditos == a[i].getCreditos()) {
				  return a[i];
			  }
		  }
	  }
	  return null;
  }
  public Curso buscarCursoxDocenteAsignado(Curso a[], String docenteAsignado) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(docenteAsignado.equals(a[i].getDocenteAsignado())) {
				  return a[i];
			  }
		  }
	  }
	  return null;
  }
  public void redimensionar(int nl) {
	  Curso[] nuevoArray = new Curso[nl];
	  for (int i = 0; i < nl; i++) {
		  nuevoArray[i] = x[i];
	  }
	  x = nuevoArray;
  }
  public Curso[] eliminarCursoxPos(Curso a[], int pos) {
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
  public Curso editarCurso(Curso edit,int opc) {
	  boolean flag = false;
	  String asignatura;
	  int codigo;
	  int creditos;
	  String docenteAsignado;
	  if(opc == 1) {
		  flag = true;
	  }
	  if(opc == 2 || flag) {
		  System.out.print("Asignatura ---> ");
		  asignatura = Leer.dato();
		  edit.setAsignatura(asignatura);
	  }
	  if(opc == 3 || flag) {
		  System.out.print("Codigo ---> ");
		  codigo=Leer.datoInt();
		  edit.setCodigo(codigo);
	  }
	  if(opc == 4 || flag) {
		  System.out.print("Creditos   ---> ");
		  creditos = Leer.datoInt();
		  edit.setCreditos(creditos);
	  }
	  if(opc == 5 || flag) {
		  System.out.print("Email   ---> ");
		  docenteAsignado = Leer.dato();
		  edit.setDocenteAsignado(docenteAsignado);
	  }
	  return edit;
  }
	
}

