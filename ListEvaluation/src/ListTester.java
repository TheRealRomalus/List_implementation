import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTester {

    final static int N[] = { 10, 100, 1000, 10000, 1000000 };
    static int values_not_found = 0;
    static int index_out_bound = 0;

    private static final Random rand = new Random();

    public static int getRandom(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static long ArrayList_Remove(int N, List<Integer> array_list, String function) {

        long duration = 0;
        index_out_bound = 0;
        values_not_found = 0;

        switch (function) {
            case "random":
                for (int j = 0; j < N; j++) {
                    int randomLocation = getRandom(0, N - 1);
                    long startTime = System.nanoTime();
                    try {
                        if ((array_list.remove(randomLocation) == null))
                            values_not_found++;

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;
                        values_not_found++;
                    }

                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                System.out.println("in random remove we good");

                break;

            case "end":
                for (int j = N - 1; j >= 0; j--) {
                    long startTime = System.nanoTime();
                    try {
                        if ((array_list.remove(j) == null))
                            values_not_found++;

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;

                    }

                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }
                System.out.println("in end remove we good");

                break;

            case "start":

                for (int j = 0; j < array_list.size(); j++) {
                    long startTime = System.nanoTime();
                    try {
                        if ((array_list.remove(j) == null))
                            values_not_found++;

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;
                    }
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }
                System.out.println("in start remove we good");

                break;

            case "byValue":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    long startTime = System.nanoTime();
                    try {
                        if (!(array_list.remove((Integer) random)))
                            values_not_found++;

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;
                    }
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }
                System.out.println("in byvalue remove we good");

                break;

            default:
                break;
        }

        return duration;

    }

    public static long ArrayList_Insertion(int N, List<Integer> array_list, String function) {

        long duration = 0;
        index_out_bound = 0;
        values_not_found = 0;

        switch (function) {
            case "random":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    int randomLocation = getRandom(0, array_list.size());
                    long startTime = System.nanoTime();

                    try {
                        array_list.add(randomLocation, random);

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;
                    }

                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            case "end":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    long startTime = System.nanoTime();

                    try {
                        array_list.add(random);

                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;

                    }

                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            case "start":

                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    long startTime = System.nanoTime();
                    try {
                        array_list.add(0, random);
                    } catch (IndexOutOfBoundsException e) {
                        index_out_bound++;
                    }

                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            default:
                break;
        }

        return duration;

    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList_random, myArrayList_start, myArrayList_end, myArrayList_Byvalue;
        MyLinkedList<Integer> myLinkedList_random, myLinkedList_start, myLinkedList_end, myLinkedList_Byvalue;
        ArrayList<Integer> ArrayList_random, ArrayList_start, ArrayList_end, ArrayList_Byvalue;
        LinkedList<Integer> LinkedList_random, LinkedList_start, LinkedList_end, LinkedList_Byvalue;

        String fileName = "testRun.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i : N) {

                if (false) {
                    writer.println("N = " + i + " ##### MyArrayList Inserting  $$$$####");
                    myArrayList_end = new MyArrayList<>();
                    writer.println(
                            "Inserting @ the End =  " + ArrayList_Insertion(i, myArrayList_end, "end") + "(ms)");
                    myArrayList_random = new MyArrayList<>();
                    writer.println(
                            "Inserting @ Random location =  " + ArrayList_Insertion(i,
                                    myArrayList_random, "random") + "(ms)");
                    myArrayList_start = new MyArrayList<>();
                    writer.println(
                            "Inserting @ the Start =  " + ArrayList_Insertion(i, myArrayList_start, "start") + "(ms)");

                    writer.println("\nN = " + i + " ##### MyArrayList Remove ####");

                    writer.println(
                            "Removal @ the End =  " + ArrayList_Remove(i, myArrayList_end, "end") + "(ms)");

                    writer.println(
                            "Removal @ Random location =  " + ArrayList_Remove(i,
                                    myArrayList_random, "random") + "(ms), and " + index_out_bound
                                    + " were out of bounds");

                    writer.println(
                            "Removal @ the Start =  " + ArrayList_Remove(i, myArrayList_start, "start") + "(ms)");
                    myArrayList_Byvalue = new MyArrayList<>();
                    long temp = ArrayList_Insertion(i, myArrayList_Byvalue, "random");
                    writer.println(
                            "Removal @ the ByValue =  " + ArrayList_Remove(i, myArrayList_Byvalue, "byValue")
                                    + "(ms) , "
                                    + values_not_found + "was not found");

                    writer.println("\nN = " + i + " ##### MyLinkedList Inserting  $$$$####");
                    myLinkedList_end = new MyLinkedList<>();
                    writer.println(
                            "Inserting @ the End =  " + ArrayList_Insertion(i, myLinkedList_end, "end") + "(ms)");
                    writer.flush();
                    myLinkedList_random = new MyLinkedList<>();
                    writer.println(
                            "Inserting @ Random location =  " + ArrayList_Insertion(i,
                                    myLinkedList_random, "random") + "(ms)");
                    writer.flush();
                    myLinkedList_start = new MyLinkedList<>();
                    writer.println(
                            "Inserting @ the Start =  " + ArrayList_Insertion(i, myLinkedList_start, "start") + "(ms)");
                    writer.flush();

                    writer.println("N = " + i + " ##### MyArrayList Remove ####");

                    writer.println(
                            "Removal @ the End =  " + ArrayList_Remove(i, myLinkedList_end, "end") + "(ms)");
                    writer.flush();

                    writer.println(
                            "Remove @ Random location =  " + ArrayList_Remove(i,
                                    myLinkedList_random, "random") + "(ms), and " + index_out_bound
                                    + " were OUT of bounds");
                    writer.flush();

                    writer.println(
                            "Removal @ the Start =  " + ArrayList_Remove(i, myLinkedList_start, "start") + "(ms)");
                    writer.flush();
                    myLinkedList_Byvalue = new MyLinkedList<>();
                    temp = ArrayList_Insertion(i, myLinkedList_Byvalue, "random");
                    writer.println(
                            "Removal @ the ByValue =  " + ArrayList_Remove(i, myLinkedList_Byvalue, "byValue")
                                    + "(ms) , "
                                    + values_not_found + " was NOT found");
                    writer.flush();

                }

                writer.println("N = " + i + " ##### ArrayList Inserting  $$$$####");
                ArrayList_end = new ArrayList<>();
                writer.println(
                        "Inserting @ the End =  " + ArrayList_Insertion(i, ArrayList_end, "end") + "(ms)");
                ArrayList_random = new ArrayList<>();
                writer.println(
                        "Inserting @ Random location =  " + ArrayList_Insertion(i,
                                ArrayList_random, "random") + "(ms)");
                ArrayList_start = new ArrayList<>();
                writer.println(
                        "Inserting @ the Start =  " + ArrayList_Insertion(i, ArrayList_start, "start") + "(ms)");

                writer.println("N = " + i + " ##### LinkedList Inserting  $$$$####");
                LinkedList_end = new LinkedList<>();
                writer.println(
                        "Inserting @ the End =  " + ArrayList_Insertion(i, LinkedList_end, "end") + "(ms)");
                writer.flush();
                LinkedList_random = new LinkedList<>();
                writer.println(
                        "Inserting @ Random location =  " + ArrayList_Insertion(i,
                                LinkedList_random, "random") + "(ms)");
                writer.flush();

                LinkedList_start = new LinkedList<>();
                writer.println(
                        "Inserting @ the Start =  " + ArrayList_Insertion(i, LinkedList_start, "start") + "(ms)");
                writer.flush();

                writer.println("\nN = " + i + " $$$$ ArrayList Remove $$$$");

                writer.println(
                        "Removal @ the End =  " + ArrayList_Remove(i, ArrayList_end, "end") + "(ms)");

                writer.println(
                        "Removal @ Random location =  " + ArrayList_Remove(i,
                                ArrayList_random, "random") + "(ms), and " + index_out_bound
                                + " were out of bounds  and " + values_not_found + " values were not found");

                writer.println(
                        "Removal @ the Start =  " + ArrayList_Remove(i, ArrayList_start, "start") + "(ms)");
                ArrayList_Byvalue = new ArrayList<>();
                long temp = ArrayList_Insertion(i, ArrayList_Byvalue, "random");
                writer.println(
                        "Removal @ the ByValue =  " + ArrayList_Remove(i, ArrayList_Byvalue, "byValue")
                                + "(ms) , "
                                + values_not_found + "was not found");

                writer.println("N = " + i + " $$$$  ArrayList Remove $$$$");

                writer.println(
                        "Removal @ the End =  " + ArrayList_Remove(i, LinkedList_end, "end") + "(ms)");
                writer.flush();

                writer.println(
                        "Remove @ Random location =  " + ArrayList_Remove(i,
                                LinkedList_random, "random") + "(ms), and " + index_out_bound
                                + " were OUT of bounds " + values_not_found + " values were not found");
                writer.flush();

                writer.println(
                        "Removal @ the Start =  " + ArrayList_Remove(i, LinkedList_start, "start") + "(ms)");
                writer.flush();
                myLinkedList_Byvalue = new MyLinkedList<>();
                temp = ArrayList_Insertion(i, myLinkedList_Byvalue, "random");
                writer.println(
                        "Removal @ the ByValue =  " + ArrayList_Remove(i, myLinkedList_Byvalue, "byValue")
                                + "(ms) , "
                                + values_not_found + " was NOT found and " + values_not_found
                                + " values were not found\n");
                writer.flush();

            }
            writer.close();

            System.out.println("CSV file successfully written: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

}
