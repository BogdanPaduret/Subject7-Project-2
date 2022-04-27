package com.company;

import javax.xml.xpath.XPath;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OperatiiInOutFisier implements OperatiiFisier, Comparable{

    private String path;

    @Override
    public Object clone() {

        return new OperatiiInOutFisier();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String[] citesteObiectDinFisierText() {
        ArrayList<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != "") {
                    strings.add(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list2array(strings);

    }

    @Override
    public void scrieObiectInFisierText(String toSave) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave);
            printWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private String[] list2array(ArrayList<String> strings) {
        String[] input = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            input[i] = strings.get(i);
        }
        return input;
    }

}
