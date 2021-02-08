package com.company;
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class cFormUtama extends javax.swing.JFrame{
    BufferedImage Gambar;

    public void horizontalLine(int x,int y, int length, int Warna){
        for (x=x; x<=length; x++){
            Gambar.setRGB(x, y, Warna);
        }
    }

    public void verticalLine(int x, int y, int length, int Warna){
        for (y = y; y<=length; y++){
            Gambar.setRGB(x, y, Warna);
        }
    }

    public void DiagonalLine45 (int x, int y, int length, int Warna){
        x=x;
        y=y;
        for(int i=1; i<length; i++){
            Gambar.setRGB(x, y, Warna);
            x++;
            y++;
        }
    }

    public void Rectangle(int x1, int y1, int x2, int y2, int Warna){
        for (int x=x1; x < x2; x++){
            Gambar.setRGB(x, y1, Warna);
            Gambar.setRGB(x, y2, Warna);
        }

        for(int y= y1; y<y2; y++){
            Gambar.setRGB(x1, y, Warna);
            Gambar.setRGB(x2, y, Warna);
        }
    }

    public void FillRectangle(int x1, int y1, int x2, int y2, int Warna){
        for (int y=y1; y<y2; y++)
            for(int x=x1; x<x2; x++)
                Gambar.setRGB(x, y, Warna);
    }

    public void CustomDiagonalLine(int x1, int y1, int x2, int y2, int Warna){
        int dx, dy, xLength, yLength, Count, i;
        double x, y, rx, ry;

        x=x1;
        y=y1;
        dx=x2-x1;
        dy=y2-y1;
        xLength=Math.abs(dx);
        yLength=Math.abs(dy);

        if (xLength>yLength){
            rx=1;
            ry=Math.abs(yLength/xLength);
            Count=xLength;
        }
        else{
            rx=Math.abs(xLength/yLength);
            ry=1;
            Count=yLength;
        }
        if (dx<0) {
            rx = -rx;
        }
        if (dy<0){
            ry=-ry;
        }

        for(i=0; i< Count; i++){
            Gambar.setRGB((int)x, (int)y, Warna);
            x=x+rx;
            y=y+ry;
        }
    }

    public cFormUtama(){
        //int x, y, dx, dy, xLength, yLength, rx, ry, Warna = 0x00FF00;

        Gambar = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);

        horizontalLine(400, 500, 600, 0x00FF00);
        verticalLine(300, 200, 350, 0x00FF00);
        DiagonalLine45(50, 400, 400, Color.BLUE.getRGB());
        Rectangle(350, 200, 400, 250, Color.YELLOW.getRGB());
        FillRectangle(150, 200, 250, 300, Color.DARK_GRAY.getRGB());
        CustomDiagonalLine(500, 600, 700, 800, Color.MAGENTA.getRGB());
    }

    @Override
    public void paint(Graphics graphic){
        graphic.drawImage(Gambar, 0, 0, this);
    }
}
