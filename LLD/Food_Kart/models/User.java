package models;

import enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    String name;
    Gender gender;
    String phoneNumber;
    String pincode;
}
