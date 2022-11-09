package com.chengdu.leetcode.algorithm.sorts;

import java.util.ArrayList;

/**
 * 插入排序
 */
public class InsertSorts {
    public ArrayList<Integer> mList = new ArrayList<Integer>();

    public ArrayList<Integer> mResultList = new ArrayList<>();


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
        InsertSorts sorts = new InsertSorts();
        sorts.initData();
        System.out.println("base = " + sorts.mList);

        sorts.toSort(true);  // 递增
        System.out.println("result up = " + sorts.mResultList);

        sorts.toSort(false);  // 递减
        System.out.println("result dec = " + sorts.mResultList);
    }

    public void toSort(boolean type){
        mResultList.clear();
        for (int i = 0; i < mList.size(); i++){
            for (int j = 0; j < mResultList.size(); j++){
                if (type){
                    if (mResultList.get(j) >= mList.get(i)){
                        mResultList.add(j, mList.get(i));
                        break;
                    }
                }else{
                    if (mResultList.get(j) <= mList.get(i)){
                        mResultList.add(j, mList.get(i));
                        break;
                    }
                }
            }
            if (mResultList.size() == i){
                mResultList.add(mResultList.size(), mList.get(i));
            }

        }
    }

}
