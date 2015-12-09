package grafos;

public class NodoGrafoD<T> {
    private T elem;
    private int id = -1;
    private boolean visitado;

    public NodoGrafoD() {
        this.elem = null;
        this.id = this.id + 1;
        this.visitado = false;
    }

    public NodoGrafoD(T elem) {
        this.elem = elem;
        this.id = this.id + 1;
    }
    
    public NodoGrafoD(T elem, int num) {
        this.elem = elem;
        this.id = num;
    }

    public T getElem() {
        return elem;
    }

    public int getNum() {
        return id;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "Nodo{" + "elem=" + elem + ", visitado=" + visitado + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoGrafoD<?> other = (NodoGrafoD<?>) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }   
}