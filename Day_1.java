import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day_1 {
    public static void part_1(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineSplit = line.split("[\\s]");

            listOne.add(Integer.valueOf(lineSplit[0]));
            listTwo.add(Integer.parseInt(lineSplit[lineSplit.length - 1]));
        }

        sc.close();

        Collections.sort(listOne);
        Collections.sort(listTwo);
        
        int totalDistance = 0;
        for (int i = 0; i < listOne.size(); i++) {
            totalDistance += (Math.abs(listOne.get(i) - listTwo.get(i)));
        }

        System.out.println(totalDistance);
    }

    public static void part_2(String filePath) throws IOException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        List<Integer> listOne = new ArrayList<>();
        HashMap<Integer, Integer> hashMapTwo = new HashMap<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineSplit = line.split("[\\s]");

            listOne.add(Integer.valueOf(lineSplit[0]));

            int second = Integer.valueOf(lineSplit[lineSplit.length - 1]);

            if (hashMapTwo.containsKey(second)) {
                int val = hashMapTwo.get(second) + 1;
                hashMapTwo.remove(second);
                hashMapTwo.put(second, val);
            } else {
                hashMapTwo.put(second, 1);
            }
        }
        
        int totalSimilarity = 0;
        for (int i = 0; i < listOne.size(); i++) {
            int first = listOne.get(i);
            
            if (hashMapTwo.containsKey(first)) {
                totalSimilarity += (first * hashMapTwo.get(first));
            }
        }
        System.out.println(totalSimilarity);
    }

    public static void main(String[] args) {
        String filePath = "input/Day_1.txt";
        try{
            part_2(filePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}