import java.util.ArrayList;
import java.util.List;

public class Cube {
    private int currState;
    private List<Cube> associatedCubes;
    private int totalState;

    public Cube(int currState) {
        this.currState = currState;
        this.associatedCubes=new ArrayList<>();
    }


    public void setTotalState(int totalState){
        this.totalState=totalState;
    }

    public void incrementState(){
        this.currState=(this.currState+1)%this.totalState;
        Cube currCube;
        for (int i = 0; i < associatedCubes.size(); i++) {
            currCube=associatedCubes.get(i);
            currCube.currState=(currCube.currState+1)%currCube.totalState;
        }
    }

    public int getCurrState() {
        return currState;
    }

    public void setCurrState(int currState) {
        this.currState = currState;
    }

    public List<Cube> getAssociatedCubes() {
        return associatedCubes;
    }

    public void setAssociatedCubes(List<Cube> associatedCubes) {
        this.associatedCubes = associatedCubes;
    }

    public int getTotalState() {
        return totalState;
    }
}
