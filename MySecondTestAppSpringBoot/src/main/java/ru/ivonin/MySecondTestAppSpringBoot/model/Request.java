package ru.ivonin.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.*;
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

    @NotBlank(message = "System Name не должен быть пустым")
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

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName=" + systemName + '\'' +
                ", systemTime='" + systemTime +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationID +
                ", templateId=" + templateID +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}