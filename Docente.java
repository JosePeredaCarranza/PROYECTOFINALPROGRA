/**
* nombreClase : Docente.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 18-10-2024
* @version 3
*/
package Clases.Progra2;

public class Docente extends Persona{
	private int id;
	private VectorCurso cursos;
	private int maxcursos;
	private int cantcursos;
	
	public Docente(){
		super();
	}
	public Docente(String dni,String apat,String amat,String nombre,int edad,String sexo,int vid, VectorCurso vcursos) {
		super(dni,apat,amat,nombre,edad,sexo);
		id = vid;
		cursos = vcursos;
	}
	public void asignaCurso(Curso c) {
        if (!tieneCurso(c)) {
            if (cantcursos == maxcursos) {
                System.out.println("El docente " + this.getNombre() + " No puede tener más cursos...");
            } else {
                cursos.agregarCurso(c);
                cantcursos++;
            }
        }
    }
    public boolean tieneCurso(Curso c) {
    	if (cursos.buscarCursoxAsignatura(c.getNombre())) {
    		return true;
    	}
    	return false;
    }
        
	public void setId(int vcod){
		id = vcod;
	}
	public int getId(){
		return id;
	}
	public int getCantCursos(){
		return cantcursos;
	}
	public Persona leerPersona(){
		super.leerPersona();
		int vid;
		System.out.print("Id          : ");
		vid=Leer.datoInt();
		setId(vid);
		return this;
	}
	public void escribirPersona(){
		super.escribirPersona();
		System.out.printf("%5d %-20s\n",id);
	}

	public void escribirPersona(Docente a){
		super.escribirPersona();
		System.out.printf("%5d %-20s %5d\n",a.getId());
	}
	public void mostrarPersona(){
		super.mostrarPersona();
		System.out.println("Id          : " + id);
	}
	public void mostrarPersona(Docente a){
		super.mostrarPersona();
		System.out.println("Id          : " + a.getId());
	}
	public String toString(){
		String cad=null;
		String superclase = super.toString();
		cad=String.format(" %s %5d %-20s %5d\n",superclase,id);
		return(cad);
	}	
}
