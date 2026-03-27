package federicolepore.exeptions;

public class NotFoundExceptionByYear extends RuntimeException {
    public NotFoundExceptionByYear(int year) {
        super("La risorsa pubblicata nell'anno " + year + " non è stata trovata!");
    }
}
