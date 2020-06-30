package abc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JOptionPane;

import java.util.*; 

public class MostRepeatedWord {       
    public static String path;
    public static void getFilePath(String filePath) {
         path = filePath;
    }
    public static void Start(BufferedReader reader) throws Exception {
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        String currentLine = reader.readLine();

        while (currentLine != null)
        {   
            String[] words = currentLine.toLowerCase().split(" ");
            for (String word : words)
            {
                if(wordCountMap.containsKey(word) && word.compareTo(",") != 0)
                {   
                    wordCountMap.put(word, wordCountMap.get(word)+1);
                }
                else
                {
                    wordCountMap.put(word, 1);
                }
            }
            currentLine = reader.readLine();
        }
        reader.close();
         
        String[] result = new String[3]; 
        int[] countOccurrence = new int[3];
        Map<String,Integer> threeMostCommon = sortByValue(wordCountMap);
        int index = 0;
        String[] specialCharacter = {"~","`","!","@","#","$","%","^","&","*","(",")","+","/"};
        int length = specialCharacter.length;
        for (Map.Entry<String, Integer> enter : threeMostCommon.entrySet()) {
            int countUnique = 0;
            for (int i = 0; i < length; i++) {
                    if (enter.getKey().contains(specialCharacter[i]) == true) 
                    countUnique++;
            }
            if (countUnique == 0)	{
                result[index] 	 = enter.getKey();
                countOccurrence[index] = enter.getValue();
                index++;
                if (index > 2) break;
            }
        } 
        
        JOptionPane.showMessageDialog(null,"Three common words: "+ result[0] + ", " + result[1] + ", " + result[2] + "\n" + "The output file's link has been showed in Output textbox");
        createOutputFile(result,countOccurrence);
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
     } 
    private static int getFile(String dirPath) {
        int count = 0;
        File f = new File(dirPath);
        File[] files = f.listFiles();
        if (files != null)
        for (int i = 0; i < files.length; i++) {
            count++;
            File file = files[i];
            if (file.isDirectory()) {   
                 getFile(file.getAbsolutePath()); 
            }
        }
        return count;
    }
    public static void createOutputFile(String[] result,int[] countOccurrence) {
            try {
            int countFile  = getFile("src\\OutputFile"); 
        	
            String filePath = "src\\OutputFile\\"  + "OutputFile_"+ String.valueOf(countFile+1) +".txt" ;
            File fo = new File(filePath); 
            MenuBar.outputPath(filePath);
            FileWriter fos = new FileWriter(fo); 
       	    BufferedWriter bw = new BufferedWriter(fos); 
            bw.write("The 3 most words in input file are : "+result[0] + ", " + result[1] + ", " + result[2] + "\n");
            bw.write("Number of occurences in order : "+ countOccurrence[0] + ", " + countOccurrence[1] + ", " + countOccurrence[2]);
            bw.close();
            }
            catch (Exception exx) {
                  JOptionPane.showMessageDialog(null, exx);
        }
    }
    public static void createInputFile(String inputString) {
        try {
            int countFile  = getFile("src\\InputFile"); 
            String filePath = "src\\InputFile\\"  + "InputFile_"+ String.valueOf(countFile+1) +".txt" ;
            File fo = new File(filePath); 
            MenuBar.getFilePath(filePath);
            FileWriter fos = new FileWriter(fo); 
            BufferedWriter bw = new BufferedWriter(fos); 
            bw.write(inputString);
            bw.close();
         }
         catch (Exception exx) {
                  JOptionPane.showMessageDialog(null, exx);
         }
    }
}    