package aa.slkenv.resume.newcode.huawei;

import java.util.Scanner;
import java.util.Stack;

public class C_Four {

    // 第一步，先考虑无括号的情况，先乘除后加减，这个用栈很容易解决，
    // 遇到数字先压栈，如果下一个是乘号或除号，先出栈，和下一个数进行乘除运算，再入栈，
    // 最后就能保证栈内所有数字都是加数，最后对所有加数求和即可。
    // 第二步，遇到左括号，直接递归执行第一步即可，最后检测到右括号，
    // 返回括号内的计算结果，退出函数，这个结果作为一个加数，返回上一层入栈。
    static int pos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int pos = 0;
            System.out.println(getInnerResult(s));
        }
    }

    // 递归，消消乐，算括号里面的(无括号的)数字的结果
    public static int getInnerResult(String s) {
        Stack<Integer> val = new Stack<>();
        int num = 0;
        char opt = '+';
        while (pos < s.length()) {
            // 3+2*{1+2*[-4/(8-6)+7]}
            // 遇到括号，开始递归 ，从括号里面开始算，消消乐
            if (s.charAt(pos) == '{' || s.charAt(pos) == '[' || s.charAt(pos) == '(') {
                pos++;
                num = getInnerResult(s);
            }

            // 得到数字num
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                // 这步操作是 num是几位就得到几位的num。
                num = num * 10 + s.charAt(pos) - '0';
                pos++;
            }

            //按照题目意思，正常合法的表达式字符串的话，数字后面一定会是跟运算符。
            //所以这里判断运算符
            //这一步的终极目的是把栈里面全部变成+ 号的运算，
            switch (opt) {
                case '+':
                    val.push(num);
                    break;
                //- 号的时候变成负数
                case '-':
                    val.push(-num);
                    break;
                //乘号的时候出栈先做乘法运算后把得到的结果 再入栈
                case '*':
                    val.push(val.pop() * num);
                    break;
                //同上面的乘号
                case '/':
                    val.push(val.pop() / num);
                    break;
            }
            num = 0;
            if (pos < s.length()) {
                //数字后面有可能是运算符或者括号
                //如果下面没有被break，这里opt是取得的下一个运算符
                opt = s.charAt(pos);
                //如果这里是括号，就break，那么opt的值会在一开始被初始化成+
                if (s.charAt(pos) == '}' || s.charAt(pos) == ']' || s.charAt(pos) == ')') {
                    pos++;
                    break;
                }
            }
            pos++;
        }
        int sum = 0;
        while (!val.empty()) {
            sum += val.pop();
        }
        return sum;
    }
}