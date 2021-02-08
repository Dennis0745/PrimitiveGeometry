package com.company;

import javax.swing.*;

public class Main {
    public static cFormUtama FrmUtama;
    public static void main(String[] args) {
	    FrmUtama = new cFormUtama();
	    FrmUtama.setVisible(true);
		FrmUtama.setExtendedState(JFrame.MAXIMIZED_BOTH);
		FrmUtama.setUndecorated(true);
    }
}
