// Questions : https://www.interviewbit.com/problems/arrange-ii/

public class Solution {
    
    public int product(String A, int start, int end){

        int W = 0, B = 0;
        
        for(int i = start; i <= end; i++){
            if (A.charAt(i) == 'W') {
            	W++;
            }
            else if (A.charAt(i) == 'B') {
            	B++;
            }
        }
        
        return W * B;
    }
    
    public int arrange(String A, int B) {
        
    	int numHorses = A.length();
        int[][] dp = new int[numHorses + 1][B + 1];
        
        if (A.length() < B) {
        	return -1;
        }
        
        // Find for one stable
        for (int i = 1; i <= A.length(); i++){
            dp[i][1] = product(A, 0, i - 1);
        }
        
        // Find for rest of the stable
        for (int k = 2; k <= B; k++){
        	
            for(int j = k; j <= numHorses; j++){
                int min = Integer.MAX_VALUE;
            
                for(int i = k - 1; i <= j - 1; i++){
                    min =  Math.min((dp[i][k - 1] + product(A, i, j - 1)), min);
                }
                
                dp[j][k] = min;
            }
        }
        
        return dp[A.length()][B];
    }
}
