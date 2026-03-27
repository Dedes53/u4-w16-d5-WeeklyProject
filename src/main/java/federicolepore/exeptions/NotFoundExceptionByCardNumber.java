package federicolepore.exeptions;

public class NotFoundExceptionByCardNumber extends RuntimeException {
    public NotFoundExceptionByCardNumber(long cardNumber) {
        super("Non sono state trovate letture attualmente in prestito associate a questo numero di carta " + cardNumber);
    }
}
