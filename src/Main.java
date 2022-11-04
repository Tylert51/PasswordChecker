import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a secure password that meets these requirements:");
        System.out.println("- Is at least 8 characters long");
        System.out.println("- Contains at least one uppercase letter");
        System.out.println("- Contains at least one lowercase letter");
        System.out.println("- Contains at least one numeric digit");
        System.out.println("- Contains at least one of these symbols: ! @ # $ % ^ & * ?");
        System.out.print("\nEnter your secure password: ");
        String password = scanner.nextLine();

        SecurePassword password1 = new SecurePassword(password);
        if (!(password1.isSecure())) {
            System.out.println(password1.status());
        }
        while (!(password1.isSecure())) {
            System.out.print("\nEnter your secure password: ");
            String newPass = scanner.nextLine();
            password1.setPassword(newPass);
            if (!(password1.isSecure())) {
                System.out.println(password1.status());
            }
        }
        System.out.println("Password is secure");
    }
}