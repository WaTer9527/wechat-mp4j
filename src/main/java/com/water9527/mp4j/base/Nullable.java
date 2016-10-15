package com.water9527.mp4j.base;

public interface Nullable {

	default boolean isNull() {
		return false;
	}
	
}
