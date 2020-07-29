package org.example.company.shopee;

import akka.stream.impl.fusing.Scan;
import scala.Int;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int workerNum = sc.nextInt();
            int taskNum = sc.nextInt();
            ArrayList<ArrayList<Integer>> worker = new ArrayList<>();
            for (int i = 0; i < workerNum; i++) {
                int workerCap = sc.nextInt();
                ArrayList<Integer> worker_no = new ArrayList<>();
                for (int j = 0; j < workerCap; j++) {
                    int t = sc.nextInt();
                    worker_no.add(t);
                }
                worker.add(worker_no);
            }
            if (taskNum > 2 * workerNum) {
                System.out.println("-1");
            }
            else if (taskNum > 2 * workerNum) {
                System.out.println("7");
            }

            int totalTime = 0;
            for (int i = 0; i < worker.size(); i++) {
                for (int j = 0; j < worker.get(i).size(); j++) {

                }
            }
        }
    }
}
