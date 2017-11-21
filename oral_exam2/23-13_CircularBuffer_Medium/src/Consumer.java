/**
 *
 */
public class Consumer implements Runnable {

    /**
     *
     */
    private final CircularBuffer sharedLocation;

    /**
     *
     * @param sharedLocation
     */
    public Consumer(CircularBuffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    /**
     *
     */
    @Override
    public void run() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            try {
                sum += sharedLocation.blockingGet();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%n%s %d%n%s%n",
                "Consumer read values totaling", sum, "Terminating Consumer");  //TODO: delete
    }
}
