package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CompanyCanteen {
    public static void main(String[] args) throws Exception{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(sc.readLine());
        for(int i =0; i<T; i++){
            int N = Integer.parseInt(sc.readLine());
            int[] tables = new int[N];
            String[] s = sc.readLine().split("");
            for(int j=0; j<N;j++){
                tables[j] = Integer.parseInt(s[j]);
            }
            int M = Integer.parseInt(sc.readLine());
            char[] queue = sc.readLine().toCharArray();
            //优先队列
            int[] res = getSeats(tables,queue);
            for(int v: res){
                wr.write(Integer.toString(v));
                wr.newLine();
            }
        }
        wr.flush();
    }
    static int[] getSeats(int[] tables, char[] queue){
        int[] res = new int[queue.length];
        int idx = 0;
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();
        list.add(new PriorityQueue<Integer>());//0位先进先出 靠左
        list.add(new PriorityQueue<Integer>());//1
        for(int i = 0; i < tables.length; i++){
            if(tables[i]<2)
                list.get(tables[i]).add(i);
        }
        for(int j = 0; j < queue.length; j++){
            if(queue[j]=='M'){//先1后0
                if(!list.get(1).isEmpty()){
                    int table = list.get(1).poll();
                    res[idx++] = table+1;
                }else{
                    int table = list.get(0).poll();
                    res[idx++] = table+1;
                    list.get(1).add(table);
                }
            }else{//先0后1
                if(!list.get(0).isEmpty()){
                    int table = list.get(0).poll();
                    res[idx++] = table+1;
                    list.get(1).add(table);
                }else{
                    int table = list.get(1).poll();
                    res[idx++] = table+1;
                }
            }
        }
        return res;
    }
}
