// Source : https://leetcode.com/problems/zigzag-conversion/
// Author : Animesh Gupta
// Date   : 2015-10-31

/************************************************************************************************** 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
**************************************************************************************************/

public class Solution {
    public String convert(String s, int numRows) {
        if(s==null ||s.length()==0)
            return s;
        int i=0;
        //List<List<Character>> list = new ArrayList<List<Character>>(numRows);
        StringBuilder []result = new StringBuilder[numRows];
        //Tag:String Array needs to be initialised before use
        while(i<numRows)
            result[i++] = new StringBuilder();
        i=0;
        int len = s.length();
        int row = 0;
        while(i<len){
            while(i<len && row<numRows){
                result[row++].append(s.charAt(i++));
            }
            row = numRows==1?0:numRows-2;
            while(i<len && row>=0){
                result[row--].append(s.charAt(i++));
            }
            row = 1;
        }
        StringBuilder temp = new StringBuilder();
        
        for(StringBuilder str:result)
             temp.append(str.toString());
        return temp.toString();
    }
}
