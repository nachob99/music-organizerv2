import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    /**
     * Muestra una lista de todos los archivos de la colecci�n
     */
    public void listAllFiles(){
        int position = 1;
        for(String filename : files){
            System.out.println(position + ": " + filename);
            position = position + 1;
        }
    }
    /**
     * Enumera los nombre de archivo que se corresponden con
     * la cadena de la busqueda seleccionada
     * @param serachString La cadena que hay que buscar
     */
    public void listMatching(String searchString)
    {
        boolean validName = false;
        for (String fileName : files)
        {
            if (fileName.contains(searchString))
            {
                // Una coincidencia.
                System.out.println (fileName);
                validName = true;
            }
        }
        if (validName == false)
        {
            System.out.println("No se han encontrado archivos con ese nombre");
        }
    }
    /**
     * Reproduce unos segundos de las canciones de un artista 
     */
    public void playSampleOf(String artistName)
    {
        for (String fileName : files)
        {
            if (fileName.contains(artistName))
            {
                player.playSample(fileName);
            }
        }
    }
    /**
     * Localizar el indice del primer archivo que se corresponde
     * con la cadena buscada indicada
     * @param serachString La cadena que hay que buscar.
     * @return El indice de la primera aparici�n, es decir -1
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        boolean found = false;
        int fileIndex = -1;
        int size = files.size();
        while (!found && index < files.size())
        {
            String fileName = files.get(index);
            if (fileName.contains(searchString))
            {
                found = true;
                fileIndex = index;
            }
            index = index + 1;
        }
        return fileIndex;
    }
    
     
}
