package com.elroykanye.sadues.api.dto.response;

import java.io.Serializable;

public record ExceptionResponse (
        String message,
        String path

) implements Serializable {

}
