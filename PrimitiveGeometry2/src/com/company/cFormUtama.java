package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;

public class cFormUtama extends javax.swing.JFrame {
    BufferedImage Gambar;
    int width = 1000;
    int height = 1000;

//    int[] polygonX = {270, 200, 220, 280, 300};
//    int[] polygonY = {10, 60, 110, 110, 60};

//    int[] polygonX = {300, 250, 270, 330, 350};
//    int[] polygonY = {60, 110, 160, 160, 110};

//    int[] polygonX = {500, 600, 600, 400, 400};
//    int[] polygonY = {300, 400, 500, 500, 400};

    int[] polygonX = {400, 600, 800, 600, 400, 200};
    int[] polygonY = {100, 100, 300, 500, 500, 300};

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

    public void circle(int centerX, int centerY, double radius, int color){
        double angle = 0;
        int xC, yC, xS, yS;
        double alpha;
        while(angle<= 360){
            alpha = angle * Math.PI/180;
            xC = (int) (radius * Math.cos(alpha));
            yC = (int) (radius * Math.sin(alpha));
            xS = centerX + xC;
            yS = centerY - yC;
            Gambar.setRGB(xS, yS, color);
            angle = angle + 30 / radius;
        }
    }

    public void drawArc(int centerX, int centerY, double radius, int startAngle, int sweepAngle, int color){
        double angle = startAngle;
        int xC, yC, xS, yS;
        double alpha;
        while(angle<= startAngle+sweepAngle){
            alpha = angle * Math.PI/180;
            xC = (int) (radius * Math.cos(alpha));
            yC = (int) (radius * Math.sin(alpha));
            xS = centerX + xC;
            yS = centerY - yC;
            Gambar.setRGB(xS, yS, color);
            angle = angle + 30 / radius;
        }
    }

    public void ellipse(int centerX, int centerY, double radiusX, double radiusY, int color){
        double angle = 0;
        int xC, yC, xS, yS;
        double alpha, radius;
        if (radiusX < radiusY){
            radius = radiusX;
        }
        else{
            radius = radiusY;
        }
        while(angle<= 360){
            alpha = angle * Math.PI/180;
            xC = (int) (radiusX * Math.cos(alpha));
            yC = (int) (radiusY * Math.sin(alpha));
            xS = centerX + xC;
            yS = centerY - yC;
            Gambar.setRGB(xS, yS, color);
            angle = angle + 30 / radius;
        }
    }

    public void fillGeometry(int x, int y, int color){
            int bgColor = Gambar.getRGB(x, y);
            boolean loopY, loopX;
            loopY = true;
            int x1, y1, x2 = 0, y2;
            y1 = y;
            while (y1 > 0 && loopY){
                loopX = true;
                x1 = x;
                while (x1 > 0 && loopX){
                    if(Gambar.getRGB(x1, y1) != bgColor){
                        loopX=false;
                    }
                    else {
                        Gambar.setRGB(x1, y1, color);
                    }
                    x1--;
                }
                while (x2<WIDTH && loopX){
                    if(Gambar.getRGB(x2, y1) != bgColor){
                        loopX=false;
                    }
                    else{
                        Gambar.setRGB(x2, y1, color);
                    }
                    x2++;
                }
                y1--;
                if(Gambar.getRGB(x, y1) != bgColor){
                    loopY=false;
                }
            }
            loopY = true;
            y2 = y+1;
            while (y2<HEIGHT && loopY){
                loopX = true;
                x1 = x;
                while (x1>0 && loopX){
                    if(Gambar.getRGB(x1, y2) != bgColor){
                        loopX=false;
                    }
                    else{
                        Gambar.setRGB(x1, y2, color);
                    }
                    x1--;
                }
                x2 = x+1;
                while (x2<WIDTH && loopX){
                    if(Gambar.getRGB(x2, y2) != bgColor){
                        loopX=false;
                    }
                    else{
                        Gambar.setRGB(x2, y2, color);
                    }
                    x2++;
                }
                y2++;
                if(Gambar.getRGB(x, y2) != bgColor){
                    loopY=false;
                }
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

    public void polygon(int[] polygonX, int[] polygonY, int jlhSegi, int color){
        int var;
        for (int i = 0; i < jlhSegi-1; i++){
            CustomDiagonalLine(polygonX[i], polygonY[i],polygonX[i+1], polygonY[i+1], color);
        }
        CustomDiagonalLine(polygonX[jlhSegi-1], polygonY[jlhSegi-1],polygonX[0], polygonY[0], color);
    }

    public  cFormUtama(){
        Gambar = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        circle(400, 300, 200, Color.BLUE.getRGB());
        drawArc(800, 500, 200, 90, 90, Color.MAGENTA.getRGB());
        ellipse(400, 300, 300, 200, Color.RED.getRGB());
        polygon(polygonX, polygonY, 5, Color.CYAN.getRGB());
        Rectangle(200, 400, 350, 450, Color.MAGENTA.getRGB());
        fillGeometry(349, 449, Color.GREEN.getRGB());
    }

    @Override
    public void paint(Graphics graphic){
        graphic.drawImage(Gambar, 0, 0, this);
    }
}
