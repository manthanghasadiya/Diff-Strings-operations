import java.util.*;

public class hash {
    static void createHashMap(int arr[]) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Integer c = hmap.get(arr[i]);
            if (hmap.get(arr[i]) == null) {
                hmap.put(arr[i], 1);
            } else {
                hmap.put(arr[i], ++c);
            }
        }
        System.out.println(hmap);
    }

//     public static void main(String[] args) {
//         int arr[] = { 11, 35, 6, 11, 4, 6, 12 };
//         createHashMap(arr);
//     }
// }
