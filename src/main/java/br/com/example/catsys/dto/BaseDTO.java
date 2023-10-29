package br.com.example.catsys.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
public abstract class BaseDTO {
    private Long id;
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDTO baseDTO)) return false;
        return Objects.equals(getCode(), baseDTO.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}
