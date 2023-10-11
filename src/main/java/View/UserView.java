package View;

import java.util.Scanner;

public class UserView {
    Scanner in = new Scanner(System.in);
    public  int getInt(){return  in.nextInt();}
    public  String  getLine(){return  in.nextLine();}

    public void set(String value) {
        System.out.println(value);

    }
}
