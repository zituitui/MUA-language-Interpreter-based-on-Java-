package mua;

import java.lang.*;
import java.util.*;

import mua.Value;

public class NameList {
    public Map<String, Value> map;
    static Value pi_v = new Value("3.14159", 2); // create the pi information

    public NameList() {
        this.map = new HashMap<String, Value>();
        this.AddName("pi", pi_v);
    }

    public NameList(NameList L) {
        this.map = new HashMap<String, Value>();
        this.AddName("pi", pi_v);
        for(String str:L.map.keySet()){
            this.AddName(str, L.GetValue(str));
        }
    }

    // bind a name into the namelist
    public Value AddName(String name, Value value) {
        map.put(name, value);
        return value;
    }

    // remove a name from current namelist
    public Value RemoveName(String name) {
        Value value = map.get(name);
        map.remove(name);
        return value;
    }

    // return the value binding to this name
    public Value GetValue(String name) {
        Value value = map.get(name);
        return value;
    }

    // judge if current namelist contain the name
    public boolean ifExist(String name) {
        // maybe in this namelist, maybe in global scope
        return map.containsKey(name) || Main.namelist.map.containsKey(name);
    }

    // erase all the name binding in the current namelist
    public Value ClearAll() {
        map.clear();
        return new Value("True", 4);
    }

    // create a list Value
    public Value ListAll() {
        String datalist = null;
        for (String str : map.keySet()) {
            if (datalist == null) {
                datalist = str;
            } else {
                datalist = datalist + " " + str;
            }
        }
        return new Value(datalist, 3);// create a new list
    }
}