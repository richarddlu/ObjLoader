import java.io.IOException;

public class TestObjLoader {
  public static void main(String[] args) throws IOException, NumberFormatException {
    String filepath = "sample.obj";
    Model model = ObjLoader.load(filepath);
    System.out.println(model.vertices);
    System.out.println(model.faces);
    System.out.println(model.normals);
    System.out.println(model.texture_coords);
  }
}