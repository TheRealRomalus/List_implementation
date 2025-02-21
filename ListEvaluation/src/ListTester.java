import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        switch (function) {
            case "random":
                for (int j = 0; j < N; j++) {
                    int randomLocation = getRandom(0, N - 1);
                    long startTime = System.nanoTime();
                    array_list.remove(randomLocation);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                System.out.println("in random remove we good");

                break;

            case "end":
                for (int j = N - 1; j >= 0; j--) {
                    long startTime = System.nanoTime();
                    array_list.remove(j);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }
                System.out.println("in end remove we good");

                break;

            case "start":

                for (int j = 0; j < array_list.size(); j++) {
                    long startTime = System.nanoTime();
                    array_list.remove(j);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }
                System.out.println("in start remove we good");

                break;

            case "byValue":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    long startTime = System.nanoTime();
                    if (!(array_list.remove((Integer) random)))
                        values_not_found++;
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

        switch (function) {
            case "random":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    int randomLocation = getRandom(0, array_list.size());
                    long startTime = System.nanoTime();
                    array_list.add(randomLocation, random);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            case "end":
                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    long startTime = System.nanoTime();
                    array_list.add(random);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            case "start":

                for (int j = 0; j < N; j++) {
                    int random = getRandom(0, 2 * N);
                    int randomLocation = getRandom(0, array_list.size());
                    long startTime = System.nanoTime();
                    array_list.add(randomLocation, random);
                    long endTime = System.nanoTime();
                    duration += endTime - startTime;
                }

                break;

            default:
                break;
        }

        return duration;

    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList_random, myArrayList_start, myArrayList_end, myArrayList_Byvalue;

        String fileName = "testRun.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i : N) {

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
                        "Remove @ Random location =  " + ArrayList_Remove(i,
                                myArrayList_random, "random") + "(ms), and " + index_out_bound + " were out of bounds");

                writer.println(
                        "Inserting @ the Start =  " + ArrayList_Remove(i, myArrayList_start, "start") + "(ms)");
                myArrayList_Byvalue = new MyArrayList<>();
                long temp = ArrayList_Insertion(i, myArrayList_Byvalue, "random");
                writer.println(
                        "Inserting @ the ByValue =  " + ArrayList_Remove(i, myArrayList_Byvalue, "byValue") + "(ms) , "
                                + values_not_found + "was not found");

            }
            writer.close();

            System.out.println("CSV file successfully written: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

}
