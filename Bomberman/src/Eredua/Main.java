package Eredua;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Jokua.getJokua().Hasieraketa();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
