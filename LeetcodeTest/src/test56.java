import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class test56 {
    public static class Interval{
        int start;
        int end;
        Interval(int[] interval){
            this.start = interval[0];
            this.end = interval[1];
        }
    }
    public static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b){
            return a.start-b.start;
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new LinkedList<>();
        for(int[] interval:intervals){
            intervalList.add(new Interval(interval));
        }

        intervalList.sort(new IntervalComparator());
        LinkedList<Interval> res = new LinkedList<>();
        for(Interval interval : intervalList){
            if(res.isEmpty() || res.getLast().end<interval.start){
                res.add(interval);
            }else{
                res.getLast().end = Math.max(res.getLast().end ,interval.end);
            }
        }

        for(Interval interval: res){
            System.out.println("start"+interval.start);
            System.out.println("end"+interval.end);
        }

//        int[][] result = new int[res.size()][2];
//        int i = 0;
//        for(Interval interval:res){
//            result[i][0] = interval.start;
//            System.out.println(result[i][0]);
//            result[i][1] = interval.end;
//            System.out.println(result[i][1]);
//            i++;
//        }
        System.out.println("size="+res.size());
        int[][] result = new int[res.size()][2];
        int size = res.size();
        for(int i = 0;i<size;i++){
            System.out.println("i="+i);
            result[i][0] = res.peek().start;
            System.out.println("start"+result[i][0]);
            result[i][1] = res.poll().end;
            System.out.println("end"+result[i][1]);
            System.out.println(res.isEmpty());
        }


        return result;
    }

    public static void main(String[] args) {
        int [][] intervals ={{1,3},{2,6},{8,10},{15,18}};
        int [][] res = merge(intervals);
    }
}
