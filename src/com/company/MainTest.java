package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Main.correction;
import static com.company.Main.readarray;
import static com.company.Main.readqarray;

public class MainTest {

    @Test
    public void main() {
        ArrayList<Integer> q = new ArrayList<>();
        List<Integer> elem1 = Arrays.asList(5, 1, 3, 4, 5, 2);
        List<Integer> elem2 = Arrays.asList(1, 2, 1, 3, 0, 5);
        List<Integer> elem3 = Arrays.asList(2, 3, 5);
        ArrayList<Integer> elem = readarray(q, elem1, elem2);
        List<Integer> expected = Arrays.asList(5, 0);
        List<ArrayList<Integer>> vec = new ArrayList<>();
        for (int i = 0; i < q.get(0); i++) {
            vec.add(readqarray(i, elem3));
            ArrayList<Integer> pos = correction(elem, vec.get(i));
            Assert.assertEquals(expected, pos);
        }
    }

    @Test
    public void probMain() {
        ArrayList<Integer> q = new ArrayList<>();
        List<Integer> elem1 = Arrays.asList(5, 1, 3, 4, 5, 2);
        List<Integer> elem2 = Arrays.asList(1, 2, 5, 3, 0, 5);
        List<Integer> elem3 = Arrays.asList(2, 3, 5);
        ArrayList<Integer> elem = readarray(q, elem1, elem2);
        List<Integer> expected = Arrays.asList(5, 0);
        List<ArrayList<Integer>> vec = new ArrayList<>();
        for (int i = 0; i < q.get(0); i++) {
            vec.add(readqarray(i, elem3));
            ArrayList<Integer> pos = correction(elem, vec.get(i));
            Assert.assertEquals(expected, pos);
        }
    }
}