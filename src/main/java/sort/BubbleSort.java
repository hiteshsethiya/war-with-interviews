package sort;

/**
 * Created by racit-2105 on 25/01/17.
 */
public class BubbleSort {

    public static void bubbleSort(int[] data) {
        int tmp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++)
                if (data[j] > data[j + 1]) {
                    tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
        }
    }
}
