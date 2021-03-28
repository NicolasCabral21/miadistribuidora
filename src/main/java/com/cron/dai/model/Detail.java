package com.cron.dai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Detail {
    private String currency;
    private String bid_currency;
    private String ask_currency;
    private String purchase_price;
    private String selling_price;
    private String market_identifier;
}
