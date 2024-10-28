package leetcode;

public class CanPlaceFlowers_605 {
    public static void main(String[] args) {
        var p = new CanPlaceFlowers_605();
        p.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        var prev=-2;
        for (int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i]==1) {
                prev=i;
                continue;
            }
            if(prev+1<i && ((i==flowerbed.length-1)||(i+1<flowerbed.length && flowerbed[i+1]==0))) {
                prev=i;
                n--;
            }
        }
        return n<=0;
    }
}
