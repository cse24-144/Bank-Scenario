import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void  main(String[] args){
        System.out.print("Hello and welcome!");
        System.out.println();
        //testing if the classes n stuff work
        Customer Jack = new Customer("Jack","Jackerson","Block 9",67);
        SavingsAccount JackSvgs = new SavingsAccount(567,678.98,"FNB Block 9",Jack );
        ArrayList<Account> JacksAccounts = new ArrayList<Account>();
        JacksAccounts.add(JackSvgs);
        Jack.setAccounts(JacksAccounts);
        System.out.println(JacksAccounts.getFirst().getAccountNumber());
    }
}