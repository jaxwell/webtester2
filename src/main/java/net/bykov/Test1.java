package net.bykov;

import net.bykov.entities.Test;

/**
 * Created by Ievgen on 01/31/2015.
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    static class Test2 extends Test1 {
        public static void main(String[] args) {
            System.out.println("By");
        }
    }
}
