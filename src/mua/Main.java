package mua;

import java.lang.*;
import java.util.*;

public class Main {
    // the global namelist
    public static NameList namelist = new NameList();

    public static void main(String[] args) {
        Value v;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            v = Cmd.Next_command(in, namelist);
        }
    }
}