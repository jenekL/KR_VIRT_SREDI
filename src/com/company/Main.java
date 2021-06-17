package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> q = new ArrayList<>();
        List<Integer> elem1 = Arrays.asList(5, 1, 3, 4, 5, 2);
        List<Integer> elem2 = Arrays.asList(1, 2, 5, 3, 0, 5);
        List<Integer> elem3 = Arrays.asList(2, 3, 5);
        List<ArrayList<Integer>> vec = new ArrayList<>();
        ArrayList<Integer> elem = readarray(q, elem1, elem2);
        ArrayList<Integer> pos = null;
        for (int i = 0; i < q.get(0); i++) {
            vec.add(readqarray(i, elem3));
            pos = correction((ArrayList<Integer>) elem, vec.get(i));
        }
        System.out.println(pos);
    }

    public static ArrayList<Integer> r1eadarray(ArrayList<Integer> q, List<Integer> data1, List<Integer> data2) {
        int n = data1.get(0);
        q.add(data2.get(0));
        ArrayList<Integer> elem = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int x1 = data1.get(i);
            int x2 = data2.get(i);
            elem.add(x1 * 100000 + x2);
        }
        return elem;
    }

    public static ArrayList<Integer> readqarray(int ibeg, List<Integer> data3) {
        int n, q, x1, x2;
        ArrayList<Integer> elem = new ArrayList<>();

        n = data3.get(0);
        for (int i = 1; i <= n; i++) {
            x1 = data3.get(i);
            elem.add(x1);
        }

        return elem;
    }

    public static ArrayList<Integer> correction(List<Integer> elem, List<Integer> q) {
        int n = q.size();
        ArrayList<Integer> res = new ArrayList<>();
        int bossid = 0;
        for (int j = 0; j < n; j++) {
            int id = q.get(j);
            for (int i = 0; i < elem.size(); i++) {
                int curid = elem.get(i) / 100000;
                bossid = elem.get(i) % 100000;
                if (curid == id)
                    break;
            }

            while (!q.contains(bossid)) {
                //boss not found;
                if (bossid == 0) break;
                for (int i = 0; i < elem.size(); i++) {
                    int curid = elem.get(i) / 100000;
                    if (curid == bossid) {
                        bossid = elem.get(i) % 100000;
                        break;
                    }
                }
            }
            res.add(bossid);
        }
        return res;
    }
}

