package com.project.wallet.exchange;

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
public class Transactiontdo {
    private int id;

    private String name;

    private float amount;

    private String type;
}
