package ru.ivonin.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank(message = "UID не должен быть пустым")
    @Size(max = 32, message = "UID должен содержать не более 32 символов")
    private String uid;

    @NotBlank(message = "Operation UID не должен быть пустым")
    @Size(max = 32, message = "Operation UID должен содержать не более 32 символов")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "System Time не должен быть пустым")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "Communication ID должен быть минимум 1")
    @Max(value = 100000, message = "Communication ID должен быть максимум 100000")
    private int communicationID;

    private int templateID;

    private int productCode;

    private int smsCode;
}
