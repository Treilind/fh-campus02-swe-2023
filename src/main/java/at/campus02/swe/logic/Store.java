package at.campus02.swe.logic;

import at.campus02.swe.CalculatorException;

import java.util.HashMap;

public class Store {

    private int singleStore;

    private HashMap<Character,Integer> storeMap;

    public Store() {
        this.storeMap = new HashMap<>();
    }



    public void store(String line, int result) {
        if (line == null){
            singleStore = result;
        }
        else {
            String[] cmds = line.split(" ");
            char value = cmds[1].charAt(0);
            storeMap.put(value, result);
        }
    }


    public int load(String line) throws CalculatorException {
        if (line == null){
            return singleStore;
        }
       else {
            String[] cmds = line.split(" ");
            char value = cmds[1].charAt(0);
            if (!storeMap.containsKey(value)) {
                throw new CalculatorException("no result stored in value: " + value);
            }
            for (char key : storeMap.keySet()) {
                if (key == value) {
                    int result = storeMap.get(key);
                    storeMap.remove(key);
                    return result;
                }
            }
        }
        return 0;
    }

}
