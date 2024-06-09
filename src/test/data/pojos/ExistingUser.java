package data.pojos;

public class ExistingUser {
    private String usernameCredential;
    private String passwordCredential;


    public ExistingUser(String usernameCredential, String passwordCredential) {
        this.usernameCredential = usernameCredential;
        this.passwordCredential = passwordCredential;
    }

    public String getUsernameCredential() {
        return usernameCredential;
    }

    public String getPasswordCredential() { return passwordCredential; }

    public void setUsernameCredential(String usernameCredential) {
        this.usernameCredential = usernameCredential;
    }

    public void setPasswordCredential(String passwordCredential) {
        this.passwordCredential = passwordCredential;
    }
}
