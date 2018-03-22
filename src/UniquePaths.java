import java.util.Scanner;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m <=1 || n <= 1) return 1;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++)
            result[i][0] = 1;
        for(int j = 0; j < n; j++)
            result[0][j] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
    return result[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        UniquePaths sl = new UniquePaths();
        sl.uniquePaths(m, n);
    }
}
