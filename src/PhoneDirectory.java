import java.util.*;

class PhoneDirectory {
    private Map<String, Set<String>> directory = new HashMap<>();

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+7\\d{10}");
    }

    public void add(String surname, String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Неверный формат номера: " + phoneNumber + ". Ожидается формат +7XXXXXXXXXX.");
            return;
        }

        if (directory.containsKey(surname) && directory.get(surname).contains(phoneNumber)) {
            System.out.println("Номер " + phoneNumber + " уже существует для пользователя " + surname);
            return;
        }

        removePhoneNumberFromOther(surname, phoneNumber);

        Set<String> phones = directory.get(surname);
        if (phones == null) {
            phones = new TreeSet<>();
            directory.put(surname, phones);
        }
        phones.add(phoneNumber);
    }

    private void removePhoneNumberFromOther(String currentSurname, String phoneNumber) {
        for (Map.Entry<String, Set<String>> entry : directory.entrySet()) {
            String surname = entry.getKey();
            Set<String> numbers = entry.getValue();

            if (!surname.equals(currentSurname) && numbers.contains(phoneNumber)) {
                numbers.remove(phoneNumber);

                if (numbers.isEmpty()) {
                    directory.put(surname, new TreeSet<>());
                }
                System.out.println("Номер " + phoneNumber + " был удален у пользователя " + surname);
                break;
            }
        }
    }

    public Set<String> get(String surname) {
        return directory.getOrDefault(surname, Collections.emptySet());
    }

    public void printDirectory() {
        List<String> sortedSurnames = new ArrayList<>(directory.keySet());
        Collections.sort(sortedSurnames);

        for (String surname : sortedSurnames) {
            Set<String> phones = directory.get(surname);
            System.out.println("Фамилия: " + surname + ", Телефоны: " + phones);
        }
    }
}
