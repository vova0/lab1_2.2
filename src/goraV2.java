import java.util.Scanner;
class info{
    String name,mesto;
    double hight;
}
public class goraV2 {
    //Ввод
    public static info[] setgoraArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        info gora[] = new info[k];
        System.out.println("Введите информацию о горе: ");
        for (int i = 0; i < gora.length; i++) {
            gora[i] = new info();
            System.out.print("Название " + (i + 1) + "-й горы => ");
            gora[i].name = sc.nextLine();
            System.out.print("Название места " + (i + 1) + "-й горы => ");
            gora[i].mesto = sc.nextLine();
            System.out.print("высота " + (i + 1) + "-й горы => ");
            gora[i].hight = sc.nextDouble();
            sc.nextLine();
        }
        return gora;
    }
    // Вывод
    public static void showArray(info[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].mesto + " " + cntr[i].hight + " м");
        }
    }
    // Инфо о горе
    public static void gorich(info cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.mesto + "\t" + cntr.hight + "м");
    }
    public static int Max(info []st){
        int maxs=0;
        double max=st[maxs].hight;
        for (int i = 0 ;i<st.length; i++)
            if (st[i].hight>max){
                max=st[i].hight;
                maxs=i;
            }
        return maxs;
    }
    public static int da(info []ds){
       int net =0;
       double das=ds[net].hight;
        for (int a = 0; a < ds.length; a++)
            if (ds[a].hight > 1000) {
                System.out.println("" + ds[a].name + "\t" + ds[a].hight + "м");
            }
       return net;
    }
    public static void sorthight(info []cnt){
        for (int i = 0; i < cnt.length-1; i++)
            for (int j = 0; j < cnt.length-1-i; j++)
                if (cnt[j].hight>cnt[j+1].hight){
                    info rab=cnt[j]; // rab – рабочая переменная для перестановки
                    cnt[j]=cnt[j+1];
                    cnt[j+1]=rab;
                }
    }
public static info findForName(info cntr[], String name){
   int n =-1;
    for (int i = 0; i < cntr.length; i++)
        if (name.equals(cntr[i].name))
            n=i;
    if (n!= -1) {
        return cntr[n];
    }else return null;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество гор=> ");
        int n = sc.nextInt();
        info gora[]= setgoraArr(n);
        System.out.println("\n гора с максимальной высотой:");
        int maxs = Max(gora);
        gorich(gora[maxs]);
        System.out.println("\nГора с  высотой более 1000 м :");
        int netd = da(gora);
        System.out.println("\nсортировка стран по высоте :");
         sorthight(gora);
        showArray(gora);
        System.out.println("\nпоиск горы\n Введите название страны => ");
        sc.nextLine();
        String name=sc.nextLine();
        info sfind = findForName(gora , name);
        if (sfind!=null) {
            gorich(sfind);
        } else {
            System.out.println("Такой горы нет в списке!");
        }
    }
}