package com.teachmeskills.homework_12;

import java.io.*;
import java.util.*;

public class Task12 {
    public static void readAndWrite() throws IOException {
        System.out.println("Start");
        Scanner scanner1 = new Scanner(System.in);
        String m = "";
        List<BufferedReader> bufferedReaders = new ArrayList<>();
        System.out.println("Для выхода введите 0");
        while (!(m.equals("0"))) {
            m = scanner1.nextLine();
            if (!m.equals("0")) {
                bufferedReaders.add(new BufferedReader(new FileReader(m)));
            }
        }
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        for (BufferedReader bufferedReader : bufferedReaders) {
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s).append("\n");
            }
        }
        String[] strings = stringBuilder.toString().split("\n");
        Set<String> mySet = new HashSet(Arrays.asList(strings));
        System.out.println("Enter the path to write");
        String fileForWriter = scanner1.nextLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileForWriter));
        scanner1.close();
        Map<String, String> myMap = new HashMap();
        for (String s1 : mySet) {
            if (s1.length() >= 15 && (s1.startsWith("docnum") || s1.startsWith("сontract"))) {
                bufferedWriter.write(s1 + " - valid" + "\n");
                myMap.put(s1, "valid");
            } else if (s1.length() < 15) {
                bufferedWriter.write(s1 + "Not valid. The length is small" + "\n");
                myMap.put(s1, "Not valid. The length is small");
            } else if (s1.length() > 15 && !(s1.startsWith("docnum") || s1.startsWith("сontract"))) {
                bufferedWriter.write(s1 + "Not valid. Word does not start with docnum or сontract" + "\n");
                myMap.put(s1, "Not valid.  Word does not start with docnum or сontract");
            }
        }
        bufferedWriter.close();
    }
}
