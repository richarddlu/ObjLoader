import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ObjLoader {
  
  private static void parseLine(String line, Model model) throws NumberFormatException {
    if (model == null) // pre-condition
      return;
    
    String line_trimmed = line.trim();
    String[] eles = line_trimmed.split("\\s+");
    if (eles[0].equals("v")) { // vertex
        model.vertices.add(Float.parseFloat(eles[1]));
        model.vertices.add(Float.parseFloat(eles[2]));
        model.vertices.add(Float.parseFloat(eles[3]));
    } else if (eles[0].equals("f")) {
      String[] comb;
      comb = eles[1].split("/");
      model.faces.add(Integer.parseInt(comb[0]));
      comb = eles[2].split("/");
      model.faces.add(Integer.parseInt(comb[0]));
      comb = eles[3].split("/");
      model.faces.add(Integer.parseInt(comb[0]));
    } else if(eles[0].equals("vn")) {
      model.normals.add(Float.parseFloat(eles[1]));
      model.normals.add(Float.parseFloat(eles[2]));
      model.normals.add(Float.parseFloat(eles[3]));
    } else if(eles[0].equals("vt")) {
      model.texture_coords.add(Float.parseFloat(eles[1]));
      model.texture_coords.add(Float.parseFloat(eles[2]));
    }
  }
  
  public static Model load(InputStream is) throws IOException, NumberFormatException {
    Model model = new Model();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    String line;
    while ((line = reader.readLine()) != null) {
      parseLine(line, model);
    }
    reader.close();
    return model;
  }
  
}