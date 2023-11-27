package in.reqres.models.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegistrationBodyModel {
    private String email;
    private String password;
}
