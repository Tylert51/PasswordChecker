public class SecurePassword
{
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public boolean isSecure()
    {
        return isLongEnough() & containsUppercase() & containsLowercase() & containsDigit() & containsSpecialSymbol();
    }


    public String status()
    {
        String length = "The password must be at least 8 characters";
        String uppercase = "This password must contain at least one uppercase letter";
        String lowercase = "This password must contain at least one lowercase letter";
        String number = "This password must contain at least one number";
        String specialSymbol = "This password must contain at least one special symbol: ! @ # $ % ^ & * ?";
        String tryAgain = "Try again";

        String returnStatement = "";

        if (isSecure()) {
            return "Password is secure";
        } else {
            if (!(isLongEnough())) {
                returnStatement += length + "\n";
            }
            if (!(containsUppercase())) {
                returnStatement += uppercase + "\n";
            }
            if (!(containsLowercase())) {
                returnStatement += lowercase + "\n";
            }
            if (!(containsDigit())) {
                returnStatement += number + "\n";
            }
            if (!(containsSpecialSymbol())) {
                returnStatement += specialSymbol + "\n";
            }
        }
        return returnStatement + tryAgain + "\n";
    }

    private boolean isLongEnough()
    {
        return password.length() >= 8;
    }

    private boolean containsUppercase()
    {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }


    private boolean containsLowercase()
    {
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowercaseLetters);
    }

    private boolean containsDigit()
    {
        String digits = "0123456789";
        return checkString(digits);
    }

    private boolean containsSpecialSymbol()
    {
        String specialSymbols = "!@#$%^&*?";
        return checkString(specialSymbols);
    }

    private boolean checkString(String characterString)
    {
        boolean contains = false;
        for (int i = 0; i < password.length(); i++) {
            String letter = password.charAt(i) + "";
            if (characterString.contains(letter)) {
                return true;
            }
        }
        return contains;
    }
}