package journal.payloads;

import javax.validation.constraints.*;

/**
 * @author Evgeniy Ukhanov
 *
 */


public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;


    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
