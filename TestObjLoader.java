import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class TestObjLoader {
  public static void main(String[] args) throws IOException, NumberFormatException {
    String filepath = "sample.obj";
    Path path = Paths.get(filepath);
    InputStream is = Files.newInputStream(path);
    Model model = ObjLoader.load(is);
    System.out.println(model.vertices);
    System.out.println(model.faces);
    System.out.println(model.normals);
    System.out.println(model.texture_coords);
  }
}