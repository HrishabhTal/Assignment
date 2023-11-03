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
public class Wallettdo {
    private Integer id;
    
    private String name;

    private Float balance;
}
