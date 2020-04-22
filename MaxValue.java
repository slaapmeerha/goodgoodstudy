package March;

public class MaxValue {
    public static int maxValue(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[row*col];
        dp[0] = grid[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0&&j==0)
                    continue;
                int left_x = i;
                int left_y = j-1;
                int front_x = i-1;
                int front_y = j;
                if(left_y<0)
                    dp[i*col+j] = dp[i*col+j-col]+grid[i][j];
                else if(front_x<0)
                    dp[i*col+j] = dp[i*col+j-1]+grid[i][j];
                else
                    dp[i*col+j] = Math.max(dp[i*col+j-col]+grid[i][j],dp[i*col+j-1]+grid[i][j]);
            }
        }

        return dp[row*col-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,5},{3,2,1}};
        int res = maxValue(arr);
        System.out.println(res);
    }
}
