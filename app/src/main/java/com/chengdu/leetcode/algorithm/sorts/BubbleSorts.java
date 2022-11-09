package com.chengdu.leetcode.algorithm.sorts;

import java.util.ArrayList;

// 冒泡排序
public class BubbleSorts {

    public ArrayList<Integer> mList = new ArrayList<Integer>();

    public void initData() {
        mList.add(1);
        mList.add(4);
        mList.add(2);
        mList.add(9);
        mList.add(4);
        mList.add(5);
        mList.add(6);
        mList.add(8);
        mList.add(9);
        mList.add(34);
        mList.add(2);
    }


    public void test() {
        BubbleSorts sorts = new BubbleSorts();
        sorts.initData();
        System.out.println("base = " + sorts.mList);

        sorts.toSort(true);  // 递增
        System.out.println("result up = " + sorts.mList);

        sorts.toSort(false);  // 递减
        System.out.println("result dec = " + sorts.mList);
    }

    /**
     * ，冒泡排序
     * @param type 排序类型 ture 升序  false 降序
     */
    public void toSort(boolean type){
        for (int i = 0; i < mList.size(); i++){  // 冒泡外层次数
            for (int j = 1; j < mList.size() - i; j++){  // 冒泡开始
                if (type){  // 升序
                    if (mList.get(j - 1) > mList.get(j)){
                        swap(j - 1, j);
                    }
                }else{
                    if (mList.get(j - 1) < mList.get(j)){
                        swap(j - 1, j);
                    }
                }
            }
        }
    }

    public void swap(int i, int j) {
        int save = mList.get(i);
        mList.set(i, mList.get(j));
        mList.set(j, save);
    }

}
