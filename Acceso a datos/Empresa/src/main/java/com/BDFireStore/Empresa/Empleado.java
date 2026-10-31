package com.BDFireStore.Empresa;

public class Empleado {
	private String emple_ap1;
	private String oficio;
	private Long dir; 
	private String fecha_alt;
	private Double salario; 
	private Double comision;
	private Long dpto_num;

	public Empleado() {
	}

	public String getEmple_ap1() {
		return emple_ap1;
	}

	public void setEmple_ap1(String emple_ap1) {
		this.emple_ap1 = emple_ap1;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Long getDir() {
		return dir;
	}

	public void setDir(Long dir) {
		this.dir = dir;
	}

	public String getFecha_alt() {
		return fecha_alt;
	}

	public void setFecha_alt(String fecha_alt) {
		this.fecha_alt = fecha_alt;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public Long getDpto_num() {
		return dpto_num;
	}

	public void setDpto_num(Long dpto_num) {
		this.dpto_num = dpto_num;
	}
	
	@Override
	public String toString() {
	    return "Empleado [emple_ap1=" + emple_ap1
	            + ", oficio=" + oficio
	            + ", dir=" + dir
	            + ", fecha_alt=" + fecha_alt
	            + ", salario=" + salario
	            + ", comision=" + comision
	            + ", dpto_num=" + dpto_num + "]";
	}
}

