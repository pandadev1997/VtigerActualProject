package com.crm.vtger.practice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		int a[]= {1,0,6,5,0,9,2,0,15};
		int b[]=new int[a.length];
		int m=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				b[m]=a[i];
				m++;
			}
		}
			for(int i=0;i<a.length;i++) {
				System.out.print(b[i]+" ");
			}
		
		
		}

	}


