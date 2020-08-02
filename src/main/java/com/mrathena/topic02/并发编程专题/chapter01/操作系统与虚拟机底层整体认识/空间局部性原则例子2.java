package com.mrathena.topic02.并发编程专题.chapter01.操作系统与虚拟机底层整体认识;

public class 空间局部性原则例子2 {

	private static final int TIMES = 100;
	private static final int DIMENSION_2 = 1024 * 1024;
	private static final int DIMENSION_1 = 6;

	public static void main(String[] args) {
		/*
		 * 初始化数组
		 */
		long[][] longs = new long[DIMENSION_1][];
		for (int i = 0; i < DIMENSION_1; i++) {
			longs[i] = new long[DIMENSION_2];
			for (int j = 0; j < DIMENSION_2; j++) {
				longs[i][j] = 1L;
			}
		}
		System.out.println("Array初始化完毕....");
		long sum = 0L;
		long start = System.currentTimeMillis();
		for (int r = 0; r < TIMES; r++) {
			for (int i = 0; i < DIMENSION_1; i++) {//6
				for (int j = 0; j < DIMENSION_2; j++) {//1024 * 1024
					sum += longs[i][j];
				}
			}
		}
		System.out.println("spend time1:" + (System.currentTimeMillis() - start));
		System.out.println("sum1:" + sum);
		sum = 0L;
		start = System.currentTimeMillis();
		for (int r = 0; r < TIMES; r++) {
			for (int j = 0; j < DIMENSION_2; j++) {
				for (int i = 0; i < DIMENSION_1; i++) {
					sum += longs[i][j];
				}
			}
		}
		System.out.println("spend time2:" + (System.currentTimeMillis() - start));
		System.out.println("sum2:" + sum);
	}

}
