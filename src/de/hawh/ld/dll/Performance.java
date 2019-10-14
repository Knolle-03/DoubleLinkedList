package de.hawh.ld.dll;

import edu.princeton.cs.algs4.StdRandom;

public class Performance {
    public static void main(String[] args) {

//        int repEx= Integer.parseInt(args[0]);
//        int repOp = Integer.parseInt(args[1]);
//        int N = Integer.parseInt(args[2]);

        int repEx= 10;
        int repOp = 500;
        int N = 400000;

        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> dll2 = new DoubleLinkedList<>();


        for (int i = 0; i < N ; i++) {
            dll.add(StdRandom.uniform(10_000_000));
            dll2.add(StdRandom.uniform(10_000_000));

        }
        System.out.println(dll);
        System.out.println(dll.size());

        System.out.println("addAt");

        for (int j = 0; j < repEx; j++) {
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < repOp; i++) {
                dll.addAt(StdRandom.uniform(N - 1), StdRandom.uniform(10_000_000));
            }
            System.out.printf("%d | %4.2f | %4.2f \n", repOp, stopwatch.elapsedTime(), stopwatch.elapsedTime()/repOp);
        }

        System.out.println("deleteAt");

        for (int j = 0; j < repEx; j++) {
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < repOp; i++) {
                dll.deleteAt(StdRandom.uniform(N - repOp - 1));
            }
            System.out.printf("%d | %4.2f | %4.2f \n", repOp, stopwatch.elapsedTime(), stopwatch.elapsedTime()/repOp);
        }

        System.out.println("includes");

        for (int j = 0; j < repEx; j++) {
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < repOp; i++) {
                dll2.includes(StdRandom.uniform(10_000_000));
            }
            System.out.printf("%d | %4.2f | %4.2f \n", repOp, stopwatch.elapsedTime(), stopwatch.elapsedTime()/repOp);
        }

        System.out.println("removeFirstOccurrence");

        for (int j = 0; j < repEx; j++) {
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < repOp; i++) {
                dll2.removeFirstOccurrence(StdRandom.uniform(10_000_000));
            }
            System.out.printf("%d | %4.2f | %4.2f \n", repOp, stopwatch.elapsedTime(), stopwatch.elapsedTime()/repOp);
        }

        System.out.println("removeAllOccurrences");

        for (int j = 0; j < repEx; j++) {
            Stopwatch stopwatch = new Stopwatch();
            for (int i = 0; i < repOp; i++) {
                dll2.removeAllOccurrences(StdRandom.uniform(10_000_000));
            }
            System.out.printf("%d | %4.2f | %4.2f \n", repOp, stopwatch.elapsedTime(), stopwatch.elapsedTime()/repOp);
        }
    }
}
