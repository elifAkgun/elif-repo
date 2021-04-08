package code.elif;

public class Vault {
    private int password;

    public boolean isPasswordCorrect(int guess){
        return password == guess;
    }

    public Vault(int password){
        this.password = password;
    }
}
