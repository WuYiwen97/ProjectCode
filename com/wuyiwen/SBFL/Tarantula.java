package com.wuyiwen.SBFL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tarantula {
    //计算复杂度Ochiai
    public static List<Double> calculateTarantula(String [][] arr){
        //TODO 先得到有多少代码行
        int codeLine=arr[0].length;
        //TODO 结果在二维数组里面
        int[][] NpsOrNfs =new int[codeLine][2];
        //TODO 计算结果在list里面
        List<Double> resultList=new ArrayList<>();

        Map<Integer,Double> resultMap=new HashMap();
        //长度 length 行数 line
        //列数 row
        /*System.out.println(arr.length);
        for (int line=0;line<arr.length;line++){
            for(int row=0;row<arr[line].length;row++){
                System.out.print(arr[line][row]+"["+line+","+row+"]");
            }
            System.out.println("");
        }*/
        for (int line=0;line<arr.length;line++){
            int Nps=0;
            int Nfs=0;
            //TODO 最后一个为+  成功Nps  1
            if (arr[line][arr[line].length-1].equals("+")){
                System.out.println("line"+line +"is "+arr[line][arr[line].length-1]);
                //TODO 循环
                for(int row=0;row<arr[line].length;row++){
                    if (arr[line][row].equals("1")) {
                        NpsOrNfs[row][1]++;
                    }
                }
            }
            //TODO 最后为- 失败 覆盖失败+1Nfs 0
            else if (arr[line][arr[line].length-1].equals("-")){
                System.out.println("line"+line +"is "+arr[line][arr[line].length-1]);
                //TODO 循环
                for(int row=0;row<arr[line].length;row++){
                    if (arr[line][row].equals("1")) {
                        NpsOrNfs[row][0]++;
                    }
                }
            }
        }
        //TODO 计算在这里
        for(int index=0;index<NpsOrNfs.length;index++){
            Double ochiai =  (double) NpsOrNfs[index][0] / Math.sqrt((double) NpsOrNfs[index][0] *((double) NpsOrNfs[index][0]+(double) NpsOrNfs[index][1]));
            if (ochiai.isNaN() || ochiai.isInfinite()) {
                ochiai = 0.0;
            }
            resultList.add(ochiai);
        }
        //TODO 输入结果
        for (int index =0;index<resultList.size();index++){
            System.out.println("line "+(index+1)+" ochiai is "+resultList.get(index)+"\t");
        }
        return  resultList;
    }

}
