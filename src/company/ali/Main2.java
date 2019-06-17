package company.ali;
import java.util.Scanner;

/**
 * Created by zhanghr on 2018/9/7.
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(",");
        int[] target = new int[]{Integer.parseInt(s1[0]),Integer.parseInt(s1[1]) };
        String[] s2 = in.nextLine().split(",");
        int[][] points = new int[s2.length/2][2];
        for (int i=0; i<s2.length; i+=2){
            int[] point = new int[]{Integer.parseInt(s2[i]), Integer.parseInt(s2[i+1])};
            points[i/2] = point;
        }
        if (ifPointIn(target, points)){
            System.out.println("yes,0");
        }else{
            int min = Integer.MAX_VALUE;
            for (int i=0; i<points.length; i++){
                int[] p1 = points[i];
                int[] p2 = points[(i+1)%points.length];
                min = Math.min(min, distance(target, p1, p2));
            }
            System.out.println("no,"+min);
        }
    }

    static boolean ifPointIn(int[] p, int[][] points) {
        boolean oddNodes=false;
        int x=p[0];
        int y=p[1];
        int  j = points.length-1 ;
        for (int i=0;i<points.length; i++) {
            if(((points[i][1]< y && points[j][1]>=y) || (points[j][1]<y && points[i][1]>=y))
                    &&  (points[i][0]<=x || points[j][0]<=x) ){
                if(points[i][0] + (y-points[i][1]) / (points[j][1]-points[i][1])*(points[j][0]-points[i][0])<x)
                    oddNodes=!oddNodes;
            }
            j=i;
        }
        return oddNodes;
    }

    static int distance(int[] p, int[] p1, int[] p2) {
        boolean ifObtuseAngle = ifObtuseAngle(p, p1, p2);
        if (ifObtuseAngle){
            return (int)(Math.min(getDistance(p, p1), getDistance(p, p2)));
        }else{
            return (int)getP2L(p, p1, p2);
        }
    }

    static boolean ifObtuseAngle(int[] p0, int[] p1, int[] p2){
        if ((p1[0]-p0[0]) * (p2[0]-p0[0]) - (p1[1]-p0[1])*(p2[1]-p0[1]) <= 0)
            return true;
        if ((p0[0]-p1[0]) * (p2[0]-p1[0]) - (p0[1]-p1[1])*(p2[1]-p1[1]) <= 0)
            return true;
        if ((p0[0]-p2[0]) * (p1[0]-p2[0]) - (p0[1]-p2[1])*(p0[1]-p2[1]) <= 0)
            return true;
        return false;
    }

    static double getDistance(int[] p1, int[] p2){
        return Math.sqrt(Math.pow(p1[0]-p2[0], 2)+Math.pow(p1[1]-p2[1], 2));
    }
    static double getP2L(int[] a, int[] b, int[] c){
        int ax = a[0], ay = a[1];
        int bx = b[0], by = b[1];
        int cx = c[0], cy = c[1];
        double res = Math.pow(cy-by, 2)+Math.pow(cx-bx, 2);
        double tmp = Math.pow( ((bx-ax)*(bx-cx) + (by-cy)*(by-cy)), 2) /
                (Math.pow(ay-by, 2) + Math.pow((ax-bx), 2));
        return Math.sqrt(res-tmp);
    }
}
