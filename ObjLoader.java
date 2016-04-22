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
      model.faceVerCounts.add(eles.length - 1);
      for (int i = 1; i < eles.length; i++) {
        String[] comb;
        comb = eles[i].split("/");
        if (comb.length > 0)
          model.faces.add(Integer.parseInt(comb[0]));
        if (comb.length > 1)
          model.faceTexCoords.add(Integer.parseInt(comb[1]));
        if (comb.length > 2)
          model.faceNorCoords.add(Integer.parseInt(comb[2]));
      }
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