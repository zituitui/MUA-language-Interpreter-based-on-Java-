package mua;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class Value {
    public String data; // the real containing thing
    public int type; // 1 -- word
                     // 2 -- number
                     // 3 -- list
                     // 4 -- bool
    public NameList namelist;
    public Value(String data, int type) {
        this.data = data;
        this.type = type;
        this.namelist = null;
    }

    public Value(int type, String data) {
        this.data = data;
        this.type = type;
        this.namelist = null;
    }

    //this method only use in P4
    //never use this in P3
    //diastrous to functional programming
    public Value(Value v) {
        this.data = "" + v.data;
        this.type = v.type;
        this.namelist = null;
    }
}
