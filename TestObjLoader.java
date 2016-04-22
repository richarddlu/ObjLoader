import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class TestObjLoader {
  public static void main(String[] args) throws IOException, NumberFormatException {
    String filepath = "torus.obj";
    Path path = Paths.get(filepath);
    InputStream is = Files.newInputStream(path);
    Model model = ObjLoader.load(is);

    System.out.println(model.vertices);
    System.out.println(model.normals);
    System.out.println(model.texture_coords);
    System.out.println(model.faces);
    System.out.println(model.faceVerCounts);
    System.out.println(model.faceTexCoords);
    System.out.println(model.faceNorCoords);

    System.out.println("Number of vertice coords: " + model.vertices.size());
    System.out.println("Number of normal coords: " + model.normals.size());
    System.out.println("Number of texture coords: " + model.vertices.size());
    System.out.println("Number of face indices: " + model.faces.size());
    System.out.println("Number of faces: " + model.faceVerCounts.size());
    System.out.println("Number of face texture coord indices: " + model.faceTexCoords.size());
    System.out.println("Number of face normal coord indices: " + model.faceNorCoords.size());
  }
}