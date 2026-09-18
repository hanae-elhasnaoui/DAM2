package exemple;

public class RatonRunnable implements Runnable{

	  private String nombre;
	    private int tiempo;

	    public  RatonRunnable (String nombre, int tiempo) {
	        // قمنا بحذف ()super لأننا لا نرث من كلاس أخرى الآن
	        this.nombre = nombre;
	        this.tiempo = tiempo;
	    }

	    // 2. دالة ()run تبقى كما هي تماماً لأن واجهة Runnable تفرض وجودها أيضاً
	    @Override
	    public void run() {
	        try {
	            System.out.printf("El Raton %s empieza a comer\n", nombre);
	            Thread.sleep(tiempo * 1000); 
	            System.out.printf("El Raton %s ha terminado de comer\n", nombre);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        // 3. ننشئ كائنات الفئران العادية التي تطبق Runnable
	        RatonRunnable raton1 =new RatonRunnable("1", 4);
	        RatonRunnable raton2 = new RatonRunnable("2", 2);
	        RatonRunnable raton3 = new RatonRunnable("3", 5);

	        // 4. الفخ هنا: كائنات Raton لم تعد تملك دالة ()start مباشرة!
	        // لذلك يجب إنشاء كائن Thread حقيقي وتمرير الفأر داخله كـ "المهمة المراد تنفيذها"
	        Thread hilo1 = new Thread(raton1);
	        Thread hilo2 = new Thread(raton2);
	        Thread hilo3 = new Thread(raton3);

	        // 5. الآن نقوم بتشغيل الـ Threads الحقيقية بالتوازي
	        hilo1.start();
	        hilo2.start();
	        hilo3.start();

	        System.out.println("Todos los Ratones han empezado a comer...");
	    }
	}