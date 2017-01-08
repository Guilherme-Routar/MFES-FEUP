package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GraphTest extends TestAssert {
  public void runTests() {

    testVariables();
  }

  protected void testVariables() {

    Grafo gf = new Grafo();
    assertTrue(gf instanceof Grafo);
    assertTrue(Utils.equals(gf.Vertices.size(), 16L));
  }

  public GraphTest() {}

  public String toString() {

    return "GraphTest{}";
  }
}
