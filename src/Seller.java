public class Seller extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Main.cars){
                Main.cars.add("Nissan");
                System.out.println("Продавец сделал новую машину: " + Main.cars.get(0));
                Main.cars.notifyAll();
                try {
                    Thread.sleep(Main.PREPARATION_TIME);
                } catch (InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}