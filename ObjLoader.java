import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class ObjLoader {
  
  private static void parseLine(String line, Model model) throws NumberFormatException {
    if (model == null) // pre-condition
      return;
    
    String line_trimmed = line.trim();
    String[] eles = line_trimmed.split(" ");
    if (eles[0].equals("v")) { // vertex
      model.vertices.add(Float.parseFloat(eles[1]));
      model.vertices.add(Float.parseFloat(eles[2]));
      model.vertices.add(Float.parseFloat(eles[3]));
    } else if (eles[0].equals("f")) {
      model.faces.add(Integer.parseInt(eles[1]));
      model.faces.add(Integer.parseInt(eles[2]));
      model.faces.add(Integer.parseInt(eles[3]));
    } else if(eles[0].equals("vn")) {
      model.normals.add(Float.parseFloat(eles[1]));
      model.normals.add(Float.parseFloat(eles[2]));
      model.normals.add(Float.parseFloat(eles[3]));
    } else if(eles[0].equals("vt")) {
      model.texture_coords.add(Float.parseFloat(eles[1]));
      model.texture_coords.add(Float.parseFloat(eles[2]));
    }
  }
  
  public static Model load(String filepath) throws IOException, NumberFormatException {
     Model model = new Model();
    Path objpath = Paths.get(filepath);
    Charset charset = Charset.forName("UTF-8");
    BufferedReader reader = Files.newBufferedReader(objpath, charset);
    String line;
    while ((line = reader.readLine()) != null) {
      parseLine(line, model);
    }
    reader.close();
    return model;
  }
  
}