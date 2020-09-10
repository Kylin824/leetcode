package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {
//        String s="2+2*3/((2*(1+2)-4)*5)";
        String s="1+2*(3-4)";
        char[]chars=s.toCharArray();
        Stack stack=new Stack<>();
        ArrayList list=new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            char m=chars[i];
//		System.out.println(m);
            if(m!='+'&&m!='-'&&m!='*'&&m!='/'&&m!='('&&m!=')'){
                list.add(m);
            }else{
                if(stack.isEmpty()&&m!=')'){
                    stack.push(m);
                }else{
                    if(m==')'){
                        /**
                         * 清除一对括号
                         * */
                        while((char)stack.peek()!='('){
                            list.add(stack.pop());
                        }
                        stack.pop();
                    }else if(m=='('){
                        stack.push(m);
                    }else{
                        popContinue(m, stack, list);//最多执行两次，除了（左括号外，栈内不会有两个连续权限相等的符号

                    }

                }
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        System.out.println(list.toString());

        Stack res=new Stack();
        for(int i=0;i<list.size();i++){
            char m=(char)list.get(i);
            if(m!='+'&&m!='*'&&m!='-'&&m!='/'){
                res.push(Double.parseDouble(m+""));
            }else{
                double d1=0,d2=0;
                if(!res.isEmpty()){
                    d1=(double) res.pop();
                }
                if(!res.isEmpty()){
                    d2= (double) res.pop();
                }

                double d3 = 0;
                if(m=='*'){
                    d3=d2*d1;
                }
                if(m=='+'){
                    d3=d2+d1;
                }
                if(m=='-'){
                    d3=d2-d1;
                }
                if(m=='/'){
                    d3=d2/d1;
                }
                res.push(d3);

            }

        }
        System.out.println(res.pop());

    }
    public static void popContinue(char m,Stack stack,ArrayList list){
        int v1=getValues(m);
        int v2=getValues((char)stack.peek());
        if(v1>v2){
            stack.push(m);
            return ;
        }else{
            list.add(stack.pop());
            if(!stack.isEmpty()){
                popContinue(m, stack, list);

            }else{
                stack.push(m);
            }
        }
    }
    public static int getValues(char m){
        int i=0;
        if(m=='*'||m=='/'){
            i=2;
        }else if(m=='('){
            i=0;
        }else{
            i=1;
        }
        return i;
    }
}
