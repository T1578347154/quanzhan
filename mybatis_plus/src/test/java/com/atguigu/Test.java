package com.atguigu;

import java.util.Arrays;

public class Test {

        public static void main(String[] args) {
            int i=1;
            String str="hello";
            Integer num=2;
            int [] arr={1,2,3,4,5};//2 2 3  4 5
            MyData myData=new MyData();

            change(i,str,num,arr,myData);

            System.out.println("i="+i);//1
            System.out.println("str="+str);//hello
            System.out.println("num="+num);//2
            System.out.println("arr="+ Arrays.toString(arr));//2
            System.out.println("myData.a="+myData.a);//11
        }
        public static void change(int j,String s,Integer n,int[] a,MyData m){ //成员变量
            j+=1;
            s+="world";
            n+=1;
            a[0]+=1;
            m.a+=1;// this 指代的时 myData
        }
    }
class MyData{
    int a=10;
}
