
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class CubeSet {
    private List<Cube> cubeList;
    private int [] states;
    private int totalState;

    public CubeSet(List<Cube> cubeList){
        this.cubeList=cubeList;
        this.states=null;
    }

    public void setTotalStates(int totalState){
        for (int i = 0; i < cubeList.size(); i++) {
            cubeList.get(i).setTotalState(totalState);
        }
        this.totalState=totalState;
    }

    private boolean solved(){
        Cube currCube,prevCube;
        for (int i = 1; i < cubeList.size(); i++) {
            prevCube=cubeList.get(i-1);
            currCube=cubeList.get(i);
            if (prevCube.getCurrState()!= currCube.getCurrState()){
                return false;
            }
        }
        return true;
    }

    private boolean solved(int target){
        Cube currCube;
        for (int i = 0; i < cubeList.size(); i++) {
            currCube=cubeList.get(i);
            if (currCube.getCurrState()!=target){
                return false;
            }
        }
        return true;
    }

    private void recordStates(){
        this.states=new int[cubeList.size()];
        for (int i = 0; i < cubeList.size(); i++) {
            states[i]=cubeList.get(i).getCurrState();
        }
    }

    private void restoreStates(){
        for (int i = 0; i < cubeList.size(); i++) {
            cubeList.get(i).setCurrState(states[i]);
        }
    }

    public String solve(){
        int allCubeNum=cubeList.size();
        int stepCount=0;
        int randomCubeNum;
        Random random;
        String result="";

        random=new Random();
        recordStates();
        while (!solved()){
            stepCount=0;
            result="";
            restoreStates();
            while (stepCount<10&&!solved()){
                randomCubeNum=random.nextInt(allCubeNum);
                cubeList.get(randomCubeNum).incrementState();
                result+=randomCubeNum+",";
                stepCount++;
            }
        }

        return result;
    }

    public String solve(int target){
        int allCubeNum=cubeList.size();
        int stepCount=0;
        int randomCubeNum;
        Random random;
        String result="";

        random=new Random();
        recordStates();
        while (!solved(target)){
            stepCount=0;
            result="";
            restoreStates();
            while (stepCount<10&&!solved()){
                randomCubeNum=random.nextInt(allCubeNum);
                cubeList.get(randomCubeNum).incrementState();
                result+=randomCubeNum+",";
                stepCount++;
            }
        }

        return result;
    }

    public int[] parseResultStr(String resultStr){
        int []result=new int[totalState];
        Arrays.fill(result,0);
        String[] parts = resultStr.split(",");
        for(int i=0; i<parts.length;i++){
            result[Integer.parseInt(parts[i])]++;
        }
        return result;
    }

}
