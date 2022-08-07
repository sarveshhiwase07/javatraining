import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TableMakerTest{
  pubic static void main(String[] args){
        TableMaker tm = new TableMaker();
        tm.addTitle("EmployeeNumber");
        tm.addTitle("EmployeeName");
        tm.addTitle("EmployeeCity");
        tm.addRecords("EmployeeNumber","5498");
        tm.addRecords("EmployeeNumber","7893");
        tm.addRecords("EmployeeNumber","4324");
        tm.addRecords("EmployeeName","JANET");
        tm.addRecords("EmployeeName","JANE");
        tm.addRecords("EmployeeName","ROBERT");
        tm.addRecords("EmployeeCity","New York");
        tm.addRecords("EmployeeCity","Boston");
        tm.addRecords("EmployeeCity","Dallas");

        tm.printTable();
  }
}


class TableMaker{
    ArrayList<String> titles = new ArrayList<String>();
    HashMap<String,ArrayList<String>> mappers = new HashMap<String,ArrayList<String>>();
    HashMap<String,Integer> maxLengths = new HashMap<String,Integer>();

    public void addTitle(String title){
        titles.add(title);
        addRecords(title,title);
    }
    public int cntSpace(int maxlen,int len){
        int x = maxlen - len;
        return x / 2;
    }

    public void addRecords(String title,String record){
        if(mappers.containsKey(title)){
            ArrayList<String> tempRecords = mappers.get(title);
            tempRecords.add(record);
            mappers.put(title,tempRecords);
        } else {
            ArrayList<String> records = new ArrayList<String>();
            records.add(record);
            mappers.put(title, records);
        }
    }

    public void printTable(){
        int rowsCnt = 0;
        int lineLen = 0;

        //get the maxlength for that column and add it to the map
        //also count the linelen for print horizontal hyphens after each row.
        for (Map.Entry<String,ArrayList<String>> entry : mappers.entrySet()){
            int maxLength = entry.getKey().length();
            for(String s: entry.getValue()){
                maxLength = Math.max(maxLength,s.length());
            }
            rowsCnt = Math.max(rowsCnt,entry.getValue().size());
            lineLen += maxLength + 2;
            maxLengths.put(entry.getKey(), maxLength);
        }
        lineLen += 2;

        //table top most line
        System.out.print("+");
        for (int i = 0; i < lineLen; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        //printing all the rows with help of mappers
        for (int i = 0; i < rowsCnt; i++) {
            for (Map.Entry<String,ArrayList<String>> entry : mappers.entrySet()) {
                int maxlen = maxLengths.get(entry.getKey());
                String toAdd = entry.getValue().get(i);
                System.out.print("|");
                //give initial mid space from left
                for (int j = 0; j <= cntSpace(maxlen,toAdd.length()); j++) {
                    System.out.print(" ");
                }
                // print the word
                System.out.print(toAdd);
                // remaining space filled with spaces
                for (int j = 0; j <= maxlen - toAdd.length() - cntSpace(maxlen,toAdd.length()); j++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
            //horizontal line after every row except the last row
            if(i != rowsCnt - 1){
                for (int k = 0; k < lineLen + 2; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }

        }
        //table bottom most line
        System.out.print("+");
        for (int i = 0; i < lineLen; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

