package com.BDFireStore.Empresa;

import java.util.ArrayList;

public class Departamento {
	private String dpto_nom;
	private String dpto_loc;
	private Long dpto_num; // Este lo extraeremos del ID del documento
	private ArrayList<Empleado> listaEmpleados = new ArrayList<>(); // Para el Requisito 2

	public Departamento() {
	}

	public String getDpto_nom() {
		return dpto_nom;
	}

	public void setDpto_nom(String dpto_nom) {
		this.dpto_nom = dpto_nom;
	}

	public String getDpto_loc() {
		return dpto_loc;
	}

	public void setDpto_loc(String dpto_loc) {
		this.dpto_loc = dpto_loc;
	}

	public Long getDpto_num() {
		return dpto_num;
	}

	public void setDpto_num(Long dpto_num) {
		this.dpto_num = dpto_num;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void agregarEmpleado(Empleado emp) {
		this.listaEmpleados.add(emp);
	}

	@Override
	public String toString() {
		return "Departamento [dpto_nom=" + dpto_nom + ", dpto_loc=" + dpto_loc + ", dpto_num=" + dpto_num + "]";
	}
}
