package com.BDFireStore.Empresa;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class AppConsultarDatos {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Firestore db = FirebaseConnection.getDatabase();

		CollectionReference empresas = db.collection("empresas");
		DocumentReference empresa = empresas.document("empresa_1");

		System.out.println("=== 1. RECORRIDO ===");
		recorrido(empresa);

		System.out.println("\n=== 2. RECORRIDO EN CLASES ===");

		ArrayList<Departamento> listaDepartamentos = obtenerDepartamentos(empresa);

		mostrarDepartamentos(listaDepartamentos);
	}

	// Apartado 1: mostrar los documentos directamente.
	public static void recorrido(DocumentReference empresa) throws InterruptedException, ExecutionException {

		CollectionReference departamentosRef = empresa.collection("departamentos");

		CollectionReference empleadosRef = empresa.collection("empleados");

		QuerySnapshot departamentos = departamentosRef.get().get();

		for (QueryDocumentSnapshot doc : departamentos.getDocuments()) {

			Long numeroDepartamento = Long.valueOf(doc.getId());

			System.out.println("Departamento " + numeroDepartamento + ": " + doc.getData());

			QuerySnapshot empleados = empleadosRef.whereEqualTo("dpto_num", numeroDepartamento).get().get();

			for (QueryDocumentSnapshot emp : empleados.getDocuments()) {
				System.out.println("  Empleado " + emp.getId() + ": " + emp.getData());
			}

			if (empleados.isEmpty()) {
				System.out.println("  Sin empleados.");
			}
		}
	}

	// Apartado 2: crear los objetos y sus ArrayList.
	public static ArrayList<Departamento> obtenerDepartamentos(DocumentReference empresa)
			throws InterruptedException, ExecutionException {

		CollectionReference departamentosRef = empresa.collection("departamentos");

		CollectionReference empleadosRef = empresa.collection("empleados");

		QuerySnapshot departamentos = departamentosRef.get().get();

		ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

		for (QueryDocumentSnapshot doc : departamentos.getDocuments()) {

			Departamento departamento = new Departamento();

			departamento.setDpto_num(Long.valueOf(doc.getId()));
			departamento.setDpto_nom(doc.getString("dpto_nom"));
			departamento.setDpto_loc(doc.getString("dpto_loc"));

			QuerySnapshot empleados = empleadosRef.whereEqualTo("dpto_num", departamento.getDpto_num()).get().get();

			ArrayList<Empleado> listaEmpleados = new ArrayList<>();

			for (QueryDocumentSnapshot emp : empleados.getDocuments()) {

				Empleado empleado = new Empleado();

				empleado.setEmple_ap1(emp.getString("emple_ap1"));
				empleado.setOficio(emp.getString("oficio"));
				empleado.setDir(emp.getLong("dir"));
				empleado.setFecha_alt(emp.getString("fecha_alt"));
				empleado.setSalario(emp.getDouble("salario"));
				empleado.setComision(emp.getDouble("comision"));
				empleado.setDpto_num(emp.getLong("dpto_num"));

				listaEmpleados.add(empleado);
			}

			departamento.setListaEmpleados(listaEmpleados);
			listaDepartamentos.add(departamento);
		}

		return listaDepartamentos;
	}

	// Recorrer los objetos guardados, sin consultar Firestore.
	public static void mostrarDepartamentos(ArrayList<Departamento> listaDepartamentos) {

		for (Departamento departamento : listaDepartamentos) {

			System.out.println(departamento);

			for (Empleado empleado : departamento.getListaEmpleados()) {
				System.out.println("  " + empleado);
			}

			if (departamento.getListaEmpleados().isEmpty()) {
				System.out.println("  Sin empleados.");
			}
		}
	}
}