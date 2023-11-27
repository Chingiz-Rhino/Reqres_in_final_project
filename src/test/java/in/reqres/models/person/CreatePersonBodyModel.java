package in.reqres.models.person;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class CreatePersonBodyModel {
    private String name;
    private String job;
}
