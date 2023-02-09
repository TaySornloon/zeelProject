package Automation_tasks.ui_task.page_class;

import java.awt.*;

public class JS {
    public static void main(String[] args) throws InterruptedException {
        mouseLocationSecond(10);
    }
    public static void mouseLocationSecond (int number) throws InterruptedException {
        while(number-->0) {
            Thread.sleep(1000);
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("X:" + x + ", Y:" + y);
        }
    }
}
