package com.company.drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {

    private PixelDrawer pd;
    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;
        dx = x2 - x1;
        dy = y2 - y1;
        incx = Integer.compare(dx, 0);
        incy = Integer.compare(dy, 0);
        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;
        if (dx > dy) {
            pdx = incx; pdy = 0;
            es = dy; el = dx;
            x = x1;
            y = y1;
            err = el/2;
            pd.drawPixel(x, y, Color.RED);

            for (int t = 0; t < el; t++) {
                err -= es;
                if (err < 0) {
                    err += el;
                    x += incx;
                    y += incy;
                } else {
                    x += pdx;
                    y += pdy;
                }
                pd.drawPixel(x, y, Color.RED);
            }
        } else {
            pdx = 0; pdy = incy;
            es = dx; el = dy;
            x = x1;
            y = y1;
            err = el/2;
            pd.drawPixel(x, y, Color.BLUE);

            for (int t = 0; t < el; t++) {
                err -= es;
                if (err < 0) {
                    err += el;
                    x += incx;
                    y += incy;
                } else {
                    x += pdx;
                    y += pdy;
                }
                pd.drawPixel(x, y, Color.BLUE);
            }
        }
    }


    //Метод, устанавливающий пиксель на форме с заданными цветом и прозрачностью
    /*
    private static void PutPixel(Graphics g, Color col, int x, int y, int alpha){
        g.FillRectangle(new SolidBrush(Color.FromArgb(alpha, col)), x, y, 1, 1);
    }

    //Целая часть числа

    private static int IPart(float x){
        return (int)x;
    }

    
    //дробная часть числа
    
    private static float FPart(float x){
        while (x >= 0)
        x--;
        x++;
        return x;
    }
    */
}
