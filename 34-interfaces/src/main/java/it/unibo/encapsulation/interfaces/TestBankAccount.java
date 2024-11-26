package it.unibo.encapsulation.interfaces;

public class TestBankAccount {
    private static final int INTIAL_AMOUNT = 10000;
    private static final int WITHDRAW_AMOUNT = 15000;
    private static final String ACCOUNT = "'s account balance is ";

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        final AccountHolder aRossi = new AccountHolder("Andrea", "Rossi", 1);
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        final AccountHolder aBianchi = new AccountHolder("Alex", "Bianchi", 2);
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        final BankAccount rossisAccount = new SimpleBankAccount(aRossi.getUserID(), 0);
        final BankAccount bianchisAccount = new StrictBankAccount(aBianchi.getUserID(), 0);
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         * 
         * Entrambe implementano la stessa interfaccia!
         */
        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        rossisAccount.deposit(aRossi.getUserID(), INTIAL_AMOUNT);
        bianchisAccount.deposit(aBianchi.getUserID(), INTIAL_AMOUNT);
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        rossisAccount.withdraw(aRossi.getUserID(), WITHDRAW_AMOUNT);
        bianchisAccount.withdraw(aBianchi.getUserID(), WITHDRAW_AMOUNT);
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        System.out.println(aRossi.getName() + " " + aRossi.getSurname() + ACCOUNT + rossisAccount.getBalance());
        System.out.println(aBianchi.getName() + " " + aBianchi.getSurname() + ACCOUNT + bianchisAccount.getBalance());
        /*
         * 8) Qual è il risultato e perché?
         * 
         * Nel conto di Bianchi non si può andare in rosso
         */
        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        rossisAccount.deposit(aRossi.getUserID(), INTIAL_AMOUNT);
        bianchisAccount.deposit(aBianchi.getUserID(), INTIAL_AMOUNT);
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        rossisAccount.chargeManagementFees(aRossi.getUserID());
        bianchisAccount.chargeManagementFees(aBianchi.getUserID());
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        System.out.println(aRossi.getName() + " " + aRossi.getSurname() + ACCOUNT + rossisAccount.getBalance());
        System.out.println(aBianchi.getName() + " " + aBianchi.getSurname() + ACCOUNT + bianchisAccount.getBalance());
        /*
         * 12) Qual è il risultato e perché?
         * 
         * Non essendo stati scalati i soldi, Bianchi ha quasi 20000 euro. Quasi perché
         * ha costi di gestione.
         */
    }
}
