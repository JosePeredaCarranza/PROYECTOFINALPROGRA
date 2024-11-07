/**
* nombreClase : VectorAdministrativo.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 28-09-2024
* @version 2
*/
package Clases.Progra2;

public class VectorAdministrativo {
	private Administrativo x[];

	public VectorAdministrativo() {
		x = new Administrativo[0];
	}
	public VectorAdministrativo(Administrativo va[]){
		x = va;
	}
	public void agregarAdministrativo(){
		int i;
		i = x.length;
		Administrativo a = new Administrativo();
		redimensionar1();
		a.leerPersona();
		x[i] = a;
	}
	public void agregarAdministrativo(Administrativo a){
		int i;
		i = x.length;
		redimensionar1();
		x[i] = a;
	}

	public Administrativo[] leerVector(){
		int i,n;
		System.out.print("Numero de Administrativo para el vector ---> ");
		n = Leer.datoInt();
		Administrativo v[]=new Administrativo[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Administrativo "+(i+1)+": ");
			Administrativo a = new Administrativo();
			a.leerPersona();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Administrativo dato, int posi){
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
		Administrativo y[]=new Administrativo[n];
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

	public void mostrarVector(Administrativo v[]){
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
		String t1="RELACION DE ADMINISTRATIVOS";
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
		String s9="Area";
		String s10="Sueldo";
		raya2();
		System.out.printf("%5s %8s %9s %10s %7s %9s %3s %12s %12s %15s\n",s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %6s %-15s %10.2f\n", i + 1, x[i].getCodAdm(), x[i].getArea(), x[i].getPago());
			i=i+1;
		}
		return(cad);
	} 
	
	public static void quickSort(Administrativo[] arr, int low, int high,int opc) {
		if(arr.length > 0) {
			if (low < high) {
		    	  int pi = 0;
		    	  switch(opc) {
		      		case 1:
		      			pi = ordenarPorDNI(arr, low, high);
		      			break;
		      		case 2:
		      			pi = ordenarPorAPaterno(arr, low, high);
		      			break;
		      		case 3:
		      			pi = ordenarPorAMaterno(arr, low, high);
		    			break;
		      		case 4:
		      			pi = ordenarPorNombre(arr, low, high);
		     			break;
		      		case 5:
		      			pi = ordenarPorEdad(arr, low, high);
		      			break;
		      		case 6:
		      			pi = ordenarPorSexo(arr, low, high);
		      			break;
		      		case 7:
		      			pi = ordenarPorCodigo(arr, low, high);
		      			break;
		      		case 8:
		      			pi = ordenarPorArea(arr, low, high);
		      			break;
		      		case 9:
		      			pi = ordenarPorPago(arr, low, high);
		      			break;
		    	  }
		    	  quickSort(arr, low, pi - 1,opc);
		    	  quickSort(arr, pi + 1, high,opc);
		      }else
		    	  System.out.println("Vector ordenado...");
			
		}else
			System.out.println("Vector vacio...");
			
			
	}
		private static int ordenarPorDNI(Administrativo []arr,int low,int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			for (int j = low; j < high; j++) {
				if (arr[j].getDni().compareTo(pivot.getDni()) <= 0) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;

			return i + 1;
		}
		private static int ordenarPorAPaterno(Administrativo []arr,int low,int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			
			for (int j = low; j < high; j++) {
				if (arr[j].getApat().compareTo(pivot.getApat()) <= 0) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			
			return i + 1;
		}
		private static int ordenarPorAMaterno(Administrativo []arr,int low,int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			
			for (int j = low; j < high; j++) {
				if (arr[j].getAmat().compareTo(pivot.getAmat()) <= 0) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			
			return i + 1;
		}
		private static int ordenarPorNombre(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;

			for (int j = low; j < high; j++) {
				if (arr[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;

			return i + 1;
	  }
		private static int ordenarPorEdad(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			
			for (int j = low; j < high; j++) {
				if (arr[j].getEdad() < pivot.getEdad()) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			
			return i + 1;
		}
		private static int ordenarPorSexo(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;

			for (int j = low; j < high; j++) {
		         if (arr[j].getSexo().compareTo(pivot.getSexo()) <= 0) {
		             i++;
		             Administrativo temp = arr[i];
		             arr[i] = arr[j];
	              arr[j] = temp;
	          }
			}
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			return i + 1;
		}
		private static int ordenarPorCodigo(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;  
			for (int j = low; j < high; j++) {
				if (arr[j].getCodAdm() < pivot.getCodAdm()) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}  
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;

			return i + 1;
		}
		private static int ordenarPorArea(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			  
			  for (int j = low; j < high; j++) {
				  if (arr[j].getArea().compareTo(pivot.getArea()) <= 0) {
					  i++;
					  Administrativo temp = arr[i];
					  arr[i] = arr[j];
					  arr[j] = temp;
				  }
			  }
			  
			  Administrativo temp = arr[i + 1];
			  arr[i + 1] = arr[high];
			  arr[high] = temp;
			  
			  return i + 1;
		  }
		private static int ordenarPorPago(Administrativo[] arr, int low, int high) {
			Administrativo pivot = arr[high];
			int i = low - 1;
			  
			for (int j = low; j < high; j++) {
				if (arr[j].getPago() == pivot.getPago()) {
					i++;
					Administrativo temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			Administrativo temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			return i + 1;
		}
		
		public void quickSort(int low, int high, int opc) {
			if(this.legth > 0) {
				if (low < high) {
					int pi = 0;
					switch (opc) {
						case 1:
							pi = ordenarPorDNI( low, high);
			    			break;
			    		case 2:
			    			pi = ordenarPorAPaterno( low, high);
			    			break;
			    		case 3:
			    			pi = ordenarPorAMaterno( low, high);
			    			break;
			    		case 4:
			    			pi = ordenarPorNombre( low, high);
			    			break;
			    		case 5:
			    			pi = ordenarPorEdad( low, high);
			    			break;
			    		case 6:
			    			pi = ordenarPorSexo( low, high);
			    			break;
			    		case 7:
			    			pi = ordenarPorCodigo( low, high);
			    			break;
			    		case 8:
			    			pi = ordenarPorArea( low, high);
			    			break;
			    		case 9:
			    			pi = ordenarPorPago( low, high);
			    			break;
					}
					quickSort(low, pi - 1, opc);
					quickSort(pi + 1, high, opc);
				}else
					System.out.println("Vector ordenado...");
			}else
				System.out.println("Vector vacio");
			
		}
		private int ordenarPorDNI(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorAPaterno(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorAMaterno(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorNombre(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorEdad(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorSexo(int low, int high) {
			Administrativo pivot = x[high];
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
		private int ordenarPorCodigo(int low, int high) {
			Administrativo pivot = x[high];
			int i = low - 1;
			for (int j = low; j < high; j++) {
				if (x[j].getCodAdm() < pivot.getCodAdm()) {
					i++;
					swap(i, j);
				}
			}
			swap(i + 1, high);
			return i + 1;
		}
		private int ordenarPorArea(int low, int high) {
			Administrativo pivot = x[high];
			int i = low - 1;

			for (int j = low; j < high; j++) {
				if (x[j].getArea().compareTo(pivot.getArea()) <= 0) {
					i++;
					swap(i, j);
				}
			}
			swap(i + 1, high);
			return i + 1;
		}
	  	private int ordenarPorPago(int low, int high) {
	  		Administrativo pivot = x[high];
	  		int i = low - 1;

	  		for (int j = low; j < high; j++) {
	  			if (x[j].getPago() == pivot.getPago()) {
	  				i++;
	  				swap(i, j);
	  			}
	  		}
	  		swap(i + 1, high);
	  		return i + 1;
	  	}

	  	private void swap(int i, int j) {
	  		Administrativo temp = x[i];
	  		x[i] = x[j];
	  		x[j] = temp;
	  	}
	  	//Buscar Administrativo
	  	public Administrativo buscarAdministrativoxDNI(String dato) {
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
	  	public int buscarPosAdministrativoxDNI(String dato) {
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
	  	public Administrativo buscarAlumnoxDNI(Administrativo a[], String dato) {
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
	  	public int buscarPosAlumnoxDNI(Administrativo a[], String dato) {
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
	  	
	  	
	  	public VectorAdministrativo buscarAlumnoxAPaterno(String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(x[i].getApat())) {
	  					result.agregarAdministrativo(x[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxAPaterno(String dato) {
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
	  	public VectorAdministrativo buscarAdministrativoxAMaterno(String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(x[i].getAmat())) {
	  					result.agregarAdministrativo(x[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxAMaterno(String dato) {
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
	  	
	  	
	  	public VectorAdministrativo buscarAdministrativoxAPaterno(Administrativo a[], String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(a[i].getApat())) {
	  					result.agregarAdministrativo(a[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxAPaterno(Administrativo a[], String dato) {
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
	  	public VectorAdministrativo buscarAlumnoxAMaterno(Administrativo a[], String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = a.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(a[i].getAmat())) {
	  					result.agregarAdministrativo(a[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxAMaterno(Administrativo a[], String dato) {
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
	  	
	  	
	  	public VectorAdministrativo buscarAdministrativoxNombre(Administrativo a[], String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = a.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(a[i].getNombre())) {
	  					result.agregarAdministrativo(a[i]);
	  				}
	  			}		
	  		}
	  		return result;
		}	
	  	public int[] buscarPosAdministrativoxNombre(Administrativo a[], String dato) {
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
	  	public VectorAdministrativo buscarAdministrativoxNombre(String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(x[i].getNombre())) {
	  					result.agregarAdministrativo(x[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxNombre(String dato) {
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
	  	
	  	
	  	public VectorAdministrativo buscarAdministrativoxEdad(Administrativo a[], int dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = a.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato == a[i].getEdad()){
	  					result.agregarAdministrativo(a[i]);
	  				}
	  			}		
	  		}
	  		return result;
		}
	  	public int[] buscarPosAdministrativoxEdad(Administrativo a[], int dato) {
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
	  	public VectorAdministrativo buscarAdministrativoxEdad(int dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato == x[i].getEdad()){
	  					result.agregarAdministrativo(x[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxEdad(int dato) {
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
	  	
	  	
	  	public VectorAdministrativo buscarAdministrativoxSexo(Administrativo a[], String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = a.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(a[i].getSexo())) {
	  					result.agregarAdministrativo(a[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxSexo(Administrativo a[], String dato) {
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
	  	public VectorAdministrativo buscarAdministrativoxSexo(String dato) {
	  		int dx,i;
	  		VectorAdministrativo result = new VectorAdministrativo();
	  		dx = x.length;
	  		if(dx == 0 ) {
	  			System.out.println("Vector vacio");
	  		}
	  		else {
	  			for(i = 0 ; i < dx ;i++) {
	  				if(dato.equals(x[i].getSexo())) {
	  					result.agregarAdministrativo(x[i]);
	  				}
	  			}		
	  		}
	  		return result;
	  	}
	  	public int[] buscarPosAdministrativoxSexo(String dato) {
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


	  //Eliminar alumno
		public Administrativo[] eliminarAdministrativoxPos(Administrativo a[], int pos) {
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
			Administrativo[] nuevoArray = new Administrativo[nl];
		    for (int i = 0; i < nl; i++) {
		        nuevoArray[i] = x[i];
		    }
		    x = nuevoArray;
		}
		//Editar Administrativo
		public Administrativo editarAlumno(Administrativo edit) {
			int op,opc;
			String dni = "DNI ";
			String apat = "Apell pat. ";
			String amat = "Apell mat. ";
			String nom = "Nombre ";
			String edad = "Edad ";
			String sex = "Sexo ";
			String cod = "Codigo ";
			String area = "Area ";
			String pago = "Pago ";
			Administrativo temp;
			int vcod,vedad;
			String vdni,vapat,vamat,vnom,vsexo,varea;
			float vpago;
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
				System.out.printf("\t1. %-16s: %d\n",cod,temp.getCodAdm());
				System.out.printf("\t2. %-16s: %s\n",area,temp.getArea());
				System.out.printf("\t3. %-16s: %s\n\n",pago,temp.getPago());
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
						temp.setCodAdm(vcod);
						break;
					case 8:
						System.out.printf("\nNUEVA area ---> ");
						varea= Leer.dato();
						temp.setArea(varea);
						break;
					case 9:
						System.out.printf("\nNUEVO pago ---> ");
						vpago= Leer.datoFloat();
						temp.setPago(vpago);
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
