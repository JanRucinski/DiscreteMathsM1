// This is the main file for the Discrete project
// This is the main method

public class Main {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        Functions f = new Functions();
        
        System.out.println(f.ceil(5.2));
        System.out.println(f.floor(5.2));
        System.out.println(f.modulo(5, 2) + '\n');
        for (int x : f.erastosthenes(10)) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] elements = new int[]{1, 2, 3, 4};

        System.out.println(p.isPermutation(elements));
        int[][] permutations = p.generatePermutations(elements, 0);
        for (int[] permutation : permutations) {
            p.showArray(permutation);
        }
    }

};
