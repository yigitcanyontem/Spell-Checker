import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static Set<String> dictionary = new HashSet<>();
    public static void main(String[] args){
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                dictionary.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(check("comoc"));
        System.out.println(check("scoe"));
        System.out.println(check("bok"));
        System.out.println(check("boo"));
        System.out.println(check("ook"));
        System.out.println(check("bluue"));
        System.out.println(check("compter"));
        System.out.println(check("mousse"));
    }

    public static ArrayList<String> check(String word){
        word = word.toLowerCase();
        word = word.replaceAll("[^a-zA]", "");

        ArrayList<String> list = new ArrayList<>();

        if (dictionary.contains(word)){
            list.add(word);
            return list;
        }else{
            for(int i = 0; i < word.length(); i++){
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder1 = new StringBuilder();
                StringBuilder stringBuilder2;
                StringBuilder stringBuilder3;

                //deleting
                stringBuilder.append(word, 0, i);
                stringBuilder.append(word.substring(i+1));

                if(dictionary.contains(String.valueOf(stringBuilder)) && !list.contains(String.valueOf(stringBuilder))){
                    list.add(String.valueOf(stringBuilder));
                }

                //Swapping Characters
                if (i+1 < word.length()){
                    stringBuilder1.append(word, 0, i);
                    stringBuilder1.append(word.charAt(i+1));
                    stringBuilder1.append(word.charAt(i));
                    stringBuilder1.append(word.substring(i+2));
                }

                if(dictionary.contains(String.valueOf(stringBuilder1)) && !list.contains(String.valueOf(stringBuilder1))){
                    list.add(String.valueOf(stringBuilder1));
                }

                //inserting
                char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                for (char x: letters){
                    stringBuilder2 = new StringBuilder(word);
                    stringBuilder2.insert(i+1,x);
                    if(dictionary.contains(String.valueOf(stringBuilder2)) && !list.contains(String.valueOf(stringBuilder2))){
                        list.add(String.valueOf(stringBuilder2));
                    }
                }
                for (char x: letters){
                    stringBuilder2 = new StringBuilder(word);
                    stringBuilder2.insert(0,x);
                    if(dictionary.contains(String.valueOf(stringBuilder2)) && !list.contains(String.valueOf(stringBuilder2))){
                        list.add(String.valueOf(stringBuilder2));
                    }
                }


                //replacing
                for (char x: letters){
                    stringBuilder3 = new StringBuilder();
                    if (i+1 < word.length()){
                        stringBuilder3.append(word, 0, i);
                        stringBuilder3.append(x);
                        stringBuilder3.append(word.substring(i+1));
                        if(dictionary.contains(String.valueOf(stringBuilder3)) && !list.contains(String.valueOf(stringBuilder3))){
                            list.add(String.valueOf(stringBuilder3));
                        }
                    }
                }
        }
        return list;
    }
}}
