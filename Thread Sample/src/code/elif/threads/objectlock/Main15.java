package code.elif.threads.objectlock;

import com.sun.javafx.binding.StringFormatter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;


public class Main15 {

    private static final String INPUT_FILE = "./out/matrices";
    private static final String OUTPUT_FILE = "./out/matrices_results.txt";
    private static final int N = 10;
    private static final int CAPACITY = 5;


    public static void main(String[] args) throws IOException {
        ThreadSafeQueue threadSafeQueue = new ThreadSafeQueue();
        File inputFile = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        MatricesReaderProducer matricesReader = new MatricesReaderProducer(new FileReader(inputFile), threadSafeQueue);
        MatricesMultiplierConsumer matricesConsumer = new MatricesMultiplierConsumer(new FileWriter(outputFile), threadSafeQueue);

        matricesConsumer.start();
        matricesReader.start();
    }


    static class MatricesMultiplierConsumer extends Thread {
        private ThreadSafeQueue threadSafeQueue;
        FileWriter fileWriter;

        public MatricesMultiplierConsumer(FileWriter fileWriter, ThreadSafeQueue threadSafeQueue) {
            this.threadSafeQueue = threadSafeQueue;
            this.fileWriter = fileWriter;
        }

        public float[][] multiplyMatrices(float[][] matrix1, float[][] matrix2) {
            float[][] result = new float[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < N; k++) {
                        result[r][c] += matrix1[r][k] * matrix2[k][c];
                    }
                }
            }
            return result;
        }

        @Override
        public void run() {
            while (true) {
                MatricesPair matricesPair = threadSafeQueue.remove();
                if (matricesPair == null) {
                    System.out.println("There is no matricesPair in the queue");
                    break;
                }

                float[][] result = multiplyMatrices(matricesPair.matrix1, matricesPair.matrix2);
                try {
                    saveMatrixToFile(result, fileWriter);
                } catch (IOException e) {

                }
            }

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void saveMatrixToFile(float[][] result, FileWriter fileWriter) throws IOException {

            for (int r = 0; r < N; r++) {
                StringJoiner joiner = new StringJoiner(", ");
                for (int c = 0; c < N; c++) {

                    joiner.add(StringFormatter.format("%.2f", result[r][c]).getValue());
                }
                fileWriter.write(joiner.toString());
                fileWriter.write("\n");
            }
            fileWriter.write("\n");
        }


    }

    static class MatricesReaderProducer extends Thread {
        private Scanner scanner;
        private ThreadSafeQueue threadSafeQueue;


        public MatricesReaderProducer(FileReader fileReader, ThreadSafeQueue threadSafeQueue) {
            this.scanner = new Scanner(fileReader);
            this.threadSafeQueue = threadSafeQueue;
        }

        public void run() {
            while (true) {
                float[][] matrix1 = readMatrix();
                float[][] matrix2 = readMatrix();

                if (matrix1 == null || matrix2 == null) {
                    threadSafeQueue.terminate();
                    System.out.println("There is no matrix in the queue.");
                    return;
                }

                MatricesPair matricesPair = new MatricesPair();
                matricesPair.matrix1 = matrix1;
                matricesPair.matrix2 = matrix2;

                threadSafeQueue.add(matricesPair);
            }
        }

        private float[][] readMatrix() {
            float[][] matrix = new float[N][N];
            for (int r = 0; r < N; r++) {
                if (!scanner.hasNext()) {
                    return null;
                }
                String[] line = scanner.nextLine().split(",");
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = Float.valueOf(line[c]);
                }
            }
            scanner.nextLine();
            return matrix;
        }
    }

    private static class ThreadSafeQueue {
        //holds Matrices
        Queue<MatricesPair> queue = new LinkedList<>();
        //holds if the queue is empty or not
        boolean isEmpty = true;
        //signal the consumer that the producer has nothing more to offer.
        //consumer needs to terminate its thread
        boolean isTerminate = false;

        public synchronized void add(MatricesPair matricesPair) {
            while (queue.size() == CAPACITY) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(matricesPair);
            isEmpty = false;
            notify();

        }

        public synchronized MatricesPair remove() {
            while (isEmpty && !isTerminate) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (queue.size() == 1) {
                isEmpty = true;
            }

            if (queue.size() == 0 && isTerminate) {
                return null;
            }

            System.out.println("queue size " + queue.size());
            MatricesPair matricesPair = queue.remove();
            if (queue.size() == CAPACITY - 1) {
                notifyAll();
            }
            return matricesPair;
        }

        public synchronized void terminate() {
            isTerminate = true;
            notifyAll();
        }
    }

    static class MatricesPair {
        float[][] matrix1;
        float[][] matrix2;

    }
}