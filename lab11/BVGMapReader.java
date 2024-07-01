package lab11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BVGMapReader {

    public ArrayList<Node> readNodes(String fileName){
        ArrayList<Node> nodes= new ArrayList<>();
        ArrayList<String> lines= readFile(fileName);

        for(String line:lines){
            String[] content= line.split(" ");
            HashMap<String,Integer> nachbarn= new HashMap<>();

            for(int i = 1; i< content.length; i++){
               nachbarn.put(content[i].split(",")[0], Integer.valueOf(content[i].split(",")[1]));
            }
            Node node = new Node(nachbarn,Integer.MAX_VALUE,content[0]);
            nodes.add(node);
        }
        return nodes;
    }

    public HashMap<String, String> readStations(String fileName){
        ArrayList<Node> nodes= new ArrayList<>();
        ArrayList<String> lines= readFile(fileName);
        HashMap<String,String> stationen = new HashMap<>();


        for(String line:lines){
            String[] content= line.split(", ");


            stationen.put(content[0],content[1]);
        }
        return stationen;
    }

    private ArrayList<String> readFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> lines= new ArrayList<>();

        try (Scanner scanner = new Scanner(file);){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return null;
    }
}
