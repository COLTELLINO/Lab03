package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {

        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        final AccountHolder aRossi = new AccountHolder("Andrea", "Rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        final AccountHolder aBianchi = new AccountHolder("Alex", "Bianchi", 2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        final SimpleBankAccount rossisAccount = new SimpleBankAccount(aRossi.getUserID(), 0);
        final SimpleBankAccount bianchisAccount = new SimpleBankAccount(aBianchi.getUserID(), 0);

        // 4) Effettuare una serie di depositi e prelievi
        rossisAccount.deposit(aRossi.getUserID(), 10000);
        rossisAccount.depositFromATM(aRossi.getUserID(), 10000);
        bianchisAccount.deposit(aBianchi.getUserID(), 10000);
        bianchisAccount.depositFromATM(aBianchi.getUserID(), 10000);
        rossisAccount.withdrawFromATM(aRossi.getUserID(), 500);
        rossisAccount.withdraw(aRossi.getUserID(), 200);
        bianchisAccount.withdrawFromATM(aBianchi.getUserID(), 500);
        bianchisAccount.withdrawFromATM(aBianchi.getUserID(), 500);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("Account 1 balance is: " + rossisAccount.getBalance());
        System.out.println("Account 2 balance is: " + bianchisAccount.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato
        rossisAccount.withdraw(7, 340);
        bianchisAccount.deposit(8, 900);

        // 7) Controllare nuovamente l'ammontare
        System.out.println("\nAccount 1 balance is: " + rossisAccount.getBalance());
        System.out.println("Account 2 balance is: " + bianchisAccount.getBalance());
    }
}
