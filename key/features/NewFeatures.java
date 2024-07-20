package key.features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewFeatures {

    public static void main(String[] args) throws IOException, InterruptedException {
        // JAVA 11 New Features
//        newStringMethods();
//        newFileMethods();
//        newNotPredicateMethod();
//        varKeywordSupportInLambdaParameters();
        htppClient();

        /*
        Running Java Files
        A major change in this version is that we don’t need to compile the Java source files with javac explicitly anymore:

        $ javac HelloWorld.java
        $ java HelloWorld
        Hello Java 8!

        Instead, we can directly run the file using the java command:

        $ java HelloWorld.java
        Hello Java 11!
         */
    }


    /*
     1. Java 11 adds a few new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
     */
    public static void newStringMethods(){
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines().collect(Collectors.toList());
        lines.forEach(System.out::println);
        System.out.println("-----------------------");
        List<String> lines1 = multilineString.lines().filter(line -> !line.isBlank()).collect(Collectors.toList());
        lines1.forEach(System.out::println);
        System.out.println("-----------------------");
        String str = "        Geeks For Geeks Internship    !   ";
        // removing leading and trailing white spaces
        System.out.println(str.strip()+"--");
        System.out.println("-----------------------");
        String slode = "        Geeks For Geeks Internship    !   ";
        // removing leading white spaces
        System.out.println(slode.stripLeading()+"--");
        System.out.println("-----------------------");
        String stril = "        Geeks For Geeks Internship    !   ";
        // removing trailing white spaces
        System.out.println(stril.stripTrailing()+"--");
    }

    /*
     2. We can use the new readString and writeString static methods from the Files class
     */
    public static void newFileMethods() throws IOException {
        Path filePath = Files.writeString(Files.createTempFile("demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        System.out.println(fileContent);
    }

    /*
     3. New not() method has been added to the Predicate interface.
        Use it to negate an existing predicate, much like the negate method.
     */
    public static void newNotPredicateMethod(){
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(withoutBlanks);
    }

    /*
    4. Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.
    */
    public static void varKeywordSupportInLambdaParameters(){
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String res = sampleList.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }

    /*
    5. The new HTTP client from the java.net.http package was introduced in Java 9.
       It has now become a standard feature in Java 11.
     */
    public static void htppClient() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }

}
