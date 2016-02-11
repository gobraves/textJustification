import java.util.LinkedList;
import java.util.List;

/**
 * Created by neo on 16-2-11.
 */
public class textJsutification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> tmpList = new LinkedList<>();
        List<String> resultList = new LinkedList<>();
        String tmpResult = new String();
        for (String str : words){
            if(str.trim().length() > 0){
                if((str + tmpResult + " ").length() < maxWidth){
                    str += " ";
                    tmpResult += str;
                } else {
                    tmpList.add(tmpResult);
                }
            }
        }
        if(tmpList.size() > 0){
            for(String str : tmpList){
                String[] tmpStr = str.split(" ");
                String tmpLine = new String();
                String line = new String();
                for (String word : tmpStr){
                    tmpLine += word;
                }
                if(tmpList.size() > 1){
                    int remainer = (maxWidth - tmpLine.length()) % (tmpStr.length - 1);
                    int ava = (maxWidth - tmpLine.length()) / (tmpStr.length - 1);
                    for(int i = 0; i < tmpStr.length; i++){
                        String word = tmpStr[i];
                        while(ava > 0){
                            word += " ";
                            ava--;
                        }
                        if(i < remainer){
                            word += " ";
                        }
                        line += word;
                    }
                } else {
                    int remainer = maxWidth - tmpLine.length();
                    line = tmpStr[0];
                    while(remainer-- > -1){
                        line += " ";
                    }
                }

                resultList.add(line);
            }
        } else {
            resultList.add("");
        }

        return resultList;
    }


}
