package model;

import enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserData {
    String email;
    String invalidUsername;
    String validUsername;
    String country;
    @ToString.Exclude
    String invalidPassword;
    @ToString.Exclude
    String validPassword;
    String middleName;
    String firstName;
    String lastName;
    String
}
