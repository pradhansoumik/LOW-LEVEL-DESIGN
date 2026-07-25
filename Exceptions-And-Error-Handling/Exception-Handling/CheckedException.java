import java.io.*;

class FileReaderExample
{
    public void readFile(String filePath) throws IOException
    {
        FileReader reader = new FileReader(filePath);  // This may throw an IOException
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
    }

    public static void main(String[] args)
    {
        FileReaderExample example = new FileReaderExample();
        try
        {
            example.readFile("somefile.txt"); // Must handle the IOException
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
