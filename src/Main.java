import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] build;

    public static int ans=0;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        for(int test_case=1; test_case<=10; test_case++){
            N=sc.nextInt();
            sc.nextLine();
            build=new int[100];
            String line=sc.nextLine();
            String[] temp=line.split(" ");
            for(int i=0; i<100; i++){
                build[i]=Integer.parseInt(temp[i]);
            }
            dump(build,N);
            System.out.println("#"+test_case+" "+ans);
        }

    }

    public static void dump(int[] build, int n) {
        Arrays.sort(build);
        if((Math.abs(build[0]-build[99])==1 || Math.abs(build[0]-build[99])==0)){
            ans=1;
        }
        if(n==0){
            ans=build[99]-build[0];
        }
        else if(n!=0){
            build[99]-=1;
            build[0]+=1;
            dump(build,n-1);
        }
    }
}