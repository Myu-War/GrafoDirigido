/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import java.util.ArrayList;
import stackadt.StackADT;
import stackadt.Unchecked;

public class miPila implements StackADT {

    public ArrayList<Object> list;

    public miPila() {
        this.list = new ArrayList();
    }

    @Override
    public void push(Object elem) {
        list.add(elem);
    }

    @Override
    public Object pop() throws Unchecked {
        Object res;

        if (list.isEmpty()) {
            throw new Unchecked("La pila esta vacia.");
        }

        res = peek();
        list.remove(list.size() - 1);

        return res;
    }

    @Override
    public Object peek() throws Unchecked {
        if (list.isEmpty()) {
            throw new Unchecked("La pila esta vacia.");
        }

        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            cad.append("\n" + list.get(i));
        }
        cad.append("\n");
        
        return cad.toString();
    }

    @Override
    public boolean evaluaParentesis(String stringEntrante) {
        char charLector;
        boolean veredicto = true;

        stringEntrante.replaceAll(" ", "");
        for (int i = 0; i < stringEntrante.length(); i++) {
            charLector = stringEntrante.charAt(i);
            if (charLector == '(') {
                push(charLector);
            } else if (charLector == ')') {
                if (isEmpty()) {
                    veredicto = false;
                } else {
                    pop();
                }
            }
        }
        if (!isEmpty()) {
            veredicto = false;
        }

        return veredicto;
    }
}