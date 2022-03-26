package mua;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;

import mua.NameList;
import mua.Value;

public class Operations {

    public static Value make(Value op1, Value op2, NameList namelisto) {
        
        if(op2.namelist==null){
            //op2.namelist = namelisto;
            op2.namelist = new NameList(namelisto);
        }else{
            for(String str:namelisto.map.keySet()){
                if(!op2.namelist.ifExist(str))
                op2.namelist.AddName(str, namelisto.GetValue(str));
            }
        }
        op2.namelist.AddName(op1.data, op2);
        return namelisto.AddName(op1.data, op2);
    }

    public static Value thing(Value op1, NameList namelist) {
        if (namelist.ifExist(op1.data)) {
            return namelist.GetValue(op1.data);
        } else {
            System.out.println("No name existing");
            return null;
        }

    }

    public static Value print(Value op1) {
        System.out.println(op1.data);
        return op1;
    }

    public static Value add(Value op1, Value op2) {
        String data1 = op1.data;
        String data2 = op2.data;
        double res = Double.valueOf(data1) + Double.valueOf(data2);
        return new Value(String.valueOf(res), 2);
    }

    public static Value sub(Value op1, Value op2) {
        String data1 = op1.data;
        String data2 = op2.data;
        double res = Double.valueOf(data1) - Double.valueOf(data2);
        return new Value(String.valueOf(res), 2);
    }

    public static Value mul(Value op1, Value op2) {
        String data1 = op1.data;
        String data2 = op2.data;
        double res = Double.valueOf(data1) * Double.valueOf(data2);
        return new Value(String.valueOf(res), 2);
    }

    public static Value div(Value op1, Value op2) {
        String data1 = op1.data;
        String data2 = op2.data;
        double res = Double.valueOf(data1) / Double.valueOf(data2);
        return new Value(String.valueOf(res), 2);
    }

    public static Value mod(Value op1, Value op2) {
        String data1 = op1.data;
        String data2 = op2.data;
        double res = Double.valueOf(data1) % Double.valueOf(data2);
        return new Value(String.valueOf(res), 2);
    }

    public static Value read(Scanner in) {
        String str = in.next();
        return new Value(str, 1);
    }

    public static Value erase(Value a, NameList namelist) {
        return namelist.RemoveName(a.data);
    }

    public static String getlist(Scanner in, String str) {
        while (Count(str, '[') != Count(str, ']')) {
            str += " " + in.next(); // continue to read in, until numbers of parenthsis equals
        }
        if (str.split(" |\\[|\\]").length == 0)
            return ""; // indicate that the list is empty
        else
            return str.substring(1, str.length() - 1); // delete the begin [ and end ]
    }

