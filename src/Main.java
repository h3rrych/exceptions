
public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go";
        String password = "21314";
        String confirmPassword = "21344";
        validate(login, password, confirmPassword);
    }

    public static void validate(String login, String password, String confirmPassword) {
        String allowedSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        try {
            if (login == null || login.length() > 20 || !login.matches("[" + allowedSymbols + "]+")) {
                throw new WrongLoginException("Wrong login");
            }
            if (password == null || password.length() > 20 || !password.matches("[" + allowedSymbols + "]+")) {
                throw new WrongPasswordException("Wrong password");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Passwords do not match");
            }
        } catch (WrongLoginException | IllegalAccessException e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Произошла ошибка при вводе логина");
            }
        } catch (WrongPasswordException e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Произошла ошибка при вводе пароля");
            }
        }
    }
}