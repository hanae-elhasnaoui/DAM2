package exemple;

//1. قمنا بإضافة "extends Thread" لجعل الكلاس عبارة عن Hilo
public class RatonEXTEND extends Thread { 
 private String nombre;
 private int tiempo;

 public RatonEXTEND(String nombre, int tiempo) {
     super();
     this.nombre = nombre;
     this.tiempo = tiempo;
 }

 // 2. يجب تغيير اسم الدالة 'comer' إلى 'run'. 
 // نظام تشغيل Java يبحث دائماً عن الدالة ()run لتنفيذ الـ Hilo
 @Override
 public void run() {
     try {
         System.out.printf("El Raton %s empieza a comer\n", nombre);
         Thread.sleep(tiempo * 1000); // النوم أو الانتظار
         System.out.printf("El Raton %s ha terminado de comer\n", nombre);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }

 public static void main(String[] args) {
     RatonEXTEND raton1 = new RatonEXTEND("1", 4);
     RatonEXTEND raton2 = new RatonEXTEND("2", 2);
     RatonEXTEND raton3 = new RatonEXTEND("3", 5);

     // 3. لكي يشتغلوا بالتوازي، ندمج الدالة ()start وليس ()run
     raton1.start();
     raton2.start();
     raton3.start();
     raton1.setPriority(MAX_PRIORITY);// ila madrtch prop kayakhod del padre y si no se define 7
     try {
		raton1.join();
		raton2.join();
		raton3.join();
	} catch (Exception e) {
		// TODO: handle exception
	}

     System.out.println("Todos los Ratones han empezado a comer...");
 }
}
