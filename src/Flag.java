/**
 * <h1>Flag</h1>
 * Class used to modify a boolean when passed as a method's argument.
 */

public class Flag {
    private boolean aux;

    /**
     * Constructor method.
     * @param aux The initial value of aux.
     */
    public Flag(boolean aux) {
        this.aux = aux;
    }

    /**
     * Setter function for aux.
     * @param aux The value which aux will get.
     */
    public void setAux(boolean aux) {
        this.aux = aux;
    }

    /**
     * Getter function of aux.
     * @return boolean This will have the same logical value as aux.
     */
    public boolean getAux() {
        return aux;
    }
}
