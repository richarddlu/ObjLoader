import java.util.ArrayList;

public class Model {
  
  public ArrayList<Float> vertices;

  public ArrayList<Float> normals;

  public ArrayList<Float> texture_coords;
  
  public ArrayList<Integer> faces;

  public ArrayList<Integer> faceTexCoords;

  public ArrayList<Integer> faceNorCoords;

  public ArrayList<Integer> faceVerCounts;

  public Model() {
    vertices = new ArrayList<Float>();
    normals = new ArrayList<Float>();
    texture_coords = new ArrayList<Float>();
    faces = new ArrayList<Integer>();
    faceTexCoords = new ArrayList<Integer>();
    faceNorCoords = new ArrayList<Integer>();
    faceVerCounts = new ArrayList<Integer>();
  }
  
}