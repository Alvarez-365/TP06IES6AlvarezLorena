package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;

public class alumno {
	private String nombre;
	private String apellido;
	private String direccionBarrio;
	private String direccionCalle;
	private Integer direccionNumero;
	private String direccionCiudad;
	private String direccionCP;
	private LocalDate fechaNacimiento;
	private String DNI;
	private String correo;
	private String telefono;
	private boolean estado;

public alumno() {
	// TODO Auto-generated constructor stub
	}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getDireccionBarrio() {
	return direccionBarrio;
}

public void setDireccionBarrio(String direccionBarrio) {
	this.direccionBarrio = direccionBarrio;
}

public String getDireccionCalle() {
	return direccionCalle;
}

public void setDireccionCalle(String direccionCalle) {
	this.direccionCalle = direccionCalle;
}

public Integer getDireccionNumero() {
	return direccionNumero;
}

public void setDireccionNumero(Integer direccionNumero) {
	this.direccionNumero = direccionNumero;
}

public String getDireccionCiudad() {
	return direccionCiudad;
}

public void setDireccionCiudad(String direccionCiudad) {
	this.direccionCiudad = direccionCiudad;
}

public String getDireccionCP() {
	return direccionCP;
}

public void setDireccionCP(String direccionCP) {
	this.direccionCP = direccionCP;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}

public String getDNI() {
	return DNI;
}

public void setDNI(String dNI) { 
	DNI = dNI;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}
 
public Integer getEdad() {
	// TODO calculo Edad
	int edad = 0;
	LocalDate fechaActual= LocalDate.now();
	Period periodo= Period.between(fechaNacimiento, fechaActual);
	edad= periodo.getYears();
	return edad;
}

}

