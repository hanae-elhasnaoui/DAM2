package com.BDFireStore.Empresa;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class AppModificarDatos {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {

        Firestore db = FirebaseConnection.getDatabase();

        CollectionReference empresas = db.collection("empresas");
        DocumentReference empresa = empresas.document("empresa_1");

        insertarDepartamento(empresa);
        insertarEmpleado(empresa);
        modificarGil(empresa);
        eliminarEmpleadosMadrid(empresa);
        eliminarMayorSalarioContabilidad(empresa);
    }

    // 1. Insertar el departamento INFORMÁTICA en Bilbao.
    public static void insertarDepartamento(DocumentReference empresa)
            throws InterruptedException, ExecutionException {

        CollectionReference departamentos =
                empresa.collection("departamentos");

        DocumentReference departamento = departamentos.document("50");

        Map<String, Object> datos = new HashMap<>();
        datos.put("dpto_nom", "INFORMÁTICA");
        datos.put("dpto_loc", "Bilbao");

        departamento.set(datos).get();

        System.out.println("Departamento INFORMÁTICA insertado.");
    }

    // 2. Insertar un DIRECTOR en el departamento 50.
    public static void insertarEmpleado(DocumentReference empresa)
            throws InterruptedException, ExecutionException {

        CollectionReference empleados = empresa.collection("empleados");
        DocumentReference empleado = empleados.document("8000");

        Map<String, Object> datos = new HashMap<>();
        datos.put("emple_ap1", "NUEVO");
        datos.put("oficio", "DIRECTOR");
        datos.put("dir", null);
        datos.put("fecha_alt", LocalDate.now().toString());
        datos.put("salario", 2300.0);
        datos.put("comision", 1000.0);
        datos.put("dpto_num", 50);

        empleado.set(datos).get();

        System.out.println("Empleado DIRECTOR de INFORMÁTICA insertado.");
    }

    // 3. Modificar el salario y la fecha de alta de GIL.
    public static void modificarGil(DocumentReference empresa)
            throws InterruptedException, ExecutionException {

        CollectionReference empleados = empresa.collection("empleados");

        QuerySnapshot resultado = empleados
                .whereEqualTo("emple_ap1", "GIL")
                .get()
                .get();

        Map<String, Object> cambios = new HashMap<>();
        cambios.put("salario", 1300.0);
        cambios.put("fecha_alt", LocalDate.now().minusDays(1).toString());

        for (QueryDocumentSnapshot doc : resultado.getDocuments()) {

            DocumentReference empleado = doc.getReference();
            empleado.update(cambios).get();

            System.out.println("GIL modificado: " + doc.getId());
        }

        if (resultado.isEmpty()) {
            System.out.println("No se ha encontrado a GIL.");
        }
    }

    // 4. Eliminar los empleados de los departamentos situados en MADRID.
    public static void eliminarEmpleadosMadrid(DocumentReference empresa)
            throws InterruptedException, ExecutionException {

        CollectionReference departamentos =
                empresa.collection("departamentos");

        CollectionReference empleados = empresa.collection("empleados");

        QuerySnapshot resultadoDepartamentos = departamentos
                .whereEqualTo("dpto_loc", "MADRID")
                .get()
                .get();

        for (QueryDocumentSnapshot dep : resultadoDepartamentos.getDocuments()) {

            Long numeroDepartamento = Long.valueOf(dep.getId());

            QuerySnapshot resultadoEmpleados = empleados
                    .whereEqualTo("dpto_num", numeroDepartamento)
                    .get()
                    .get();

            for (QueryDocumentSnapshot emp : resultadoEmpleados.getDocuments()) {

                DocumentReference empleado = emp.getReference();
                empleado.delete().get();

                System.out.println(
                        "Empleado de MADRID eliminado: " + emp.getId());
            }
        }
    }

    // 5. Eliminar UN empleado con el mayor salario de CONTABILIDAD.
    public static void eliminarMayorSalarioContabilidad(
            DocumentReference empresa)
            throws InterruptedException, ExecutionException {

        CollectionReference departamentos =
                empresa.collection("departamentos");

        CollectionReference empleados = empresa.collection("empleados");

        QuerySnapshot resultadoDepartamentos = departamentos
                .whereEqualTo("dpto_nom", "CONTABILIDAD")
                .get()
                .get();

        QueryDocumentSnapshot empleadoMayorSalario = null;

        for (QueryDocumentSnapshot dep : resultadoDepartamentos.getDocuments()) {

            Long numeroDepartamento = Long.valueOf(dep.getId());

            QuerySnapshot resultadoEmpleados = empleados
                    .whereEqualTo("dpto_num", numeroDepartamento)
                    .get()
                    .get();

            for (QueryDocumentSnapshot emp : resultadoEmpleados.getDocuments()) {

                Double salario = emp.getDouble("salario");

                if (salario != null) {
                    if (empleadoMayorSalario == null
                            || salario > empleadoMayorSalario.getDouble("salario")) {

                        empleadoMayorSalario = emp;
                    }
                }
            }
        }

        if (empleadoMayorSalario != null) {

            DocumentReference empleado = empleadoMayorSalario.getReference();
            empleado.delete().get();

            System.out.println(
                    "Empleado de CONTABILIDAD eliminado: "
                    + empleadoMayorSalario.getString("emple_ap1")
                    + ", salario: "
                    + empleadoMayorSalario.getDouble("salario"));
        } else {
            System.out.println(
                    "No hay empleados con salario en CONTABILIDAD.");
        }
    }
}