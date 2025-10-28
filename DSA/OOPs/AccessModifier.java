//Access defined of any objects
public class AccessModifier {
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Jaykant";
        // myAcc.password = "jay7462@@"; // directly not access
        myAcc.setPass( "Jaykant@@"); // don't access but only set password
        // System.out.println(myAcc.password);
    }
}

class BankAccount {
    public String username;
    private String password;
    public void setPass(String pwd){
        password = pwd;
    }
}
