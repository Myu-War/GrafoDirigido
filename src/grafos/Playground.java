/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

public class Playground {

    public static void main(String[] args) {
        GrafoDirigido g = new GrafoDirigido();
        ArrayList<Integer> ln;//a los que apunta
        ArrayList<Integer> li;//los que me apuntan

        g.add(0, null, null);

        li = new ArrayList<Integer>();
        li.add(0);
        g.add(1, null, li);

        li=new ArrayList<Integer>();
        li.add(0);
        g.add(2, null, li);

        li = new ArrayList<Integer>();
        li.add(1);
        li.add(2);
        g.add(3, null, li);

        ln= new ArrayList<Integer>();
        li = new ArrayList<Integer>();
        li.add(3);
        ln.add(1);
        ln.add(2);
        g.add(4, ln, li);

        System.out.print(g.getL().get(4));
        g.hallaCamino();
    }
}
