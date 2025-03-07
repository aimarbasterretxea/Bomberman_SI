package Eredua;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teklatua implements KeyListener {
	//Atributuak
	private static Teklatua nireTeklatua = null;
	private Scanner sc;
	
	//Eraikitzailea
	private Teklatua() {}

	//Geterra
	public static Teklatua getNireTeklatua() {
		if (nireTeklatua == null) {
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua; 
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
