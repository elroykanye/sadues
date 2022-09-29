package com.elroykanye.sadues.api.dto.response;

import java.io.Serializable;

public record SaResponse (
        Object id,
        String message
) implements Serializable {

}
