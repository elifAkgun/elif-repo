package com.elif.websocket.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MySimplePojo {
	private String name;
	private String email;
	private String comment;

	@Override
	public String toString() {
		return String.format("User %s with email %s says %s", getName(), getEmail(), getComment());
	}
}
