package federicolepore.exeptions;

import java.time.LocalDate;

public class NotFoundExceptionByExpDate extends RuntimeException {
    public NotFoundExceptionByExpDate(LocalDate day) {
        super("Non è stato trovato nessun prestito scaduto per il giorno: " + day);
    }
}
