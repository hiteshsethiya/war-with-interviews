import java.util.Scanner;

/**
 * Created by racit-2105 on 22/12/16.
 * https://www.hackerrank.com/challenges/designer-pdf-viewer
 */
public class DesignerPdfViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int width = word.length();
        int height = 0;
        for(int i = 0 ; i < word.length(); ++i) {
            int l_h_i = word.charAt(i) - 97;
            if(height < h[l_h_i]) {
                height = h[l_h_i];
            }
        }
        System.out.println(height * width);
    }
}
