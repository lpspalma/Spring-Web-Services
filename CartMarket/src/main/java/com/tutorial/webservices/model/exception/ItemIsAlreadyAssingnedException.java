package com.tutorial.webservices.model.exception;

import java.text.MessageFormat;

public class ItemIsAlreadyAssingnedException  extends RuntimeException {
    public ItemIsAlreadyAssingnedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Item {0} is already assigned to cart {1}.",
                itemId,cartId));
    }
}
