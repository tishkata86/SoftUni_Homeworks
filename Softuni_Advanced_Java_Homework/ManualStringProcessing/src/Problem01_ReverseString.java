import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem01_ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new StringBuilder(buffer.readLine()).reverse());
    }
}
