package com.project.wallet.exchange;

import jakarta.validation.constraints.Max;
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
public class Deposit {
    
    @Min(value = 0, message = "Enter a Valid Transaction")
    @Max(value = 40000, message = "Limit exceeded")
    private Float amount; 
}
