import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char operator;
        String[] data;
        if (str.contains(" + ")) {
            data = str.split(" \\+ ");
            operator = '+';
        } else if (str.contains(" - ")) {
            data = str.split(" - ");
            operator = '-';
        } else if (str.contains(" * ")) {
            data = str.split(" \\* ");
            operator = '*';
        } else if (str.contains(" / ")) {
            data = str.split(" / ");
            operator = '/';
        }else{
            throw new Exception("Некорректный знак действия");
        }
        if (operator == '*' || operator == '/') {
            if (data[0].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (operator == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (operator == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            printInQuotes(result);
        } else if (operator == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }}