package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        StringTokenizer st = new StringTokenizer(signatureString.substring
                (0,signatureString.indexOf('('))," ");
        String str = "";
        while(st.hasMoreElements()) {
            str=str+st.nextElement()+" ";
        }
        String arr[] = str.split(" ");


        StringTokenizer st3 = new StringTokenizer(signatureString.substring
                (signatureString.indexOf('(')),"[(, )]");

        String s31="";

        while(st3.hasMoreElements()) {
            s31=s31+st3.nextElement()+" ";
        }
        System.out.println(s31);
        List<MethodSignature.Argument> arguments = new ArrayList<>();

        String arr1[] = s31.split(" ");

        MethodSignature.Argument a[] = new MethodSignature.Argument[arr1.length/2];

        for(int i=0;i<arr1.length/2;i++){
            a[i] = new MethodSignature.Argument(null,null);
        }


String stringName = "";
        String stringType = "";
        for(int i=1;i<arr1.length;i=i+2){
            stringName=stringName+arr1[i]+" ";
        }

        for(int i=0;i<arr1.length;i=i+2){
            stringType=stringType+arr1[i]+" ";
        }
        String arrName[] = stringName.split(" ");
        String arrType[] = stringType.split(" ");
            for(int i=0;i<arrType.length;i++) {

                a[i].setType(arrType[i]);
                a[i].setName(arrName[i]);


arguments.add(a[i]);
            }




        MethodSignature m = new MethodSignature(null,arguments);
        if(str.charAt(0)=='p'){

            m.setAccessModifier(arr[0]);
            m.setReturnType(arr[1]);
            m.setMethodName(arr[2]);

        }
        else{
            m.setReturnType(arr[0]);
            m.setMethodName(arr[1]);

        }

        return m;
    }
}
