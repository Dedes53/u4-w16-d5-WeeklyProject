SPIEGAZIONE DIAGRAMMA ER

- libri e riviste erreditano da lettura, quindi relazione join tra le tabelle.

- prestito avrà una relazione ManyToOne sia verso Utente che verso Letture. Storicamente un Utente può fare più di un prestito e una Lettura può essere prestata più di una volta. Si dovrebbe avere l'accortezza di non permettere un nuovo prestito se non è ancora stata restituita. Stesso discorso se l'utente puù avere in prestito solo una lettura alla volta.