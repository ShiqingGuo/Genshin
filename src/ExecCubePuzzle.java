import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecCubePuzzle {
    public static void main(String[] args) {
        Cube a, b, c, d;
        a = new Cube(3);
        b = new Cube(0);
        c = new Cube(3);
        d = new Cube(0);

        a.setAssociatedCubes(new ArrayList<>(Arrays.asList(b)));
        b.setAssociatedCubes(new ArrayList<>(Arrays.asList(a, c)));
        c.setAssociatedCubes(new ArrayList<>(Arrays.asList(b, d)));
        d.setAssociatedCubes(new ArrayList<>(Arrays.asList(c)));

        CubeSet cubeSet=new CubeSet(new ArrayList<>(Arrays.asList(a,b,c,d)));
        cubeSet.setTotalStates(4);
        int[] result=cubeSet.parseResultStr(cubeSet.solve(0));
        System.out.println(Arrays.toString(result));
    }
}
