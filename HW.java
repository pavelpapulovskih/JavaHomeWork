import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> phoneBook = new HashMap<>();
        System.out.print("Введите количество контактов: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите имя контакта: ");
            String name = scanner.next();
            System.out.print("Введите номер телефона контакта: ");
            String phoneNumber = scanner.next();
            if (phoneBook.containsKey(name)) {
                List<String> phoneNumbers = phoneBook.get(name);
                phoneNumbers.add(phoneNumber);
            } else {
                List<String> phoneNumbers = new ArrayList<>();
                phoneNumbers.add(phoneNumber);
                phoneBook.put(name, phoneNumbers);
            }
        }
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}




