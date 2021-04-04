package Dynamic_Programming;

public class Egg_Drop {
    public static void main(String[] args) {
        int eggs = 3;
        int floors = 6;
//        System.out.println(solveRecursive(eggs, floors));
        System.out.println(solve(eggs, floors));
    }

    public static int solve(int totalEggs, int totalFloors) {
        int[][] cache = new int[totalEggs + 1][totalFloors + 1];

        for(int egg = 0 ; egg <= totalEggs ; egg++) {
            for(int floor = 0 ; floor <= totalFloors ; floor++) {
                if(egg == 0) {
                    cache[egg][floor] = 0;
                } else if(egg == 1) {
                    cache[egg][floor] = floor;
                } else if(floor == 0 || floor == 1) {
                    cache[egg][floor] = floor;
                } else {
                    cache[egg][floor] = Integer.MAX_VALUE;
                    for(int k = 1 ; k <= floor ; k++) {
                        int eggBreaks = cache[egg - 1][k - 1];
                        int eggNotBreaks = cache[egg][floor - k];
                        int worstOutcomes = Math.max(eggBreaks, eggNotBreaks) + 1;
                        cache[egg][floor] = Math.min(cache[egg][floor], worstOutcomes);
                    }
                }
            }
        }

        return cache[totalEggs][totalFloors];
    }

    public static int solveRecursive(int e, int f) {
        int[][] cache = new int[e + 1][f + 1];
        return solveRecursive(e, f, cache);
    }

    private static int solveRecursive(int e, int f, int[][] cache) {
        if(f == 1) {
            return 1;
        }
        if(e == 1) {
            return f;
        }
        if(f == 0) {
            return 0;
        }

        if(cache[e][f] != 0) {
            return cache[e][f];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= f ; i++) {
            min = Math.min(min,
                    Math.max(solveRecursive(e - 1, i - 1, cache),
                            solveRecursive(e, f - i, cache)));

        }
        return cache[e][f] = min + 1;
    }
}
