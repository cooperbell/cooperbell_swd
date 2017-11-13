import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class CircularBuffer implements Buffer {

    /**
     *
     */
    private final int[] buffer = {-1, -1, -1};

    /**
     *
     */
    private int occupiedCells = 0;

    /**
     *
     */
    private int writeIndex = 0;

    /**
     *
     */
    private int readIndex = 0;

    /**
     *
     */
    private final Lock accessLock = new ReentrantLock();

    /**
     *
     */
    private final Condition canWrite = accessLock.newCondition();

    /**
     *
     */
    private final Condition canRead = accessLock.newCondition();

    /**
     *
     * @param value
     * @throws InterruptedException
     */
    @Override
    public void blockingPut(int value) throws InterruptedException {

        accessLock.lock();
        try {
            while (occupiedCells == buffer.length) { //if buffer array is full, put Producer in a waiting state
                System.out.printf("Buffer is full. Producer waits.%n"); //TODO: delete
                canWrite.await();
            }

            buffer[writeIndex] = value;
            writeIndex = (writeIndex + 1) % buffer.length;

            occupiedCells++;
            displayState("Producer writes " + value); //TODO: delete
            canRead.signalAll();
        } finally {
            accessLock.unlock();
        }
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    @Override
    public int blockingGet() throws InterruptedException {

        accessLock.lock();

        int readValue;

        try {
            while (occupiedCells == 0) { //if buffer array is empty, put Consumer in a waiting state
                System.out.printf("Buffer is empty. Consumer waits.%n"); //TODO: delete
                canRead.await();
            }

            readValue = buffer[readIndex];
            readIndex = (readIndex + 1) % buffer.length;

            occupiedCells--;
            displayState("Consumer reads " + readValue); //TODO: delete
            canWrite.signalAll();
        } finally {
            accessLock.unlock();
        }

        return readValue;
    }

    /**
     *
     * @param operation
     */
    // display current operation and buffer state
    public void displayState(String operation) {

        try {
            accessLock.lock();
            // output operation and number of occupied buffer cells
            System.out.printf("%s%s%d)%n%s", operation,
                    " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

            for (int value : buffer)
                System.out.printf(" %2d  ", value); // output values in buffer

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++)
                System.out.print("---- ");

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++) {
                if (i == writeIndex && i == readIndex)
                    System.out.print(" WR"); // both write and read index
                else if (i == writeIndex)
                    System.out.print(" W   "); // just write index
                else if (i == readIndex)
                    System.out.print("  R  "); // just read index
                else
                    System.out.print("     "); // neither index
            }

            System.out.printf("%n%n");
        } finally {
            accessLock.unlock();
        }
    }
}
