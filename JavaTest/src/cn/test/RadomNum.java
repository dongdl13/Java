package cn.test;

import java.util.Scanner;

public class RadomNum {
	public static void main(String[] args) {
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("你的选择：1、抽将 2、退出");
			String chooseNum = scanner.nextLine();
			if("1".equals(chooseNum)){
				int ranNum = (int)(Math.random()*10);
				System.out.println("您抽到数字："+ranNum);
				if(ranNum == 5){
					System.out.println("恭喜你中奖了！你屁颠屁颠地回家了\n");
					return;
				}else{
					System.out.println("很可惜，你与大奖擦肩而过\n");
				}
			}else if("2".equals(chooseNum)){
				System.out.println("你真的要放弃梦想吗? 1、狠心放弃 2、再战一百回合");
				chooseNum = scanner.nextLine();
				if("1".equals(chooseNum)){
					return;
				}
				else if("2".equals(chooseNum)){
					System.out.println();
					continue;
				}
			}
		}
	}
}
