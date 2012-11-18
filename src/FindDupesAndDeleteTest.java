import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FindDupesAndDeleteTest {

    @Test
    public void findAndDeleteFiles(){

        // given a starting folder
        String startingFolderPath = "t:\\Shared Music";
        File startingFolder = new File(startingFolderPath);

        if(startingFolder.isDirectory()){
            // recursively go through all folders
            findAndDeleteFilesForThisFolder(startingFolder);

        }

    }

    private void findAndDeleteFilesForThisFolder(File thisFolder) {

        // for each folder scan the files

        System.out.println("Scanning " + thisFolder.getName());

        File[] filesInfolder = thisFolder.listFiles();

        Map<String,File> subFolders = new HashMap<String, File>();
        Map<String,File> mp3Files = new HashMap<String, File>();
        Map<String,File> wmaFiles = new HashMap<String, File>();

        for(File aFile : filesInfolder){

            if(aFile.isDirectory()){
                subFolders.put(aFile.getName(),aFile);
            }else{
                String aFileName = aFile.getName();
                if(aFileName.toLowerCase().endsWith(".mp3")){
                    mp3Files.put(aFileName,aFile);
                }else{
                    if(aFileName.toLowerCase().endsWith(".wma")){
                        wmaFiles.put(aFileName,aFile);
                    }
                }
            }
        }

        // find any files which are the same name with the only difference being the .mp3 or .wma
        // delete the .wma files
        for(String anMP3FileName : mp3Files.keySet()){

            String compareMP3Name = anMP3FileName.substring(0,anMP3FileName.lastIndexOf("."));

            for(Map.Entry<String,File> aWMAFileEntry : wmaFiles.entrySet()){
                String aWMAFileName = aWMAFileEntry.getKey();
                String compareWMAName = aWMAFileName.substring(0,aWMAFileName.lastIndexOf("."));

                if(compareMP3Name.contentEquals(compareWMAName)){
                    System.out.println("Found a duplicate file " + aWMAFileName + " with " + anMP3FileName);
                    System.out.println("Deleting duplicate file " + aWMAFileName);
                    aWMAFileEntry.getValue().delete();
                }
            }
        }

        for(Map.Entry aFolder : subFolders.entrySet()){
            findAndDeleteFilesForThisFolder((File)aFolder.getValue());
        }

    }
}
