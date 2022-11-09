package com.chengdu.leetcode.algorithm.sorts;

import java.util.ArrayList;

// 选择排序
// 时间复杂度  n + （n- 1） + ... + 1   O(n2)
// 空间复杂度  O（1）
public class SelectSorts {

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
        SelectSorts sorts = new SelectSorts();
        sorts.initData();
        System.out.println("base = " + sorts.mList);

        sorts.toSort(true);  // 递增
        System.out.println("result = " + sorts.mList);

        sorts.toSort(false);  // 递减
        System.out.println("result = " + sorts.mList);
    }

    /**
     * 选择排序
     *
     * @param type 排序类型 ture：递增  false：递减
     */
    public void toSort(Boolean type) {
        // 这里实现选择排序
        if (mList != null && mList.size() >= 2) {  // 边界值判断
            for (int i = 0; i < mList.size(); i++) {  // 每次找到 n - i 中最大/最小的元素
                for (int j = (mList.size() - i - 1); j >= 0; j--) {
                    int keyIndex = mList.size() - i - 1;  // 找到最小 / 最大值
                    if (type) {  // 递增找最小值
                        if (mList.get(j) < mList.get(keyIndex)) {
                            swap(j, keyIndex);
                        }
                    } else {  // 递减找最大值
                        if (mList.get(j) > mList.get(keyIndex)) {
                            swap(j, keyIndex);
                        }
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
