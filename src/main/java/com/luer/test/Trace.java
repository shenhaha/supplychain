package com.luer.test;

import java.awt.Color;
import java.awt.Graphics2D;

class Trace extends Thing {

    double velocityX, velocityY;

    Trace(Thing thing) {
        super(thing.canvas);
        this.color = thing.color;
        this.width = thing.width;
        this.height = thing.height;
        stateX = thing.stateX;
        stateY = thing.stateY;
    }

    @Override
    void draw(Graphics2D g, int time) {

        g.fillRect((int) stateX, (int) stateY, width, height);

        color = new Color((int) (color.getRed() * canvas.traceDarkerFactor),
                (int) (color.getGreen() * canvas.traceDarkerFactor),
                (int) (color.getBlue() * canvas.traceDarkerFactor));
        if (color.getRed() + color.getGreen() + color.getBlue() < 10)
            stateDead = true;

    }

}

/*
写字楼里写字间，写字间里程序员；
程序人员写程序，又拿程序换酒钱。
酒醒只在网上坐，酒醉还来网下眠；
酒醉酒醒日复日，网上网下年复年。
但愿老死电脑间，不愿鞠躬老板前；
奔驰宝马贵者趣，公交自行程序员。
别人笑我忒疯癫，我笑自己命太贱；
不见满街漂亮妹，哪个归得程序员？*/
