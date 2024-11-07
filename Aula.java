/**
* nombreClase: Aula.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 10 set. 2024
* @version 2
*/
package Clases.Progra2;

public class Aula {
	private int capacidad;
	private String tequipo;
	private String pabellon;
	private boolean disponible;
	public Aula(){
	}
	public Aula(int capacidad){
		this.capacidad = capacidad;
		tequipo = null;
		pabellon = null;
		disponible = true;
	}
	public Aula(int capacidad, String tequipo){
		this.capacidad = capacidad;
		this.tequipo = tequipo;
		pabellon = null;
		disponible = true;
	}
	public Aula(int capacidad, String tequipo, String pabellon){
		this.capacidad = capacidad;
		this.tequipo = tequipo;
		this.pabellon = pabellon;
		disponible = true;
	}
	public Aula(int capacidad, String tequipo, String pabellon, boolean disponible){
		this.capacidad = capacidad;
		this.tequipo = tequipo;
		this.pabellon = pabellon;
		this.disponible = disponible;
	}
	//Setters
	public void setCapacidad(int capacidad){
		this.capacidad = capacidad;
	}
	public void setTequipo(String tequipo){
   	this.tequipo = tequipo;
   }
	public void setPabellon(String pabellon){
	   this.pabellon = pabellon;
	}
	public void setDisponible(boolean disponible){
	   this.disponible = disponible;
	}
	//Getters
	public int getCapacidad(){
		return capacidad;
	}
	public String getTequipo(){
		return tequipo;
	}
	public String getPabellon(){
		return pabellon;
	}
	public boolean getDisponible(){
		return disponible;
	}
	
	public Aula leerAula(){
		int capacidad;
		String tequipo;
		String pabellon;
		boolean disponible;
		Aula a=new Aula();
		System.out.print("Capacidad ---> ");
		capacidad=Leer.datoInt();
		a.setCapacidad(capacidad);

		System.out.print("Tipo de equipo ---> ");
		tequipo=Leer.dato();
		a.setTequipo(tequipo);

		System.out.print("Pabellon   ---> ");
		pabellon=Leer.dato();
		a.setPabellon(pabellon);
		
		System.out.print("Disponible   ---> ");
		disponible = Leer.datoBoolean();
		a.setDisponible(disponible);
		return a;
	}
	
	public void mostrarAula(){
	   System.out.printf("%6d %-15s%10s%b\n",capacidad,tequipo,pabellon,disponible);
	}
	public void mostrarAula(Aula x){
	   System.out.println(x.toString());
	}
	@Override
	public String toString(){
		String cad=null;
	   cad=String.format("%6d %-15s%10s%b\n",capacidad,tequipo,pabellon,disponible);
	   return(cad);
	}
}
	

