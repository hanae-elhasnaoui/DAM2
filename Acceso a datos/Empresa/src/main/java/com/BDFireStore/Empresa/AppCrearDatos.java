package com.BDFireStore.Empresa;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

public class AppCrearDatos {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Firestore db = FirebaseConnection.getDatabase();
		
		// =========================================================================
		// PASO 1 Y 2: Crear la Colección de "empresas" y el Documento de la empresa
		// =========================================================================
		Map<String, Object> datosEmpresa = new HashMap<>();
		datosEmpresa.put("nombre_empresa", "Empresa de Prueba S.A.");
		datosEmpresa.put("ubicacion_central", "BILBAO");
		
		// Esta es la referencia al documento raíz 
		DocumentReference empresaRef = db.collection("empresas").document("empresa_1");
		empresaRef.set(datosEmpresa);
		System.out.println("¡Colección 'empresas' y documento 'empresa_1' creados!");

		// =========================================================================
		// PASO 3 Y 4: Cargar subcolecciones DENTRO del documento de la empresa
		// =========================================================================
		cargarDepartamentos(empresaRef);
		cargarEmpleados(empresaRef);
	}

	public static void cargarDepartamentos(DocumentReference empresaRef) throws InterruptedException, ExecutionException {
		// Departamento 10
		Map<String, Object> d10 = new HashMap<>();
		d10.put("dpto_nom", "CONTABILIDAD");
		d10.put("dpto_loc", "SEVILLA");
		// RUTA: empresas -> empresa_1 -> departamentos -> 10
		empresaRef.collection("departamentos").document("10").set(d10).get();

		// Departamento 20
		Map<String, Object> d20 = new HashMap<>();
		d20.put("dpto_nom", "INVESTIGACION");
		d20.put("dpto_loc", "MADRID");
		empresaRef.collection("departamentos").document("20").set(d20).get();

		// Departamento 30
		Map<String, Object> d30 = new HashMap<>();
		d30.put("dpto_nom", "VENTAS");
		d30.put("dpto_loc", "BARCELONA");
		empresaRef.collection("departamentos").document("30").set(d30).get();

		// Departamento 40
		Map<String, Object> d40 = new HashMap<>();
		d40.put("dpto_nom", "PRODUCCION");
		d40.put("dpto_loc", "BILBAO");
		empresaRef.collection("departamentos").document("40").set(d40).get();

		System.out.println("¡Todos los departamentos han sido preparados dentro de la empresa!");
	}

	public static void cargarEmpleados(DocumentReference empresaRef) throws InterruptedException, ExecutionException {

		// Empleado 7369
		Map<String, Object> e7369 = new HashMap<>();
		e7369.put("emple_ap1", "SANCHEZ");
		e7369.put("oficio", "EMPLEADO");
		e7369.put("dir", 7902);
		e7369.put("fecha_alt", "1990-12-17");
		e7369.put("salario", 1040.00);
		e7369.put("comision", null);
		e7369.put("dpto_num", 20);
		// RUTA: empresas -> empresa_1 -> empleados -> 7369
		empresaRef.collection("empleados").document("7369").set(e7369).get();

		// Empleado 7499
		Map<String, Object> e7499 = new HashMap<>();
		e7499.put("emple_ap1", "ARROYO");
		e7499.put("oficio", "VENDEDOR");
		e7499.put("dir", 7698);
		e7499.put("fecha_alt", "1990-02-20");
		e7499.put("salario", 1500.00);
		e7499.put("comision", 390.00);
		e7499.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7499").set(e7499).get();

		// Empleado 7521
		Map<String, Object> e7521 = new HashMap<>();
		e7521.put("emple_ap1", "SALA");
		e7521.put("oficio", "VENDEDOR");
		e7521.put("dir", 7698);
		e7521.put("fecha_alt", "1991-02-22");
		e7521.put("salario", 1625.00);
		e7521.put("comision", 650.00);
		e7521.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7521").set(e7521).get();

		// Empleado 7566
		Map<String, Object> e7566 = new HashMap<>();
		e7566.put("emple_ap1", "JIMENEZ");
		e7566.put("oficio", "DIRECTOR");
		e7566.put("dir", 7839);
		e7566.put("fecha_alt", "1991-04-02");
		e7566.put("salario", 2900.00);
		e7566.put("comision", null);
		e7566.put("dpto_num", 20);
		empresaRef.collection("empleados").document("7566").set(e7566).get();

		// Empleado 7654
		Map<String, Object> e7654 = new HashMap<>();
		e7654.put("emple_ap1", "MARTIN");
		e7654.put("oficio", "VENDEDOR");
		e7654.put("dir", 7698);
		e7654.put("fecha_alt", "1991-09-29");
		e7654.put("salario", 1600.00);
		e7654.put("comision", 1020.00);
		e7654.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7654").set(e7654).get();

		// Empleado 7698
		Map<String, Object> e7698 = new HashMap<>();
		e7698.put("emple_ap1", "NEGRO");
		e7698.put("oficio", "DIRECTOR");
		e7698.put("dir", 7839);
		e7698.put("fecha_alt", "1991-05-01");
		e7698.put("salario", 3005.00);
		e7698.put("comision", null);
		e7698.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7698").set(e7698).get();

		// Empleado 7782
		Map<String, Object> e7782 = new HashMap<>();
		e7782.put("emple_ap1", "CEREZO");
		e7782.put("oficio", "DIRECTOR");
		e7782.put("dir", 7839);
		e7782.put("fecha_alt", "1991-06-09");
		e7782.put("salario", 2885.00);
		e7782.put("comision", null);
		e7782.put("dpto_num", 10);
		empresaRef.collection("empleados").document("7782").set(e7782).get();

		// Empleado 7788
		Map<String, Object> e7788 = new HashMap<>();
		e7788.put("emple_ap1", "GIL");
		e7788.put("oficio", "ANALISTA");
		e7788.put("dir", 7566);
		e7788.put("fecha_alt", "1991-11-09");
		e7788.put("salario", 3000.00);
		e7788.put("comision", null);
		e7788.put("dpto_num", 20);
		empresaRef.collection("empleados").document("7788").set(e7788).get();

		// Empleado 7839
		Map<String, Object> e7839 = new HashMap<>();
		e7839.put("emple_ap1", "REY");
		e7839.put("oficio", "PRESIDENTE");
		e7839.put("dir", null);
		e7839.put("fecha_alt", "1991-11-17");
		e7839.put("salario", 4100.00);
		e7839.put("comision", null);
		e7839.put("dpto_num", 10);
		empresaRef.collection("empleados").document("7839").set(e7839).get();

		// Empleado 7844
		Map<String, Object> e7844 = new HashMap<>();
		e7844.put("emple_ap1", "TOVAR");
		e7844.put("oficio", "VENDEDOR");
		e7844.put("dir", 7698);
		e7844.put("fecha_alt", "1991-09-08");
		e7844.put("salario", 1350.00);
		e7844.put("comision", 0.00);
		e7844.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7844").set(e7844).get();

		// Empleado 7876
		Map<String, Object> e7876 = new HashMap<>();
		e7876.put("emple_ap1", "ALONSO");
		e7876.put("oficio", "EMPLEADO");
		e7876.put("dir", 7788);
		e7876.put("fecha_alt", "1991-09-23");
		e7876.put("salario", 1430.00);
		e7876.put("comision", null);
		e7876.put("dpto_num", 20);
		empresaRef.collection("empleados").document("7876").set(e7876).get();

		// Empleado 7900
		Map<String, Object> e7900 = new HashMap<>();
		e7900.put("emple_ap1", "JIMENO");
		e7900.put("oficio", "EMPLEADO");
		e7900.put("dir", 7698);
		e7900.put("fecha_alt", "1991-12-03");
		e7900.put("salario", 1335.00);
		e7900.put("comision", null);
		e7900.put("dpto_num", 30);
		empresaRef.collection("empleados").document("7900").set(e7900).get();

		// Empleado 7902
		Map<String, Object> e7902 = new HashMap<>();
		e7902.put("emple_ap1", "FERNANDEZ");
		e7902.put("oficio", "ANALISTA");
		e7902.put("dir", 7566);
		e7902.put("fecha_alt", "1991-12-03");
		e7902.put("salario", 3000.00);
		e7902.put("comision", null);
		e7902.put("dpto_num", 20);
		empresaRef.collection("empleados").document("7902").set(e7902).get();

		// Empleado 7934
		Map<String, Object> e7934 = new HashMap<>();
		e7934.put("emple_ap1", "MUÑOZ");
		e7934.put("oficio", "EMPLEADO");
		e7934.put("dir", 7782);
		e7934.put("fecha_alt", "1992-01-23");
		e7934.put("salario", 1690.00);
		e7934.put("comision", null);
		e7934.put("dpto_num", 10);
		empresaRef.collection("empleados").document("7934").set(e7934).get();

		System.out.println("¡Todos los empleados han sido preparados dentro de la empresa!");
	}
}
