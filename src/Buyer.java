public class Buyer extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Покупатель " + Thread.currentThread().getName() + " пришел в салон");
            synchronized (Main.cars){
                if (!Main.cars.isEmpty()) {
                    System.out.println("Покупатель " + Thread.currentThread().getName() + " получил новую машину: " +
                            Main.cars.get(0));
                    Main.cars.remove(0);
                    try {
                        Thread.sleep(Main.PURCHASE_TIME);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.println("Нет машин");
                    try {
                        Main.cars.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }
}