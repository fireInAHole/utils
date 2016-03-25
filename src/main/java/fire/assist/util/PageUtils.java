package fire.assist.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created in 16/3/25.
 */
public class PageUtils {

    /**
     * split arrayList into 2-D arrayList
     * @param list
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T extends Object> List<List<T>> splitList(List<T> list, int pageSize) {
        List<List<T>> retList = new ArrayList<List<T>>();
        int index = 0;
        while(list.size() >= ( index*pageSize)){
            if((( index+1)*pageSize) > list.size()){
                retList.add(list.subList( index*pageSize, list.size()));
                break;
            }
            retList.add(list.subList( index*pageSize, (index+1)*pageSize));
            index++;
        }
        return retList;
    }

    public static void main(String[] args) {
        List<Integer> randList = new ArrayList<Integer>();
        Random rand = new Random(99);
        for (int i = 0; i < 99; i++) {
            randList.add(rand.nextInt());
        }
        List<List<Integer>> splitedList = splitList(randList,Integer.SIZE);
        for(List<Integer> list : splitedList){
            invokeMethod(list);
        }
        //jdk1.8
//        splitedList.stream().forEach(p->invokeMethod(p));
    }

    /**
     * invoke method
     * @param list
     */
    private static <T extends Object> void invokeMethod(List<T> list){
        System.out.println("ok");
    }

}
