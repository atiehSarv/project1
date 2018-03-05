import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class main {


    private String  Persianword;
    private Set<String>  permutedInputs;

    public String getPersianword(){
        return Persianword;
    }

    public void setPersianword(String str){
        Persianword = str;
    }

    public Set<String> getInputs() { return permutedInputs ;}
    public void setInputs(Set<String> s){
        permutedInputs = s;
    }
    public void   strFinder(Set<String> inputs){
        InputStream inputFile = getClass().getResourceAsStream("./mydb");
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputFile));
        String[] arr =inputs.toArray(new String [inputs.size()]) ;
        Arrays.sort(arr);

        String temp ="";
        String file_line;


    try {
        int count = 0;
       while ((file_line = readFile.readLine()) != null) {

            for ( int i=0 ; i< arr.length ; i++) {
                temp =arr[i];
            if (temp.equals(file_line )) {
                count++;
                System.out.print("Anagram" + count + ":");
                System.out.print( file_line + "\n");}
 }
        }

    } catch (IOException e) {
        e.printStackTrace();

}


    }
    public static void main(String[] args){
      main m = new main();
      StringHelper permute = new StringHelper();
      System.out.println("لطفا کلمه مورد نظر را وارد کنید");
        Scanner input = new Scanner(System.in);
        String persianWord = input.nextLine();
        m.setPersianword(persianWord);
        Set<String> inputs = permute.permutationFinder(persianWord);
        m.setInputs(inputs);
        System.out.println("جایگشت حروف عبارتند از: " );
        System.out.println( inputs);
        m.strFinder(inputs);
    }
}
