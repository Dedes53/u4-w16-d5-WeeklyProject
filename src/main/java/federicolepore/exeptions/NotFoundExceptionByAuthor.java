package federicolepore.exeptions;

public class NotFoundExceptionByAuthor extends RuntimeException {
    public NotFoundExceptionByAuthor(String author) {
        super("La risorsa con autore: " + author + " non è stata trovata!");
    }
}
