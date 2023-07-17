package com.example.xiaoheihe.TestMain;

import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.utils.RsaUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入start开始计算,如需退出请输入q");
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.equals("start")){
                System.out.println("开始计算,请输入数量");
                continue;
            }
            if (input.equals("q")){
                break;
            }
            int n = Integer.parseInt(input);
            System.out.println(generateParenthesis(n).toString());
        }

    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    // (((
    public static void backtrack(List<String> ans, StringBuilder cur, int leftCount, int rightCount, int max){
        //达到最长字符串放入list
        if (max * 2 == cur.length()){
            ans.add(cur.toString());
            return;
        }
        //左边的数量小于最大字符串 则往里面增加 ""->"("
        if (leftCount < max){
            cur.append('(');
            backtrack(ans,cur,leftCount+1,rightCount,max);
            cur.deleteCharAt(cur.length()-1);
        }
        //左边的数量大于右边 左边减一个 右边加一个  "(" -> "()"
        if (leftCount > rightCount){
            cur.append(')');
            backtrack(ans,cur,leftCount,rightCount+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
        //左等于右则平衡
    }
}
