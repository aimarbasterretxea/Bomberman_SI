package Eredua;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Jokua.getJokua().hasieraketa();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
