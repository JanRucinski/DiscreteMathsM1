import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations {

    public int[][] generatePermutations(int[] array, int currentIndex) {
        List<int[]> permutationsList = new ArrayList<>();

        if (currentIndex == array.length - 1) {
            permutationsList.add(Arrays.copyOf(array, array.length));
        } else {
            for (int i = currentIndex; i < array.length; i++) {
                swap(array, currentIndex, i);
                int[][] subPermutations = generatePermutations(array, currentIndex + 1);

                permutationsList.addAll(Arrays.asList(subPermutations));

                swap(array, currentIndex, i);
            }
        }

        return permutationsList.toArray(new int[0][]);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isPermutation(int[] x){
    for (int i = 0; i < x.length; i++) {
        for (int j = x.length -1; j > i; j--) {
            if (x[i] == x[j] && i != j) {
                return false;
            }
        }
    }
    return true;
    }

    public void showArray(int[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }
}
