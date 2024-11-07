/**
* nombreClase : Persona.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 18-10-2024
* @version 1
*/
package Clases.Progra2;

public class Persona {
	protected String dni;
	protected String apat;
	protected String amat;
	protected String nombre;
	protected int edad;
	protected String sexo;

	public Persona(){
	}
	public Persona(String vdni, String vapat,String vamat, String vnom, int vedad, String vsexo){
		dni=vdni;
		apat=vapat;
		amat=vamat;
		nombre=vnom;
		edad=vedad;
		sexo=vsexo;
	}
	public void setDni(String vdni){
		dni=vdni;
	}
	public void setApat(String vapat){
		apat = vapat;
	}
	public void setAmat(String vamat){
		amat = vamat;
	}
	public void setNombre(String vnom){
		nombre = vnom;
	}
	public void setEdad(int vedad){
		edad = vedad;
	}
	public void setSexo(String vsexo){
		sexo = vsexo;
	}
	
	public String getDni(){
	  	return dni;
	}
	public String getApat(){
	  	return apat;
	}
	public String getAmat(){
	  	return amat;
	}
	public String getNombre(){
	  	return nombre;
	}
	public int getEdad(){
	  	return edad;
	}
	public String getSexo(){
	  	return sexo;
	}
	
   	public Persona leerPersona(){
		String vdni,vapat,vamat,vnom,vsexo;
		int vedad;

		System.out.print("D N I      : ");
		vdni= Leer.dato();
		setDni(vdni);
		System.out.print("A. Paterno : ");
		vapat= Leer.dato();
		setApat(vapat);
		System.out.print("A. Materno : ");
		vamat= Leer.dato();
		setAmat(vamat);
		System.out.print("Nombre     : ");
		vnom= Leer.dato();
		setNombre(vnom);
		System.out.print("Edad       : ");
		vedad= Leer.datoInt();
		setEdad(vedad);
		System.out.print("Sexo        : ");
		vsexo= Leer.dato();
		setSexo(vsexo);

		return(this);
   }
   public void escribirPersona(){
   		System.out.printf("%8s %-15s %-15s %-15s %5d %-10s ",dni,apat,amat,nombre,edad,sexo);
   }
   public void escribirPersona(Persona a){
  		System.out.printf("%8s %-15s %-15s %-15s %5d %-10s ",a.getDni(),a.getApat(),
  				a.getAmat(),a.getNombre(),a.getEdad(),a.getSexo());
   }
  
   public void mostrarPersona(){
		System.out.println("dni        : " + dni);
		System.out.println("a. paterno : " + apat);
		System.out.println("a. paterno : " + amat);
		System.out.println("nombre     : " + nombre);
		System.out.println("edad       : " + edad);
		System.out.printf("Sexo       : %s\n",sexo);
   }
   public void mostrarPersona(Persona a){
		System.out.println("dni        : " + a.getDni());
		System.out.println("a. paterno : " + a.getApat());
		System.out.println("a. paterno : " + a.getAmat());
		System.out.println("nombre     : " + a.getNombre());
		System.out.println("edad       : " + a.getEdad());
		System.out.println("Sexo       : " + a.getSexo());
  }

  public String toString(){
		String cad="";
		cad=String.format("%8s %-15s %-15s %-15s %5d %-10s",dni,apat,amat,nombre,edad,sexo);
		return cad;
  }
}
