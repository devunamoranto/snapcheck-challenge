/*
    @author Devun Amoranto
 */
public class Main {
    static int offset;
    // Input should be a single string.
    public static void main(String[] args){
        System.out.println(encrypt(args[0]));
    }

    /* Returns a string s with whitespace removed,
    * and printed into rows and columns.
    */
    private static String encrypt(String str){
        String soln = "";
        for(String i : str.trim().split(" +")) {
            soln += i;
        }

        //Sets up the grid dimensions.
        int row = (int) Math.sqrt(soln.length());
        int col;
        if (Math.pow(row, 2) == soln.length()) {
            col = row;
            offset = 0;
        } else {
            col = row + 1;
            offset = 1;
        }
        soln = rearrange(soln, row, col);
        return soln;
    }

    // Arranges s into a grid, and performs the encryption.
    private static String rearrange(String s, int r, int c) {
        String[][] data = new String[r+1][c];
        String build = "";

        //Populates each cell of 'data' with the next character of s.
        for (int hor = 0; hor < c; hor++) {
            for (int ver = 0; ver < r + offset; ver++) {
                String piece = s.length() > 0 ? s.substring(0, 1) : "";
                if (s.length() > 0) s = s.substring(1);
                data[hor][ver] = piece;
            }
        }

        int row = 0, col = 0;
        while(row <= (r+1)) {
            //Resets the loop
            if(row == (r+1)) {
                row = 0;
                col += 1;
                build += " ";
            }
            if (col == c) {
                break;
            }
            //Populates the string to return
            String val = data[row][col];
            build = val == null ? build: build + val;
            row ++;
        }

        //Eliminates extra spaces at the end of the string.
        return build.trim();
    }
}
