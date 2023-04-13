package com.usergio.retos.retoapp.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Mensaje {
    private int httpCode;
    private String mensaje;
}
