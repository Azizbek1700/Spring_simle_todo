package uz.bakhodirov.springtemplate.validator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String str = "#a#bb#ccc#dddd#";
//        int n = 0;
//
//        for (int i = 1; i < str.length() - 1; i++) {
//            if (str.charAt(i) == '#')
//                n++;
//        }
//        String[] arr = new String[n + 1];
//
//        n = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (!str.contains("#")&&str.length()>0){
//                arr[n++]=str;
//                break;
//            }
//
//            if (str.length() == 0)
//                break;
//
//            if (str.charAt(i) == '#') {
//                if (i != 0 )
//                    arr[n++] = str.substring(0, i);
//                str = str.substring(i + 1);
//                i=0;
//            }
//        }
//        System.out.println(Arrays.toString(arr));

   String str="a#bbb##ggg#jjjj#####ll#";


        //panjaralar soni
        int numOfWords=0;
        for(int i=1; i<str.length(); i++)
            if(str.charAt(i)=='#'&&str.charAt(i-1)!='#')
                numOfWords++;
        //natijaviy massivda panjaralar sonidan bitta ko'p element bo'ladi
        String[] res=new String[numOfWords];
        //navbatdagi elementni saqlab turuvchi satr
        String temp="";
        //massivning qaysi elementiga kelganimizni bilib turishimiz uchun
        int index=0;
        //panjaraga kelguncha temp stringga yig'amiz belgilarni,
        //kelgan paytimiz massivni navbatdagi elementiga o'zlashtiramiz
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='#'&&str.charAt(i-1)!='#'){
                res[index++]=temp;
                temp="";
            } else if(str.charAt(i)!='#'){
                temp+=str.charAt(i);
            }
        }
//        return res;
        System.out.println(Arrays.toString(res));
    }
}
