package ru.Ivonin.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    // Поля для хранения данных
    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();
    private int hashMapKey = 1;

    // Исходный метод приветствия
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // Метод для добавления строки в ArrayList
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String value) {
        arrayList.add(value);
        return "Value added to ArrayList: " + value;
    }

    // Метод для отображения всех элементов ArrayList
    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;
    }

    // Метод для добавления строки в HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String value) {
        hashMap.put(hashMapKey++, value);
        return "Value added to HashMap with key " + (hashMapKey - 1) + ": " + value;
    }

    // Метод для отображения всех элементов HashMap
    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }

    // Метод для отображения количества элементов в ArrayList и HashMap
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "ArrayList contains " + arrayList.size() + " elements. " +
                "HashMap contains " + hashMap.size() + " elements.";
    }
}