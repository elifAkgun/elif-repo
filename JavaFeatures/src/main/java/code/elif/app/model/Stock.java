package code.elif.app.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {

	private final String name;
	private final BigDecimal value;

	public Stock(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
	}
}
