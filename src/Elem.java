public class Elem {
    private int[] prim;
    private int maxi;

    public Elem(int[] prim, int maxi) {
        this.prim = prim;
        this.maxi = maxi;
    }

    public Elem(int meddig) {
        this.prim = new int[meddig];
        this.maxi = 2;
    }

    public int[] getPrim() {
        return prim;
    }
    public int getPrimInPosicion(int pozicio) {
        return prim[pozicio];
    }
    public void setPrimInAPosicion(int pozicion,int value) {
        this.prim[pozicion] = value;
    }
    public void setPrim(int[] prim) {
        this.prim = prim;
    }

    public int getMaxi() {
        return maxi;
    }

    public void setMaxi(int maxi) {
        this.maxi = maxi;
    }
}