    public static int Count(String str, char c) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                cnt++;
        }
        return cnt;
    }

    // comparing oprations
    //
    //
    //
    //
    //
    public static Value eq(Value a, Value b) {
        if (a.type != b.type) {
            return new Value("false", 4);
        } else if (a.type == 1) { // a,b is word
            String judge = a.data.equals(b.data) ? "true" : "false";
            return new Value(judge, 4);
        } else if (a.type == 2) { // number
            String judge = Double.parseDouble(a.data) == Double.parseDouble(b.data) ? "true" : "false";
            return new Value(judge, 4);
        }
        System.out.println("Shit! eq errors");
        return null;
    }

    public static Value gt(Value a, Value b) {
        if (a.type == 2 && b.type == 2) { // number
            String judge = Double.parseDouble(a.data) > Double.parseDouble(b.data) ? "true" : "false";
            return new Value(judge, 4);
        } else {
            String judge = a.data.compareTo(b.data) > 0 ? "true" : "false";
            return new Value(judge, 4);
        }
    }

    public static Value lt(Value a, Value b) {
        return gt(b, a);
    }

    // bool oprations
    //
    //
    //
    //
    public static Value and(Value a, Value b) {
        // Boolean aa = a.data.equals("true") ? true : false;//
        // Boolean.getBoolean(a.data);
        // Boolean bb = b.data.equals("true") ? true : false;
        // Boolean rr = Boolean.logicalAnd(aa, bb);
        // return new Value(rr.toString(), 4);
        if (a.data.equals("true") && b.data.equals("true")) {
            return new Value("true", 4);
        } else
            return new Value("false", 4);
    }

    public static Value or(Value a, Value b) {
        // Boolean aa = Boolean.getBoolean(a.data);
        // Boolean bb = Boolean.getBoolean(b.data);
        // Boolean rr = Boolean.logicalOr(aa, bb);
        // return new Value(rr.toString(), 4);
        if (a.data.equals("false") && b.data.equals("false")) {
            return new Value("false", 4);
        } else
            return new Value("true", 4);
    }

    public static Value not(Value a) {
        if (a.data.equals("true"))
            return new Value("false", 4);
        else if (a.data.equals("false"))
            return new Value("true", 4);
        return null;
    }

    // judge functions
    //
    //
    //
    //
    public static Value isname(Value word, NameList namelist) {
        if (word.type != 1) {
            System.out.println("Your requesting object is not a word!");
            return null;
        }
        Value ISname = new Value(String.valueOf(namelist.ifExist(word.data)), 4);
        // new a bool Value
        return ISname; // true/false
    }

    public static Value isnumber(Value a) {
        String reg = "^-?[0-9]+(.[0-9]+)?$";
        return new Value(4, (a.type == 2 || (a.type == 1 && a.data.matches(reg))) ? "true" : "false");
    }

    public static Value isword(Value a) {
        return new Value(4, a.type == 1 ? "true" : "false");
    }

    public static Value islist(Value a) {
        return new Value(4, a.type == 3 ? "true" : "false");

    }

    public static Value isbool(Value a) {
        return new Value(4, a.type == 4 ? "true" : "false");
    }

    public static Value isempty(Value a) {
        if (a.type == 1 || a.type == 3)
            return new Value(4, a.data.equals("") ? "true" : "false");
        else
            System.out.println("Not a word or list");
        return null;
    }

    // function related functions
    //
    //
    //
    //
    public static Value function(String FuncName, NameList namelist, Scanner in) {
        Value content = namelist.GetValue(FuncName);
        if (content == null) {
            content = Main.namelist.GetValue(FuncName);
        }
        if (content == null || content.type != 3) {
            System.out.println("No this function!!!!");
            return null;
        }
        //NameList newNamelist = new NameList();//!!
        NameList newNamelist = new NameList(content.namelist);
        for(String n:namelist.map.keySet()){
            if(!newNamelist.ifExist(n))
                newNamelist.AddName(n, namelist.GetValue(n));
        }
        Scanner newScanner = new Scanner(content.data);
        Value Para_list = Cmd.GetPara(newScanner, namelist);
        Value Op_list = Cmd.GetPara(newScanner, namelist);
        if (Para_list == null) {

        } else if (Para_list.data != "" && Para_list != null) {
            String[] parameterList = Para_list.data.split(" |\t");
            // para binding
            for (int i = 0; i < parameterList.length; i++) {
                Value v = Cmd.GetPara(in, namelist);
                newNamelist.AddName(parameterList[i], v);
            }
        }
        if (Op_list == null) {

        } else if (Op_list.data != "" && Op_list != null) {
            newScanner = new Scanner(Op_list.data);
            while (newScanner.hasNext()) {
                Cmd.Next_command(newScanner, newNamelist);
            }
        }
        return newNamelist.GetValue("__return__"); // return value
    }

    public static Value FuncReturn(Scanner in, NameList namelist, Value v) {
        //!
        //v.namelist = new NameList(namelist);
        if(v.namelist==null){
            v.namelist = new NameList(namelist);
        }
        else
        for(String n:namelist.map.keySet()){
            if(!v.namelist.ifExist(n)){
                v.namelist.AddName(n, namelist.GetValue(n));
            }
        }
        namelist.AddName("__return__", v);
        while (in.hasNext())
            in.next(); // all the remaining thing in the function will do nothing
        return v;
    }

    public static Value export(NameList namelist, Value v) {
        String name = v.data;
        Main.namelist.AddName(name, namelist.GetValue(name));
        return v;
    }
    /*

    */
    //P4 list related works
    //
    //
    //
    //
    //
    //
    public static Value readList(Scanner sc){
        String str = sc.nextLine();
        str = sc.nextLine();
        Value res = new Value(str.substring(1,str.length()-1),3);
        return res;
    }

    public static Value word(Value a, Value b){
        if(a.type == 1 && b.type != 3){
            return new Value(a.data+b.data,1);
        }
        else{
            System.out.println("Word type error");
            return null;
        }
    }

    public static Value sentence(Value a, Value b){
        //return a list containing a and b
        return new Value(a.data+" "+b.data,3);
    }

    public static Value list(Value a, Value b){
        String str1 = a.data, str2 = b.data;
        //a is a list, take on her clothes
        if(a.type == 3)
            str1 = "[" + str1 + "]";
        //lady b is a list
        if(b.type == 3)
            str2 = "[" + str2 + "]";
        //return a list combining them
        return new Value(str1 + " " + str2, 3);
    }

    // join <list> <value>
    public static Value join(Value a, Value b){
        if(a.type != 3)
            System.out.println("Join type error");
        String strb = b.data;
        if(b.type == 3)
            strb = "[" + strb + "]";
        String stra = a.data;
        if(stra.equals("")){
            stra = strb;
        }else{
            stra = stra + " " + strb;
        }
        return new Value(stra, 3);
    }

    //from a scanner read in next value
    public static Value NextValue(Scanner in){
        if(in.hasNext() == false)
            return null;
        String str = in.next();
        if(!str.startsWith("["))
            return new Value(str,Cmd.TypeDetect(str));
        else{
            return new Value(getlist(in, str),3);
        }
    }
    // first <word|list>
    public static Value first(Value a){
        if(a.type == 3){
            Scanner sc = new Scanner(a.data);
            return NextValue(sc);
        }else{
            return new Value(a.data.substring(0,1),1);
        }
        //return null;
    }

    // last <word|list>
    public static Value last(Value a){
        if(a.type == 3){
            //a is a liat 
            Scanner sc = new Scanner(a.data);
            Value v = null, oldv = null;
            while(true){
                v = NextValue(sc);
                if(v == null) break;
                oldv = v;
            }
            return oldv;
            //return NextValue(sc);
        }else{
            //a is a simple word
            return new Value(a.data.substring(a.data.length()-1),1);
        }
        //return null;
    }

    //return remainding element but first
    public static Value butfirst(Value a){
        if(a.type == 1){
            //a is word
            return new Value(a.data.substring(1), 1);
        }else if (a.type == 3){
            Scanner sc = new Scanner(a.data);
            Value ret = new Value("", 3);
            Value v;
            //omit the first value
            v = NextValue(sc);
            //collect the remainding values
            while((v = NextValue(sc)) != null){ //detect if next value exist
                String d = v.data;
                if(v.type == 3){
                    d = "[" + d + "]";
                }
                if(ret.data.equals("")){
                    ret.data = "" + d;
                }else{
                    ret.data += " " + d;
                }
            }
            return ret;
        }else{
            System.out.println("Fuck you, butfirst type error!");
            return null;
        }
    }

    public static Value butlast(Value a){
        if(a.type == 1){
            return new Value(a.data.substring(0,a.data.length()-1), 1);
        }else if(a.type == 3){
            Scanner sc = new Scanner(a.data);
            String retStr = "";
            Value v = null,oldv = null;
            while((v = NextValue(sc))!=null){
                //store last value
                if(oldv!=null){
                    if(oldv.type == 3){
                        oldv.data = "[" + oldv.data + "]";  
                    }
                    if(retStr.equals(""))
                        retStr = new String(oldv.data);
                    else
                        retStr += " " + oldv.data;
                }
                oldv = new Value(v);
            }
            return new Value(retStr, 3);
        }else{
            System.out.println("Fuck you, butlast type error!");
            return null;
        }
    }

    public static Value random(Value a){
        double r = new Random().nextDouble() * Double.valueOf(a.data);
        return new Value(Double.toString(r), 2);
    }

    public static Value Int(Value a){
        if(a.type != 2){
            System.out.println("Fuck you, Int type error!");
            return null;
        }else{
            double i = Math.floor(Double.valueOf(a.data));
            return new Value(Double.toString(i), 2);
        }
    }

    public static Value Sqrt(Value a){
        double d = Double.valueOf(a.data);
        d = Math.sqrt(d);
        return new Value(Double.toString(d), 2);
    }

    public static Value save(Value v, NameList namelist){
        File f = new File(v.data);
        try{
            //store the current namelist into file
            f.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            String line = "";
            for(String n : namelist.map.keySet()){
                line += "make \"" + n;
                if(namelist.GetValue(n).type == 1){
                    line += " \"" + namelist.GetValue(n).data+"\n";
                }else if(namelist.GetValue(n).type == 3){
                    line += " [" + namelist.GetValue(n).data+"]\n";
                }else{
                    line += " " + namelist.GetValue(n).data + "\n";
                }
                out.write(line);
                line = "";
            }
            out.flush();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return v;
    }

    public static Value load(Value v, NameList namelist){
        File f = new File(v.data);
        byte[] content = new byte[new Long(f.length()).intValue()];
        try{
            FileInputStream in = new FileInputStream(f);
            in.read(content);
            in.close();
            Scanner sc = new Scanner(new String(content));
            while(sc.hasNext()){
                Cmd.Next_command(sc, namelist);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return new Value("true", 4);
    }

    public static Value erall(NameList namelist){
        namelist.map.clear();
        return new Value("true", 4);
    }

    public static Value poall(NameList namelist){
        String l = "";
        for(String n : namelist.map.keySet()){
            if(l.equals(""))
                l = namelist.GetValue(n).data;
            else
                l += " " + namelist.GetValue(n).data;
        }
        return new Value(l, 3);
    }
}
