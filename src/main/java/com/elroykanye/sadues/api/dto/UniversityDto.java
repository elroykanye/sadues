package com.elroykanye.sadues.api.dto;

import java.io.Serializable;

public record UniversityDto(Long id, String name, String location) implements Serializable {
}
