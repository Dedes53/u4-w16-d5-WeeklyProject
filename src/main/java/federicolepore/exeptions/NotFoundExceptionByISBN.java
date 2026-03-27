package federicolepore.exeptions;

public class NotFoundExceptionByISBN extends RuntimeException {
    public NotFoundExceptionByISBN(long isbn) {
        super("La risorsa con codice ISBN " + isbn + " non è stata trovata!");
    }
}