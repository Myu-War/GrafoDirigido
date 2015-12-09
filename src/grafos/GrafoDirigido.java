/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import stackadt.miPila;

public class GrafoDirigido<T> {

    private ArrayList<ArrayList<Integer>> l;
    private int numelem;
    private int visitados;
    private ArrayList<NodoGrafoD> nodos;

    public GrafoDirigido() {
        this.l = new ArrayList<ArrayList<Integer>>();
        this.numelem = 0;
        this.visitados = 0;
        this.nodos = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getL() {
        return l;
    }

    public int getVisitados() {
        return visitados;
    }

    public int getNumelem() {
        return numelem;
    }

    public ArrayList<NodoGrafoD> getNodos() {
        return nodos;
    }

    public void add(T nuevo, ArrayList<Integer> newList, ArrayList<Integer> nodosAd) {//nodosAd es una lista del indice de los nodos que "apuntan" a n
        NodoGrafoD n = new NodoGrafoD(nuevo);
        ArrayList<Integer> x;

        nodos.add(n);

        if (newList == null) {
            x = new ArrayList<>();
            l.add(x);
        } else {
            l.add(newList);
        }
        if (nodosAd != null) {
            for (int i = 0; i < nodosAd.size(); i++) {
                l.get(nodosAd.get(i)).add(numelem);
            }
        }
        numelem++;
    }

    public void hallaCamino() {
        miPila p = new miPila();
        hallaCamino(0, 0, p, -1);
    }

    private void hallaCamino(int nodo, int nhijo, miPila p, int marca) {
        int k, ultimoPila, cc = marca, f = nhijo;//cc: Camino Corregido
        
        if (visitados >= numelem) {
            System.out.print("\nEl camino es:" + p);
            return;
        }
        if (nhijo >= l.get(nodo).size()) {
            if (visitados == numelem - 1 && l.get(nodo).size() == 0) {
                nodos.get(nodo).setVisitado(true);
                p.push(nodo);
                visitados++;
                hallaCamino(nodo + 1, 0, p, cc);
                return;
            } else {;
                if (l.get(nodo).size() == 0) {
                    f = l.get((int) p.peek()).indexOf(nodo);
                    hallaCamino((int) p.peek(), f + 1, p, cc);
                    return;
                } else {
                    //nodos.get((int) p.peek()).setVisitado(false);
                    if (cc != -1) {
                        nodos.get(cc).setVisitado(false);
                    }
                    cc = (int) p.pop();
                    visitados--;
                    if (p.size() == 0) {
                        for (int i = 0; i < nodos.size(); i++) {
                            nodos.get(i).setVisitado(false);
                        }
                        hallaCamino(nodo + 1, 0, p, -1);
                        return;
                    }
                    ultimoPila = (int) p.peek();
                    if (p.size() == 1) {
                        f = l.get(ultimoPila).indexOf(cc);
                        for (int i = 0; i < f; i++) {
                            nodos.get(l.get(ultimoPila).get(i)).setVisitado(true);
                        }
                    }
                    hallaCamino(ultimoPila, f+1, p, cc);
                    return;
                }
            }
            //tengo que hacer algo mas aqui
        }
        k = l.get(nodo).get(nhijo);
        if (!nodos.get(nodo).isVisitado()) {
            nodos.get(nodo).setVisitado(true);
            p.push(nodo);
            visitados++;
        }
        //System.out.print("\nVisitados: "+visitados);
        if (nodos.get(k).isVisitado()) {
            if (p.size() == 1 && cc != -1) {
                f = l.get(nodo).indexOf(cc);
                for (int i = 0; i <= f; i++) {
                    nodos.get(l.get(nodo).get(i)).setVisitado(false);
                }
                cc = -1;
            }
            hallaCamino(nodo, f + 1, p, cc);
            return;
        }
        hallaCamino(k, 0, p, cc);
    }

    public String toString() {
        return numelem + "";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GrafoDirigido g = new GrafoDirigido();
        ArrayList<Integer> ln;
        ArrayList<Integer> li;

        g.add(0, null, null);

        ln = new ArrayList<Integer>();
        li = new ArrayList<Integer>();
        ln.add(0);
        li.add(0);
        g.add(1, ln, li);

        ln = new ArrayList<Integer>();
        li = new ArrayList<Integer>();
        ln.add(1);
        li.add(0);
        g.add(2, ln, li);

        ln = new ArrayList<Integer>();
        li = new ArrayList<Integer>();
        ln.add(2);
        li.add(1);
        g.add(3, ln, li);

        li = new ArrayList<Integer>();
        li.add(0);
        g.add(4, null, li);

        System.out.print(g.getL().get(0));
        g.hallaCamino();
    }

}
