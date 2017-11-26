/**
 * Producer class writes to Buffer
 */
public class Producer implements Runnable {

    /**
     * Circular buffer object that is shared between Producer and Consumer objects
     */
    private final CircularBuffer sharedLocation;

    /**
     * Constructor initializes sharedLocation object
     * @param sharedLocation CircularBuffer object
     */
    public Producer(CircularBuffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            try {
                sharedLocation.blockingPut(i);
                sum += i;
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf(
                "Producer done producing%nTerminating Producer%n"); //TODO: delete
    }
}
