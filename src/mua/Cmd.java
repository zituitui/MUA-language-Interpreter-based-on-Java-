package mua;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

import mua.Value;
import mua.NameList;

public class Cmd {
    // next command return a value
    public static Value Next_command(Scanner in, NameList namelist) {
        String op = in.next(); // read next op
        int type = TypeDetect(op);
        if (op.equals("make")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.make(op1, op2, namelist);
        } else if (op.equals("thing")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.thing(op1, namelist);
        } else if (op.equals("print")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.print(op1);
        } else if (op.equals("add")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.add(op1, op2);
        } else if (op.equals("sub")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.sub(op1, op2);
        } else if (op.equals("mul")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.mul(op1, op2);
        } else if (op.equals("div")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.div(op1, op2);
        } else if (op.equals("mod")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.mod(op1, op2);
        } else if (op.equals("read")) {
            return Operations.read(in);
        } else if (op.equals("erase")) {
            Value name = GetPara(in, namelist);
            return Operations.erase(name, namelist);
        } else if (op.equals("eq")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.eq(op1, op2);
        } else if (op.equals("gt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.gt(op1, op2);
        } else if (op.equals("lt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.lt(op1, op2);
        } else if (op.equals("and")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.and(op1, op2);
        } else if (op.equals("or")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.or(op1, op2);
        } else if (op.equals("not")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.not(op1);
        } else if (op.equals("isname")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isname(op1, namelist);
        } else if (op.equals("isword")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isword(op1);
        } else if (op.equals("isnumber")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isnumber(op1);
        } else if (op.equals("islist")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.islist(op1);
        } else if (op.equals("isbool")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isbool(op1);
        } else if (op.equals("isempty")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isempty(op1);
        } else if (op.equals("return")) {
            Value res = Cmd.GetPara(in, namelist);
            return Operations.FuncReturn(in, namelist, res);
        } else if (op.equals("export")) {
            Value v = Cmd.GetPara(in, namelist);
            return Operations.export(namelist, v);
        } else if (op.equals("word")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.word(op1, op2);
        } else if (op.equals("sentence")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.sentence(op1, op2);
        } else if (op.equals("list")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.list(op1, op2);
        } else if (op.equals("join")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.join(op1, op2);
        } else if (op.equals("first")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.first(op1);
        } else if (op.equals("last")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.last(op1);
        }else if (op.equals("butfirst")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.butfirst(op1);
        }else if (op.equals("butlast")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.butlast(op1);
        }else if (op.equals("random")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.random(op1);
        }else if (op.equals("Int")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.Int(op1);
        }else if (op.equals("Sqrt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.Sqrt(op1);
        }else if (op.equals("save")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.save(op1,namelist);
        }else if (op.equals("load")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.load(op1,namelist);
        } else if (op.equals("erall")) {
            return Operations.erall(namelist);
        } else if (op.equals("poall")) {
            return Operations.poall(namelist);
        }else if (op.equals("run")) {
            Value list = Cmd.GetPara(in, namelist);
            Scanner sc = new Scanner(list.data);
            Value res = null;
            while (sc.hasNext()) {
                res = Next_command(sc, namelist);
            }
            return res;
        } else if (op.equals("if")) {
            Value j = GetPara(in, namelist);
            Value l1 = GetPara(in, namelist);
            Value l2 = GetPara(in, namelist);
            Value list = null;
            if (j.data.equals("true")) {
                list = l1;
            } else {
                list = l2;
            }
            Scanner sc = new Scanner(list.data);
            Value res = null;
            while (sc.hasNext()) {
                res = Next_command(sc, namelist);
            }
            return res;
        } else if (type == 2) {
            return new Value(op, type);
        } else if (type == 1) {
            return new Value(op, type);
        } else if (type == 3) {
            String list = Operations.getlist(in, op);
            return new Value(list, 3);
        } else if (type == 4) {
            return new Value(op, type);
        } else {
            return Operations.function(op, namelist, in);
        }
        // return new Value("", 0);
    }

    public static Value GetPara(Scanner in, NameList namelist) {
        if (!in.hasNext())
            return null;

        String str = in.next();
        int type = TypeDetect(str);
        String op = str;
        if (ifoperator(str)) {
            // String op = str;
            if (op.equals("make")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.make(op1, op2, namelist);
            } else if (op.equals("thing")) {
                Value op1 = Cmd.GetPara(in, namelist);
                return Operations.thing(op1, namelist);
            } else if (op.equals("print")) {
                Value op1 = Cmd.GetPara(in, namelist);
                return Operations.print(op1);
            } else if (op.equals("add")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.add(op1, op2);
            } else if (op.equals("sub")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.sub(op1, op2);
            } else if (op.equals("mul")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.mul(op1, op2);
            } else if (op.equals("div")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.div(op1, op2);
            } else if (op.equals("mod")) {
                Value op1 = Cmd.GetPara(in, namelist);
                Value op2 = Cmd.GetPara(in, namelist);
                return Operations.mod(op1, op2);
            } else if (op.equals("read")) {
                return Operations.read(in);
            }
        } else if (op.equals("erase")) {
            Value name = GetPara(in, namelist);
            return Operations.erase(name, namelist);
        } else if (op.equals("eq")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.eq(op1, op2);
        } else if (op.equals("gt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.gt(op1, op2);
        } else if (op.equals("lt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.lt(op1, op2);
        } else if (op.equals("and")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.and(op1, op2);
        } else if (op.equals("or")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.or(op1, op2);
        } else if (op.equals("not")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.not(op1);
        } else if (op.equals("isname")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isname(op1, namelist);
        } else if (op.equals("isword")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isword(op1);
        } else if (op.equals("isnumber")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isnumber(op1);
        } else if (op.equals("islist")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.islist(op1);
        } else if (op.equals("isbool")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isbool(op1);
        } else if (op.equals("isempty")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.isempty(op1);
        } else if (op.equals("run")) {
            Value list = Cmd.GetPara(in, namelist);
            Scanner sc = new Scanner(list.data);
            Value res = null;
            while (sc.hasNext()) {
                res = Next_command(sc, namelist);
            }
            return res;
        } else if (op.equals("return")) {
            Value res = Cmd.GetPara(in, namelist);
            return Operations.FuncReturn(in, namelist, res);
        } else if (op.equals("export")) {
            Value v = Cmd.GetPara(in, namelist);
            return Operations.export(namelist, v);//P4
        } else if (op.equals("word")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.word(op1, op2);
        } else if (op.equals("sentence")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.sentence(op1, op2);
        } else if (op.equals("list")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.list(op1, op2);
        } else if (op.equals("join")) {
            Value op1 = Cmd.GetPara(in, namelist);
            Value op2 = Cmd.GetPara(in, namelist);
            return Operations.join(op1, op2);
        } else if (op.equals("first")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.first(op1);
        } else if (op.equals("last")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.last(op1);
        }else if (op.equals("butfirst")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.butfirst(op1);
        }else if (op.equals("butlast")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.butlast(op1);
        }else if (op.equals("random")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.random(op1);
        }else if (op.equals("Int")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.Int(op1);
        }else if (op.equals("Sqrt")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.Sqrt(op1);
        }else if (op.equals("save")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.save(op1,namelist);
        }else if (op.equals("load")) {
            Value op1 = Cmd.GetPara(in, namelist);
            return Operations.load(op1,namelist);
        } else if (op.equals("erall")) {
            return Operations.erall(namelist);
        } else if (op.equals("poall")) {
            return Operations.poall(namelist);
        }  else if (op.equals("if")) {
            Value j = GetPara(in, namelist);
            Value l1 = GetPara(in, namelist);
            Value l2 = GetPara(in, namelist);
            Value list = null;
            if (j.data.equals("true")) {
                list = l1;
            } else {
                list = l2;
            }
            Scanner sc = new Scanner(list.data);
            Value res = null;
            while (sc.hasNext()) {
                res = Next_command(sc, namelist);
            }
            return res;
        } else if (str.charAt(0) == ':') {
            String name = str.substring(1);
            Value res = null;
            if (namelist.ifExist(name)) {
                res = namelist.GetValue(name);
            } else {
                System.out.println("No existing name binding!");
                return new Value("", 0);
            }
            if (res == null) {
                res = Main.namelist.GetValue(name);
            }
            return res;
        } else if (str.charAt(0) == '\"') {
            return new Value(str.substring(1), 1);
        } else if (type == 2) {
            return new Value(str, type);
        } else if (type == 1) {
            return new Value(str, type);
        } else if (type == 3) {
            String list = Operations.getlist(in, str);
            return new Value(list, 3);
        } else if (type == 4) {
            return new Value(str, type);
        } else {
            return Operations.function(op, namelist, in);
        }

        // else if(str.equals("make")){

        // }
        return new Value("", 0);
    }
    static public boolean ifFunc(Value v){
        if(v.type != 3)
            return false;
        Scanner sc = new Scanner(v.data);
        String s1 = sc.next();
        String s2 = sc.next();
        if(s1.charAt(0)=='['&&s1.charAt(s1.length()-1)==']'&&
        s2.charAt(0)=='['&&s2.charAt(s1.length()-1)==']'&&
        !sc.hasNext())
            return true;
        return false;
    }

    static public int TypeDetect(String str) {
        String num = "^-?[0-9]+(.[0-9]+)?$";
        if (str.matches(num)) {
            return 2; // number!
        }else if (str.charAt(0) == '\"') {
            return 1; // word
        } else if (str.equals("true") || str.equals("false")) {
            return 4; // bool
        } else if (str.charAt(0) == '[') {
            return 3; // list
        } else {
            // System.out.println("What a hell??");
            return 0; // default
        }
        // return 0; // default
    }

    static public boolean ifoperator(String str) {
        if (str.equals("thing") || str.equals("make") || str.equals("add") || str.equals("sub") || str.equals("mul")
                || str.equals("div") || str.equals("mod") || str.equals("read") || str.equals("print"))
            return true;
        else
            return false;
    }

}