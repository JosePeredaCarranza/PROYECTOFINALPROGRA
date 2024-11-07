/**
* nombreClase : Alumno.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 18-10-2024
* @version 1
*/
package Clases.Progra2;

public class Alumno extends Persona{
	private int cod;
	private double nota;
	private boolean estado;
	
	public Alumno(){
		super();
	}
	public Alumno(String dni,String apat,String amat,String nombre,int edad,String sexo,int vcod, double vnota, boolean vestado) {
		super(dni,apat,amat,nombre,edad,sexo);
		cod=vcod;
		nota=vnota;
		estado = vestado;
	}
	public void setCod(int vcod){
		cod=vcod;
	}
	public void setNota(double vnota){
		nota=vnota;
	}
	public void setEstado(boolean vestado){
		estado = vestado;
	}
	
	public int getCod(){
		return cod;
	}
	public double getNota(){
		return nota;
	}
	public boolean getEstado(){
		return estado;
	}
	public Persona leerPersona(){
		super.leerPersona();
		int vcodigo;
		double vnota;
		boolean vestado;
		System.out.print("Codigo      : ");
		vcodigo=Leer.datoInt();
		setCod(vcodigo);
		System.out.print("Nota        : ");
		vnota=Leer.datoDouble();
		setNota(vnota);
		System.out.print("Estado      : ");
		vestado=Leer.datoBoolean();
		setEstado(vestado);
		return (this);
	}
	public void escribirPersona(){
		super.escribirPersona();
   		System.out.printf("%6d %10.1f %14b\n",cod,nota,estado);
    }
	public void escribirPersona(Alumno a){
		super.escribirPersona(a);
		System.out.printf("%6d %10.1f %14b\n",a.getCod(),a.getNota(),a.getEstado());
    }

	public void mostrarPersona(){
		super.mostrarPersona();
		System.out.println("Codigo     : " + cod);
		System.out.println("Nota       : " + nota);
		System.out.println("Estado     : " + estado);
	}
	public void mostrarPersona(Alumno a){
		super.mostrarPersona(a);
		System.out.println("Codigo     : " + a.getCod());
		System.out.println("Nota       : " + a.getNota());
		System.out.println("Estado     : " + a.getEstado());
	}
	public String toString(){
		String cad=null;
		String superclase = super.toString();
		cad=String.format("%s %6d %10.1f %14b\n",superclase,cod,nota,estado);
		return(cad);
	}
}
