package March;

public class Test {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{3,4,5}};
        for(int[] r:grid){
            for(int v:r){
                if(v==5)
                    System.out.println("yyyy");
            }
        }
    }
}
