/*
the key pointes are
1. the length of each stream is infinite, so it can't be stored into memory. It should be stored
in external memeory, like a hard dic.  So the sort should be done with external sorting.
2. to make the overall sort process faster. We need to read chuncks of data(runs) from each stream with
a proper size of chuncks. What would be the best size and how to decide the size?
3. what kind of data structure is most suitable for the interal sort for the chuncks. Tournament tree
or just merge sort?
4. to read each run from the data stream. We can write a method or assume there is already an API.
*/

// API used to read k numbers from stream and store them into the buffer
public void readStream(int k, int[] buf, int streamNum) {
    // read from file
}

class Pair {
    int val;
    int stream;
    Pair(int v, int s) {
        val = v;
        stream = s;
    }
}

public class sortDataStreams {
    int[] buf1;
    int[] buf2;
    int[] output;
    int capacity;
    public readStream(int size) {
        capacity = size;
        buf1 = new int[size];
        buf2 = new int[size];
        output = new int[2 * size];
        readData(buf1, stream1);
        readData(buf2, stream2);
        sortData();
    }

    public void readData(int[] buf, int streamNum) {
        // fill the buffer with new data from a certain stream
        readStream(capacity, buf, streamNum);
    }

    public void sortData() {
        Queue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> (a.val - b.val));
        for (int num : buf1) {
            minHeap.offer(new Pair(num, 1));
        }

        for (int num : buf2) {
            minHeap.offer(new Pair(num, 2));
        }
        int index = 0;
        int head1 = 0;
        int head2 = 0;

        while(true) {
            while (head1 < capacity && head2 < capacity) {
                Pair pair = minHeap.poll();
                output[index++] = pair.val;
                if(pair.stream == 1) {
                    head1++;
                } else {
                    head2++;
                }
            }

            if (head1 == capacity) {
                readData(buf1, 1);
                for (int num : buf1) {
                    minHeap.offer(new Pair(num, 1));
                }
                head1 = 0;
            }
            if (head2 == capacity) {
                readData(buf2, 2);
                for (int num : buf2) {
                    minHeap.offer(new Pair(num, 2));
                }
                head2 = 0;
            }

            // one buffer is empty, write data to external memory from output buffer
            writeData(output);
            index = 0;
        }
    }

    public void writeData(int[] outputBuf) {
        // write to disc
    }
}
