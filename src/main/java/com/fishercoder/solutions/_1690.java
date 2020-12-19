package com.fishercoder.solutions;

public class _1690 {

    public static void main(String[] args){
            _1690 t = new _1690();
        _1690.Solution1 s = t.new Solution1();
//            int solution = s.stoneGameVII(new int[]{5,3,1,4,2});
            int solution = s.stoneGameVII(new int[]{121,903,609,929,646,419,823,722,223,170,8,704,102,803,639,548,364,306,440,65,933,123,21,376,215,798,280,232,942,513,463,567,34,642,958,823,37,605,784});
            System.out.println("solution is : " + solution);
    }

    class Solution1 {

        int[] stonesRef;

        int[] prepareSums;

        int[][] maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ = new int[1005][1005];

        public int stoneGameVII(int[] stones) {
            this.stonesRef = stones;
            int totalStonesNumber = stones.length;
            this.prepareSums = new int[totalStonesNumber+1];
            for(int i = 1;i <= totalStonesNumber;i++){
                this.prepareSums[i] = this.prepareSums[i - 1] + stones[i - 1];
            }
            this.maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(1, totalStonesNumber);
            return maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[1][totalStonesNumber];
        }

        private int maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(int i, int j) {
            if (j - i == 0) {
                maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j] = 0;
                return maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j];
            } else if (j - i == 1) {
                maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j] = Math.max(stonesRef[i - 1], stonesRef[j - 1]);
                return maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j];
            } else {
                maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j] = Math.max(
                        this.sumOfTheStonesValueInPosIToJ(i + 1, j)
                                - this.maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(i + 1, j)
                        , this.sumOfTheStonesValueInPosIToJ(i , j - 1)
                                - maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ(i, j - 1));
                return maxDiffScoureBetweenTowPlayerWhenPlayInPosItoJ[i][j];
            }
        }

        private int sumOfTheStonesValueInPosIToJ(int i,int j){
            return this.prepareSums[j] - this.prepareSums[i - 1];
        }

    }
}
