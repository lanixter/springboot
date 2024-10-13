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

    /**
     * Уникальный идентификатор сообщения
     */
    @NotBlank(message = "UID не должен быть пустым")
    @Size(max = 32, message = "UID должен содержать не более 32 символов")
    private String uid;

    /**
     * Уникальный идентификатор операции
     */
    @NotBlank(message = "Operation UID не должен быть пустым")
    @Size(max = 32, message = "Operation UID должен содержать не более 32 символов")
    private String operationUid;

    /**
     * Имя системы отправителя
     */
    @NotBlank(message = "System Name не должен быть пустым")
    private String systemName;

    /**
     * Время создания сообщения
     */
    @NotBlank(message = "System Time не должен быть пустым")
    private String systemTime;

    /**
     * Наименование ресурса
     */
    private String source;

    /**
     * Уникальный идентификатор коммуникации
     */
    @Min(value = 1, message = "Communication ID должен быть минимум 1")
    @Max(value = 100000, message = "Communication ID должен быть максимум 100000")
    private int communicationId;

    /**
     * Уникальный идентификатор шаблона
     */
    private int templateId;

    /**
     * Код продукта
     */
    private int productCode;

    /**
     * Смс код
     */
    private int smsCode;

    /**
     * Должность сотрудника
     */
    private String position;

    /**
     * Зарплата сотрудника
     */
    private double salary;

    /**
     * Бонус сотрудника
     */
    private double bonus;

    /**
     * Количество рабочих дней
     */
    private int workDays;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", workDays=" + workDays +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}