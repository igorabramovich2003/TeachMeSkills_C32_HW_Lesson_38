package com.teachmeskills.lesson_38.service;

import com.teachmeskills.lesson_38.annotations.Timed;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @Timed // Аннотация, которая активирует аспект для измерения времени выполнения
    public void longRunningMethod() {
        try {
            // Приостанавливаем выполнение на 2 секунды (2000 миллисекунд)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Обработка исключения, если поток был прерван
            e.printStackTrace();
        }
        System.out.println("Метод longRunningMethod завершил выполнение.");
    }
    @Timed
    public void shortRunningMethod() {
        try {
            // Приостанавливаем выполнение на 0.9 секунды (900 миллисекунд)
            Thread.sleep(900);
        } catch (InterruptedException e) {
            // Обработка исключения, если поток был прерван
            e.printStackTrace();
        }
        System.out.println("Метод shortRunningMethod завершил выполнение.");
    }

}
