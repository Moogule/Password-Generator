import java.util.*;

/**
 * Password Generator
 *
 * Description:
 *      This is a program to be used to generate passwords using three inputs from the user; one to know how many
 *      letters are in the password, one is to know the amount of numbers of the password, and the last one is
 *      to know how many symbols are going to be in the password, then concatenates all to string and then shuffles
 *      the string to a new password.
 *
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        int letters, numbers, symbols;
        String confirm;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the password generator.");

        while(flag) {

            System.out.print("\nHow many letters would you like in the password?: ");
            letters = scan.nextInt();
            System.out.print("How many numbers would you like in your password?: ");
            numbers = scan.nextInt();
            System.out.print("How many symbols would you like in your password?: ");
            symbols = scan.nextInt();
            scan.nextLine();

            System.out.println("\n\nYou're new password is: " + password(letters, numbers, symbols));

            //to ask the user to loop again
            while(flag) {
                System.out.println("Do you want to generate another password? (y or n)");
                confirm = scan.nextLine();
                if (confirm.toLowerCase().charAt(0) == 'y')
                    break;
                else if (confirm.toLowerCase().charAt(0) == 'n')
                    flag = false;
                else
                    System.out.println("Error: Not a valid input.");
            }
        }
    }

    /**
     * password method is the one that is responsible to generate the random password using the numbers of letters,
     * numbers, and symbols that the user requested then shuffles the password
     * @param letterNums - numbers of letters the user wants in the password
     * @param numberNums - numbers of numbers the user wants in the password
     * @param symbolNums - numbers of symbols the user wants in the password
     * @return - returns the password
     */
    public static String password(int letterNums, int numberNums, int symbolNums) {
        String newPassword = "";
        String temp = "";
        Random rand = new Random();

        //arrays that have each character
        char[] letters = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
        char[] symbols = {'!', '@','#','$','%','^','&','*','(',')','-','_','+','=',',','.','?'};

        for(int i = 0; i < letterNums; i++){
            if(rand.nextBoolean())
                newPassword += Character.toString(letters[rand.nextInt(0, letters.length)]).toUpperCase();
            else
                newPassword += Character.toString(letters[rand.nextInt(0, letters.length)]).toLowerCase();
        }

        for(int i = 0; i < numberNums; i++){
            newPassword += Character.toString(numbers[rand.nextInt(0,numbers.length)]);
        }

        for(int i = 0; i < symbolNums; i++){
            newPassword += Character.toString(symbols[rand.nextInt(0, symbols.length)]);
        }

        List<String> characters = Arrays.asList(newPassword.split(""));
        Collections.shuffle(characters);
        newPassword = "";
        for (String character : characters)
        {
            newPassword += character;
        }

        return newPassword;
    }
}
