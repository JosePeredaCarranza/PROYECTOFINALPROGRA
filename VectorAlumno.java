/**
* nombreClase: VectorAlumno.java
* descripción:
*
*
* @autores HUANACUNI GOMEZ, Jean Carlos Josue
* 		   PEREDA CARRANZA, Jose Carlos Enrique
* @date: 27 set. 2024
* @version 2
*/
package Clases.Progra2;

public class VectorAlumno {
	private Alumno x[];

	public VectorAlumno() {
		x = new Alumno[0];
	}
	public VectorAlumno(Alumno va[]){
		x = va;
	}
	public void agregarAlumno(){
		int i;
		i = x.length;
		Alumno a = new Alumno();
		redimensionar1();
		a.leerPersona();
		x[i] = a;
	}
	public void agregarAlumno(Alumno a){
		int i;
		i = x.length;
		redimensionar1();
		x[i] = a;
	}

	public Alumno[] leerVector(){
		int i,n;
		System.out.print("Numero de alumnos para el vector ---> ");
		n = Leer.datoInt();
		Alumno v[]=new Alumno[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Alumno "+(i+1)+": ");
			Alumno a = new Alumno();
			a.leerPersona();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Alumno dato, int posi){
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
		Alumno y[]=new Alumno[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}
	
	public void mostrarVector(){
		if(x.length > 0){
			encabezado1();
			encabezado2();
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%5d",i+1);
				System.out.println(x[i]);
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Alumno v[]){
		if(v.length > 0 && v[0] != null){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length ; i++){
				System.out.printf("%5d",i+1);
				System.out.println(v[i]);
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void raya1(){
		int i;
		for(i=0;i<105;){
		System.out.print("-");
		i=i+1;
		}
		System.out.print("\n");
	}
	public void raya2(){
		int i;
		for(i=0;i<105;){
		System.out.print("=");
		i=i+1;
		}
		System.out.print("\n");
	}

	public void encabezado1(){
		String t1="RELACION DE ALUMNOS";
		System.out.printf("\t\t\t\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="DNI";
		String s3="A.Paterno";
		String s4="A.Materno";
		String s5="Nombre";
		String s6="Edad";
		String s7="Sexo";
		String s8="Codigo";
		String s9="Nota";
		String s10="Estado";
		raya2();
		System.out.printf("%5s %8s %9s %10s %7s %9s %3s %12s %12s %15s\n",s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15d %6s %-10f %10b\n", i + 1, x[i].getCod(), x[i].getNombre(), x[i].getNota(), x[i].getEstado());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Alumno[] arr, int low, int high,int opc) {
		if(arr.lenght > 0) {
			if (low < high) {
				int pi = 0;
				switch(opc) {
					case 1:
						pi = sortAlumnoxDNI(arr, low, high);
						break;
		      		case 2:
		      			pi = sortAlumnoxAPaterno(arr, low, high);
		      			break;
		      		case 3:
		      			pi = sortAlumnoxAMaterno(arr, low, high);
		    			break;
		      		case 4:
		      			pi = sortAlumnoxNombre(arr, low, high);
		     			break;
		      		case 5:
		      			pi = sortAlumnoxEdad(arr, low, high);
		      			break;
		      		case 6:
		      			pi = sortAlumnoxSexo(arr, low, high);
		      			break;
		      		case 7:
		      			pi = sortAlumnoxCodigo(arr, low, high);
		      			break;
		      		case 8:
		      			pi = sortAlumnoxNota(arr, low, high);
		      			break;
		      		case 9:
		      			pi = sortAlumnoxEstado(arr, low, high);
		      			break;
	    	  }
	    	  quickSort(arr, low, pi - 1,opc);
	    	  quickSort(arr, pi + 1, high,opc);
		}else
			System.out.println("Vector ordenado");
		
      }else
    	  	System.out.println("Vector vacio");
	}
	private static int sortAlumnoxDNI(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
	      int i = low - 1;

	      for (int j = low; j < high; j++) {
	          if (arr[j].getDni().compareTo(pivot.getDni()) <= 0) {
	              i++;
	              Alumno temp = arr[i];
	              arr[i] = arr[j];
	              arr[j] = temp;
	          }
	      }

	      Alumno temp = arr[i + 1];
	      arr[i + 1] = arr[high];
	      arr[high] = temp;

	      return i + 1;
	}
	private static int sortAlumnoxAPaterno(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getApat().compareTo(pivot.getApat()) <= 0) {
				i++;
				Alumno temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		Alumno temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	private static int sortAlumnoxAMaterno(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getAmat().compareTo(pivot.getAmat()) <= 0) {
				i++;
				Alumno temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		Alumno temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	private static int sortAlumnoxNombre(Alumno[] arr, int low, int high) {
      Alumno pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
              i++;
              Alumno temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      Alumno temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
  }
	private static int sortAlumnoxEdad(Alumno[] arr, int low, int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getEdad() < pivot.getEdad()) {
				i++;
				Alumno temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		Alumno temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	private static int sortAlumnoxSexo(Alumno[] arr, int low, int high) {
	      Alumno pivot = arr[high];
	      int i = low - 1;

	      for (int j = low; j < high; j++) {
	          if (arr[j].getSexo().compareTo(pivot.getSexo()) <= 0) {
	              i++;
	              Alumno temp = arr[i];
	              arr[i] = arr[j];
	              arr[j] = temp;
	          }
	      }

	      Alumno temp = arr[i + 1];
	      arr[i + 1] = arr[high];
	      arr[high] = temp;

	      return i + 1;
	  }
	private static int sortAlumnoxCodigo(Alumno[] arr, int low, int high) {
	  Alumno pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getCod() < pivot.getCod()) {
			  i++;
			  Alumno temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Alumno temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
	private static int sortAlumnoxNota(Alumno[] arr, int low, int high) {
	  Alumno pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getNota() < pivot.getNota()) {
			  i++;
			  Alumno temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Alumno temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
	private static int sortAlumnoxEstado(Alumno[] arr, int low, int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
	  
		for (int j = low; j < high; j++) {
			if (arr[j].getEstado() == pivot.getEstado()) {
				i++;
				Alumno temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		Alumno temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
	
	//ordenar sin sobrecargar
	public void quickSort(int low, int high, int opc) {
		if(this.length > 0) {
			if (low < high) {
				int pi = 0;
				switch (opc) {
					case 1:
						pi = sortAlumnoxDNI( low, high);
		    			break;
		    		case 2:
		    			pi = sortAlumnoxAPaterno( low, high);
		    			break;
		    		case 3:
		    			pi = sortAlumnoxAMaterno( low, high);
		    			break;
		    		case 4:
		    			pi = sortAlumnoxNombre( low, high);
		    			break;
		    		case 5:
		    			pi = sortAlumnoxEdad( low, high);
		    			break;
		    		case 6:
		    			pi = sortAlumnoxSexo( low, high);
		    			break;
		    		case 7:
		    			pi = sortAlumnoxCodigo( low, high);
		    			break;
		    		case 8:
		    			pi = sortAlumnoxNota( low, high);
		    			break;
		    		case 9:
		    			pi = sortAlumnoxEstado( low, high);
		    			break;
				}
				quickSort(low, pi - 1, opc);
				quickSort(pi + 1, high, opc);
			}else
				System.out.println("Vector ordenado");
		
		}else
			System.out.println("Vector vacio");
	}
	private int sortAlumnoxDNI(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getDni().compareTo(pivot.getDni()) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
	private int sortAlumnoxAPaterno(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (x[j].getApat().compareTo(pivot.getApat()) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
	private int sortAlumnoxAMaterno(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getAmat().compareTo(pivot.getAmat()) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
  }
	private int sortAlumnoxNombre(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
  }
	private int sortAlumnoxEdad(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getEdad() < pivot.getEdad()) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
	private int sortAlumnoxSexo(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getSexo().compareTo(pivot.getSexo()) <= 0) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
	private int sortAlumnoxCodigo(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (x[j].getCod() < pivot.getCod()) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
	private int sortAlumnoxNota(int low, int high) {
		Alumno pivot = x[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (x[j].getNota() < pivot.getNota()) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, high);
		return i + 1;
	}
  	private int sortAlumnoxEstado(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getEstado() == pivot.getEstado()) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  	}

  	private void swap(int i, int j) {
  		Alumno temp = x[i];
  		x[i] = x[j];
  		x[j] = temp;
  	}
  	
  	//Buscar alumno
  	public Alumno buscarAlumnoxDNI(String dato) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx) {
  				if(dato.equals(x[i].getDni())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int buscarPosAlumnoxDNI(String dato) {
  		int dx,i,pos;
  		boolean hallado;
  		hallado = false;
  		dx = x.length;
  		pos=-1;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx && !hallado) {
  				if(dato.equals(x[i].getDni())) {
  					pos=i;
  					hallado=true;
  				}
  			}		
  		}
  		return pos;
  	}
  	public Alumno buscarAlumnoxDNI(Alumno a[], String dato) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx) {
  				if(dato.equals(a[i].getDni())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int buscarPosAlumnoxDNI(Alumno a[], String dato) {
  		int dx,i,pos;
  		boolean hallado;
  		hallado = false;
  		dx = a.length;
  		pos=-1;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx && !hallado) {
  				if(dato.equals(a[i].getDni())) {
  					pos=i;
  					hallado=true;
  				}
  			}		
  		}
  		return pos;
  	}
  	
  	
  	public VectorAlumno buscarAlumnoxAPaterno(String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(x[i].getApat())) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxAPaterno(String dato) {
  		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
         }
         int[] temp = new int[x.length];
         j = 0;

         for (i = 0; i < x.length; i++) {
             if (dato.equals(x[i].getApat())){
                 temp[j] = i;
                 j=j+1;
             }
         }
         if (j == 0) {
             return new int[0];
         }
         
         int[] result = new int[j];
         for (i = 0; i < j; i++) {
             result[i] = temp[i]; 
         }
         return result;
  	}
  	public VectorAlumno buscarAlumnoxAMaterno(String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(x[i].getAmat())) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxAMaterno(String dato) {
  		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[x.length];
  		j = 0;
  		for (i = 0; i < x.length; i++) {
  			if (dato.equals(x[i].getAmat())){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		}
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	
  	
  	public VectorAlumno buscarAlumnoxAPaterno(Alumno a[], String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(a[i].getApat())) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxAPaterno(Alumno a[], String dato) {
  		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato.equals(a[i].getApat())){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	public VectorAlumno buscarAlumnoxAMaterno(Alumno a[], String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(a[i].getAmat())) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxAMaterno(Alumno a[], String dato) {
  		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato.equals(a[i].getAmat())){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	
  	
  	public VectorAlumno buscarAlumnoxNombre(Alumno a[], String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(a[i].getNombre())) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
	}	
  	public int[] buscarPosAlumnoxNombre(Alumno a[], String dato) {
  		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato.equals(a[i].getNombre())){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	public VectorAlumno buscarAlumnoxNombre(String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(x[i].getNombre())) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxNombre(String dato) {
  		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
         }
         int[] temp = new int[x.length];
         j = 0;

         for (i = 0; i < x.length; i++) {
             if (dato.equals(x[i].getNombre())){
                 temp[j] = i;
                 j=j+1;
             }
         }
         if (j == 0) {
             return new int[0];
         }
         
         int[] result = new int[j];
         for (i = 0; i < j; i++) {
             result[i] = temp[i]; 
         }
         return result;
  	}
  	
  	
  	public VectorAlumno buscarAlumnoxEdad(Alumno a[], int dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato == a[i].getEdad()){
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
	}
  	public int[] buscarPosAlumnoxEdad(Alumno a[], int dato) {
  		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato == a[i].getEdad()){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	public VectorAlumno buscarAlumnoxEdad(int dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato == x[i].getEdad()){
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxEdad(int dato) {
  		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
         }
         int[] temp = new int[x.length];
         j = 0;

         for (i = 0; i < x.length; i++) {
             if (dato == x[i].getEdad()){
                 temp[j] = i;
                 j=j+1;
             }
         }
         if (j == 0) {
             return new int[0];
         }
         
         int[] result = new int[j];
         for (i = 0; i < j; i++) {
             result[i] = temp[i]; 
         }
         return result;
  	}
  	
  	
  	public VectorAlumno buscarAlumnoxSexo(Alumno a[], String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(a[i].getSexo())) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxSexo(Alumno a[], String dato) {
  		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato.equals(a[i].getSexo())){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
  	}
  	public VectorAlumno buscarAlumnoxSexo(String dato) {
  		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato.equals(x[i].getSexo())) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
  	}
  	public int[] buscarPosAlumnoxSexo(String dato) {
  		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
         }
         int[] temp = new int[x.length];
         j = 0;

         for (i = 0; i < x.length; i++) {
             if (dato.equals(x[i].getSexo())){
                 temp[j] = i;
                 j=j+1;
             }
         }
         if (j == 0) {
             return new int[0];
         }
         
         int[] result = new int[j];
         for (i = 0; i < j; i++) {
             result[i] = temp[i]; 
         }
         return result;
  	}
	
 
  	public Alumno buscarAlumnoxCod(Alumno a[], int dato) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx) {
  				if(dato == a[i].getCod()) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
	}
	public int buscarPosAlumnoxCod(Alumno a[], int dato) {
		int dx,i,pos;
  		boolean hallado;
  		hallado = false;
  		dx = a.length;
  		pos=-1;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx && !hallado) {
  				if(dato == a[i].getCod()){
  					pos=i;
  					hallado=true;
  				}
  			}		
  		}
  		return pos;
	}
	public Alumno buscarAlumnoxCod(int dato) {
		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx) {
  				if(dato == x[i].getCod()) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
	}
	public int buscarPosAlumnoxCod(int dato) {
		int dx,i,pos;
  		boolean hallado;
  		hallado = false;
  		dx = x.length;
  		pos=-1;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			i=0;
  			while(i<dx && !hallado) {
  				if(dato == x[i].getCod()){
  					pos=i;
  					hallado=true;
  				}
  			}		
  		}
  		return pos;
	}
	

	public VectorAlumno buscarAlumnoxNota(Alumno a[], double dato) {
		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato ==a[i].getNota()) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
	}
	public int[] buscarPosAlumnoxNota(Alumno a[], double dato) {
		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato == a[i].getNota()){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
	}
	public VectorAlumno buscarAlumnoxNota(double dato) {
		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato == x[i].getNota()) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
	}
	public int[] buscarPosAlumnoxNota(double dato) {
		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[x.length];
  		j = 0;
  		for (i = 0; i < x.length; i++) {
  			if (dato == x[i].getNota()){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
	}
	
	
	public VectorAlumno buscarAlumnoxEstado(Alumno a[], boolean dato) {
		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato == a[i].getEstado()) {
  					result.agregarAlumno(a[i]);
  				}
  			}		
  		}
  		return result;
	}
	public int[] buscarPosAlumnoxEstado(Alumno a[], boolean dato) {
		int i,j; 
  		if (a == null || a.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[a.length];
  		j = 0;
  		for (i = 0; i < a.length; i++) {
  			if (dato == a[i].getEstado()){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
	}
	public VectorAlumno buscarAlumnoxEstado(boolean dato) {
		int dx,i;
  		VectorAlumno result = new VectorAlumno();
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(dato == x[i].getEstado()) {
  					result.agregarAlumno(x[i]);
  				}
  			}		
  		}
  		return result;
	}
	public int[] buscarPosAlumnoxEstado(boolean dato) {
		int i,j; 
  		if (x == null || x.length == 0) {
             System.out.println("Vector vacío");
             return new int[0];
  		}
  		int[] temp = new int[x.length];
  		j = 0;
  		for (i = 0; i < x.length; i++) {
  			if (dato == x[i].getEstado()){
  				temp[j] = i;
  				j=j+1;
  			}
  		}
  		if (j == 0) {
  			return new int[0];
  		} 
  		int[] result = new int[j];
  		for (i = 0; i < j; i++) {
  			result[i] = temp[i]; 
  		}
  		return result;
	}
	
	//Eliminar alumno
	public Alumno[] eliminarAlumnoxPos(Alumno a[], int pos) {
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
	public void redimensionar(int nl) {
	    Alumno[] nuevoArray = new Alumno[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	//Editar alumno
	public Alumno editarAlumno(Alumno edit) {
		int op,opc;
		String dni = "DNI ";
		String apat = "Apell pat. ";
		String amat = "Apell mat. ";
		String nom = "Nombre ";
		String edad = "Edad ";
		String sex = "Sexo ";
		String cod = "Codigo ";
		String not = "Nota ";
		String est = "Estado ";
		Alumno temp;
		int vcod,vedad;
		String vdni,vapat,vamat,vnom,vsexo;
		double vnota;
		boolean vestado;
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
			System.out.printf("\t1. %-16s: %d\n",cod,temp.getCod());
			System.out.printf("\t2. %-16s: %s\n",not,temp.getNota());
			System.out.printf("\t3. %-16s: %s\n\n",est,temp.getEstado());
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
					System.out.printf("\nNUEVO codigo ---> ");
					vcod= Leer.datoInt();
					temp.setCod(vcod);
					break;
				case 8:
					System.out.printf("\nNUEVA nota ---> ");
					vnota= Leer.datoDouble();
					temp.setNota(vnota);
					break;
				case 9:
					System.out.printf("\nNUEVO estado ---> ");
					vestado= Leer.datoBoolean();
					temp.setEstado(vestado);
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
	
	public int getDimension() {
		return this.x.length;
	}
}