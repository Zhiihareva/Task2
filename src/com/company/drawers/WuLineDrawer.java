package com.company.drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {

    private PixelDrawer pd;
    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = (x2 > x1) ? (x2 - x1) : (x1 - x2);
        int dy = (y2 > y1) ? (y2 - y1) : (y1 - y2);
        if (dx == 0 || dy == 0) {
            if (dx == 0) {
                for (int i = Math.min(y1, y2); i < Math.max(y1, y2); i++) {
                    pd.drawPixel(x1, i, Color.blue);
                }
            } else {
                for (int i = Math.min(x1, x2); i < Math.max(x1, x2); i++) {
                    pd.drawPixel(i, y1, Color.RED);
                }
            }
            return;
        }

        if (dy < dx) {
            if (x2 < x1) {
                x2 += x1; x1 = x2 - x1; x2 -= x1;
                y2 += y1; y1 = y2 - y1; y2 -= y1;
            }
            float grad = (float)dy / dx;
            if(y2 < y1)
                grad=-grad;
            float intery = y1 + grad;
            pd.drawPixel(x1, y1, Color.RED);
            for (int x = x1 + 1; x < x2; x++) {
                pd.drawPixel(x, (int)intery, Color.RED);
                pd.drawPixel(x, (int)intery + 1, Color.RED);
                intery += grad;
                pd.drawPixel(x2, y2, Color.RED);
            }
        } else {
            if (y2 < y1) {
                x2 += x1; x1 = x2 - x1; x2 -= x1;
                y2 += y1; y1 = y2 - y1; y2 -= y1;
            }
            float grad = (float)dx / dy;
            if(x2 < x1)
                grad=-grad;
            float interx = x1 + grad;
            pd.drawPixel(x1, y1, Color.BLUE);
            for (int y = y1 + 1; y < y2; y++) {
                pd.drawPixel((int)interx, y, Color.BLUE);
                pd.drawPixel((int)interx + 1, y, Color.BLUE);
                interx += grad;
                pd.drawPixel(x2, y2, Color.BLUE);
            }
        }
    }
}
