import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class regexcontrol {
 /**---------------------------------------------------

 * @author: Yahya Efe Kuruçay

 * @since: 29.02.2024

 * Description: EmailControl control

 * Website: https://efekurucay.com

*---------------------------------------------------*/
    

    public static void main(String[] args) {
        
        String email= "contact@efekurucay.com";
         String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        System.out.println(matcher.matches());
         
    }
}
/***
 *    ░▒▓████████▓▒░▒▓████████▓▒░▒▓████████▓▒░ 
 *    ░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░        
 *    ░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░        
 *    ░▒▓██████▓▒░ ░▒▓██████▓▒░ ░▒▓██████▓▒░   
 *    ░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░        
 *    ░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░        
 *    ░▒▓████████▓▒░▒▓█▓▒░      ░▒▓████████▓▒░ 
 *                                             
 *                                             
 */