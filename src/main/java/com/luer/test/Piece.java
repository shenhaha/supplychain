package com.luer.test;

import java.awt.Color;
import java.awt.Graphics2D;

class Piece extends Thing {
    Color traceColor;
    double velocityX, velocityY;

    Piece(Canvas canvas, Color traceColor, double originX, double originY,
          double velocity, double angle) {
        super(canvas);
        // System.out.println(
        // "sn,1011;color,"+color.getRGB()+";x,"+originX+",y"+originY+";v,"+velocity+";a,"+angle+";"
        // );
        color = Color.white;
        width = canvas.pieceWidth;
        height = canvas.pieceHeight;
        stateX = originX;
        stateY = originY;
        this.traceColor = traceColor;
        velocityX = velocity * Math.cos(angle);
        velocityY = velocity * Math.sin(angle);
    }

    @Override
    void draw(Graphics2D g, int time) {

        Trace trace = new Trace(this);
        trace.color = traceColor;
        canvas.things.add(trace);

        velocityX *= canvas.damp;

        velocityY += canvas.gravity;
        velocityY *= canvas.damp;

        stateY += velocityY;
        stateX += velocityX;

        // System.out.println(
        // "sn,1012;x,"+stateX+",y,"+stateY+";vx,"+velocityX+";vy,"+velocityY+";"
        // );
        g.fillRect((int) stateX, (int) stateY, width, height);

        color = new Color((int) (color.getRed() * canvas.pieceDarkerFactor),
                (int) (color.getGreen() * canvas.pieceDarkerFactor),
                (int) (color.getBlue() * canvas.pieceDarkerFactor));
        if (color.getRed() + color.getGreen() + color.getBlue() < 10)
            stateDead = true;

    }

}
