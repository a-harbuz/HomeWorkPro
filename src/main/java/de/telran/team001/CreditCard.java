package de.telran.team001;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditCard {
    private String number;
    private String date;
    private String cvv;
}
