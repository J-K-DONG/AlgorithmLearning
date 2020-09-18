package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> tmp,map = new HashMap<String,Integer>();
        int lens=s.length(), lenw = words[0].length();
        for(int i = 0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else{
                map.put(words[i],1);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= lens - lenw * words.length; i++){  // 遍历前 lens-lenw*words.length 个字符
            tmp = new HashMap<String,Integer>();
            int j = 0;
            for(;j<words.length;j++){  // 遍历字符串
                int pos=i+j*lenw;
                String sub=s.substring(pos,pos+lenw);  // 截取下来
                if(map.containsKey(sub)){
                    int num = 0;
                    if(tmp.containsKey(sub)) num = tmp.get(sub);
                    if(map.get(sub) < num+1)break;
                    else tmp.put(sub,num+1);
                }else break;
            }
            if(j>=words.length){
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args){
        String str = "sadfglkjsarosfooowingdingbarrwingaidjfq[eoifj";
        String[] s = {"fooo", "barr", "wing", "ding", "wing"};
        List<Integer> res = findSubstring(str, s);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i)+" ");
        }

    }
}
