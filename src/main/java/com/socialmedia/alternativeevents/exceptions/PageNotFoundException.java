package com.socialmedia.alternativeevents.exceptions;

import java.math.BigInteger;

public class PageNotFoundException extends RuntimeException {
	PageNotFoundException(BigInteger theId){
		super("Page could not be loaded with id - " + theId);
	}
}
