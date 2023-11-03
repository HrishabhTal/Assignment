package com.project.wallet.exchange;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Withdrawal {
    
    @Min(value = 0, message = "Enter a Valid Transaction")
    private Float amount;
}
