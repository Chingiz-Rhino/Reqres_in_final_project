package in.reqres.models.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class AuthorizationBodyModel {
   private String email;
   private String password;
}
