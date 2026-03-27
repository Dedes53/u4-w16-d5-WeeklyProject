package federicolepore.exeptions;

public class NofFoundExceptionByTitle extends RuntimeException {
    public NofFoundExceptionByTitle(String title) {
        super("Letture con titolo: " + title + " non sono state trovate");
    }
}
