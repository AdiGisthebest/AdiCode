import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.ListIterator;
class breedflip {
    public void read(){
        try {
            Scanner scan = new Scanner(new File("breedflip.in"));
            scan.nextLine();
            String order = scan.nextLine();
            String getStr = scan.nextLine();
            this.fileWrite(this.Solution(order,getStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String Solution(String order, String getStr) {
        int[] arr = new int[order.length()];
        int count = 0;
        for(int i = 0; i < order.length(); i++) {
            if(order.charAt(i) != getStr.charAt(i)) {
                arr[i] = i + 1;
            }
        }
        for(int i = 0; i < order.length(); i++) {
            System.out.println(arr[i]);
        }
        for(int i = 0; i < order.length(); i++) {
            if(arr[i] != 0) {
                if (i != order.length() - 1) {
                    if ((arr[i] + 1) == arr[i + 1]) {
                        count--;
                    }
                }
                count++;
            }
        }
        return Integer.toString(count);
    }
    public void fileWrite(String solution) {
        try {
            File file = new File("breedflip.out");
            System.out.println(solution);
            FileWriter writer = new FileWriter(file);
            writer.append(solution);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        breedflip solution = new breedflip();
        solution.read();
    }
}