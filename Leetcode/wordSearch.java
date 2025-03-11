public class wordSearch {
    public static boolean wordSearches(char matrix[][], String word){
        // char[] charArray = word.toCharArray(); 
        int n = word.length();
        int count = 0;
        for(int i=0; i<word.length(); i++) {
            for(int j=0; j<matrix.length; j++) {
                for(int k=0; k<matrix[0].length; k++) {
                    System.out.print(word.charAt(i) +" ");
                    System.out.println(matrix[j][k] + " ");
                    if(word.charAt(i) == matrix[j][k]){
                        if(n == count && word.charAt(i-1) != word.charAt(i)) {
                            count++;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // char matrix[][] = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        char matrix[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearches(matrix, word));

    }
}
