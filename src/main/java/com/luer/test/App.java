package com.luer.test;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Applet {
    @Override
    public void init() {
        Canvas canvas = new Canvas();
        canvas.setSize(getWidth(), getHeight());
        add(canvas);
        canvas.gravity = Double.parseDouble(getParameter("gravity")) / 100;
        canvas.damp = Double.parseDouble(getParameter("damp")) / 100;
        canvas.skyrocketVelocity = Double
                .parseDouble(getParameter("skyrocketVelocity")) / -1;
        canvas.skyrocketWidth = Integer
                .parseInt(getParameter("skyrocketWidth"));
        canvas.skyrocketHeight = Integer
                .parseInt(getParameter("skyrocketHeight"));
        canvas.pieceNumber = Integer.parseInt(getParameter("pieceNumber"));
        canvas.pieceInitialVelocity = Double
                .parseDouble(getParameter("pieceInitialVelocity"));
        canvas.pieceDarkerFactor = Double
                .parseDouble(getParameter("pieceDarkerFactor")) / 100;
        canvas.pieceWidth = Integer.parseInt(getParameter("pieceWidth"));
        canvas.pieceHeight = Integer.parseInt(getParameter("pieceHeight"));
        canvas.traceDarkerFactor = Double
                .parseDouble(getParameter("traceDarkerFactor")) / 100;
        canvas.init();
    }
    /**从这里打开烟花程序*/
    public static void main(String[] args) throws Exception {

        Frame frame = new Frame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Canvas canvas = new Canvas();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.show();

        canvas.gravity = 1.0;
        canvas.damp = 0.75;
        canvas.skyrocketVelocity = -82;
        canvas.skyrocketWidth = 4;
        canvas.skyrocketHeight = 8;
        canvas.pieceNumber = 200;
        canvas.pieceInitialVelocity = 72;
        canvas.pieceDarkerFactor = 0.90;
        canvas.pieceWidth = 1;
        canvas.pieceHeight = 2;
        canvas.traceDarkerFactor = 0.70;
        canvas.frameDelay = 50;

        canvas.init();

    }

}

/*
  鼠标按下开始放焰火 松开鼠标键时焰火爆炸<br>
本程序运算量较大 请记得看完后关掉此页面 以免影响机器速度<br>
<br>
按键 Q/A : 增大/减小  重力加速度<br>
按键 W/S : 增大/减小  空气阻力<br>
按键 E/D : 增大/减小  爆竹的速度<br>
按键 R/F : 增大/减小  爆竹的宽度<br>
按键 T/G : 增大/减小  爆竹的高度<br>
按键 Y/H : 增大/减小  爆炸生成烟花的数目<br>
按键 U/J : 增大/减小  爆炸的力度<br>
按键 I/K : 增大/减小  烟花的亮度持续时间<br>
按键 O/L : 增大/减小  烟花的宽度<br>
按键 P/; : 增大/减小  烟花的高度<br>
按键 [/' : 增大/减小  烟花轨迹的长度<br>

      */
