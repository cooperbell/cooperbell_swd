/**
 * Consumer class reads from Buffer
 */
public class Consumer implements Runnable {

    /**
     * Circular buffer object that is shared between Producer and Consumer objects
     */
    private final CircularBuffer sharedLocation;

    /**
     * Constructor initializes sharedLocation object
     * @param sharedLocation CircularBuffer object
     */
    public Consumer(CircularBuffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

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
