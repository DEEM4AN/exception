package v2.Model;

public class UserDataModel {
    private String lastName;
    private String firstName;
    private String middleName;


    private String birthDate;
    private long phoneNumber;
    private char gender;

    public UserDataModel(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }


    public static UserDataModel parseUserData(String[] data) throws InvalidDataFormatException {
        if (data.length != 6) {
            throw new InvalidDataFormatException("Некорректное количество данных");
        }
        if (!validateFIO(data[0], data[1], data[2])) {
            throw new InvalidDataFormatException("Некорректный ввод ФИО");
        }
        if (!validateDate(data[3])) {
            throw new InvalidDataFormatException("Некорректный формат даты рождения");
        }
        if (!validatePhoneNumber(data[4])) {
            throw new InvalidDataFormatException("Некорректный формат номера телефона");
        }
        if (!validateGender(data[5])) {
            throw new InvalidDataFormatException("Некорректный формат пола");
        }

        return new UserDataModel(data[0], data[1], data[2], data[3], Long.parseLong(data[4]), data[5].charAt(0));
    }

    private static boolean validateFIO(String firstName, String secondName, String patronymic) {
        if (firstName.length() < 2 && secondName.length() < 2 && patronymic.length() < 2) {
            return false;
        } else if (firstName.length() != firstName.replaceAll("[^A-Za-zА-Яа-я]", "").length()) {
            return false;
        } else if (secondName.length() != secondName.replaceAll("[^A-Za-zА-Яа-я]", "").length()) {
            return false;
        } else if (patronymic.length() != patronymic.replaceAll("[^A-Za-zА-Яа-я]", "").length()) {
            return false;
        }
        return true;
    }

    private static boolean validateDate(String dateStr) {
        String[] s = dateStr.replaceAll("[^0-9]", " ").split(" ");
        if (s.length != 3) {
            return false;
        }
        if (s[0].length() == 2 && s[1].length() == 2 && s[2].length() == 4) {
            return true;
        } else return false;
    }

    private static boolean validatePhoneNumber(String phoneNumberStr) {
        phoneNumberStr.replaceAll("[^0-9]", "");
        if (phoneNumberStr.length() >= 7) {
            try {
                Long.parseLong(phoneNumberStr);
            } catch (NumberFormatException e) {

                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean validateGender(String genderStr) {
        if (genderStr.toLowerCase().equals("f") || genderStr.toLowerCase().equals("m") || genderStr.toLowerCase().equals("м") || genderStr.toLowerCase().equals("ж")) {
            return true;
        } else return false;
    }
}