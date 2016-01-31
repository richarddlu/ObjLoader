import java.util.ArrayList;

public class Model {
  
  public ArrayList<Float> vertices;
  
  public ArrayList<Integer> faces;
  
  public ArrayList<Float> normals;
  
  public ArrayList<Float> texture_coords;
  
  public Model() {
    vertices = new ArrayList<Float>();
    faces = new ArrayList<Integer>();
    normals = new ArrayList<Float>();
    texture_coords = new ArrayList<Float>();
  }
  
}