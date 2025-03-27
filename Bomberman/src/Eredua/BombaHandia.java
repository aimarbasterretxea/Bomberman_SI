package Eredua;

import java.util.ArrayList;

public class BombaHandia extends Bomba {
	
	@Override
	public ArrayList<int[]> kalkulatuKoordenatuak(int pX, int pY) {
	    ArrayList<int[]> sutea = new ArrayList<>();
	    int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	    // Bombaren erdigunea gehitu
	    sutea.add(new int[]{pX, pY});

	    // Lau norabideak gehitu
	    for (int[] norabidea : norabideak) {
	        boolean jarraitu = true;  // 这里每次循环重新初始化
	        for (int i = 1; i < 10 && jarraitu; i++) { // i=1，避免重复计算中心点
	            int berriaX = pX + norabidea[0] * i;
	            int berriaY = pY + norabidea[1] * i;

	            // 先判断是否超出边界
	            if (berriaX < 0 || berriaX > 10 || berriaY < 0 || berriaY > 16) {
	                break;
	            }

	            // 遇到硬格子，停止该方向的遍历
	            if (!Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(berriaX, berriaY).hutsaDa()) {
	                jarraitu = false;
	            }

	            sutea.add(new int[]{berriaX, berriaY});
	            System.out.println("koordenatuak: " + berriaX + " " + berriaY);
	        }
	    }

	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;
	}

}
