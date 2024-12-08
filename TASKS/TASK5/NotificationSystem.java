package TASK5;

import java.util.ArrayList;
import java.util.List;

// Интерфейс наблюдателя (пользователя, который получает уведомления)
interface Observer {
    void update(String message);
}

// Интерфейс субъекта (пользователя, который генерирует события)
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Конкретный наблюдатель: пользователь, подписанный на уведомления
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил уведомление: " + message);
    }
}

// Конкретный субъект: пользователь, который генерирует события
class SocialMediaUser implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String name;
    private String latestAction;

    public SocialMediaUser(String name) {
        this.name = name;
    }

    public void performAction(String action) {
        this.latestAction = action;
        notifyObservers();  // Оповещаем всех подписчиков о действии
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name + " " + latestAction);
        }
    }
}

// Главный класс для демонстрации работы системы уведомлений
public class NotificationSystem {

    public static void main(String[] args) {
        // Создаём пользователей
        User user1 = new User("Анна");
        User user2 = new User("Иван");

        // Создаём социального пользователя (пользователя, который генерирует события)
        SocialMediaUser user3 = new SocialMediaUser("Мария");

        // Подписываем пользователей на уведомления
        user3.addObserver(user1);
        user3.addObserver(user2);

        // Пользователь Мария выполняет действия
        user3.performAction("опубликовала новый пост");
        user3.performAction("поставила лайк на фото");
        user3.performAction("прокомментировала пост");
    }
}
