package lab;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Runner {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        VojatiyCollection vcol = new VojatiyCollection();
        vcol.Init();
        List<Vojatiy> vmas = vcol.getVojatie();
        vcol.sort();
        vojatiyPrint(vmas);
        System.out.println("\n");

        OtryadCollection ocol = new OtryadCollection();
        ocol.Init();
        Map<Integer, Otryad> omas = ocol.getOtryady();
        ocol.sort();
        otryadyPrint(omas);
        System.out.println("\n");

        KomnataCollection kcol = new KomnataCollection();
        kcol.Init();
        Set<Komnata> kmas = kcol.getKomnaty();
        komnatyPrint(kmas);
    }

    public static void vojatiyPrint(List<Vojatiy> list) {
        Iterator<Vojatiy> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    public static void otryadyPrint(Map<Integer, Otryad> map) {
        Iterator<Otryad> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    public static void komnatyPrint(Set<Komnata> kmas) {
        Iterator<Komnata> iterator = kmas.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

//    public static void main1(String[] args) throws IOException {
//        Vojatiy[] vmas = new Vojatiy[3];
//        vmas[0] = new Vojatiy("Alexey");
//        vmas[1] = new Vojatiy("Nikolay");
//        vmas[2] = new Vojatiy("Ruslan");
//        VojatiyCollection vcol = new VojatiyCollection();
//        vcol.Init();
//        vmas=vcol.getVojatie();


//        lab1.Otryad[] omas = new lab1.Otryad[5];
//        lab1.OtryadCollection ocol = new lab1.OtryadCollection();
//        ocol.Init();
//        omas = ocol.getOtryady();
//        omas[0] = new lab1.Otryad("Sunny", 1);
//        omas[1] = new lab1.Otryad("Cloud", 2);
//        omas[2] = new lab1.Otryad("Grass", 1);
//        omas[3] = new lab1.Otryad("Sunny", 3);
//        omas[4] = new lab1.Otryad("Flower", 2);



//        lab1.Komnata[] kmas = new lab1.Komnata[3];
//        kmas[0] = new lab1.Komnata(101, "living");
//        kmas[1] = new lab1.Komnata(102, "living");
//        kmas[2] = new lab1.Komnata(201, "living");
//        lab1.KomnataCollection kcol = new lab1.KomnataCollection();
//        kcol.Init();
//        kmas = kcol.getKomnaty();

//        lab1.Child[] cmas=null;

//        for(;;) {
//            System.out.println("???????????????? ?????? ??????????:");
//            System.out.println("1) ???????? ?? ????????????????????");
//            System.out.println("2) ???????????????????? ???????????????????? ??????????????");
//            System.out.println("3) ???????? ???? txt-??????????");
//            System.out.println("4) ???????? ???? xml-??????????");
//            String s1 = reader.readLine();
//            switch (s1) {
//                case "1":
//                    cmas = kvvod();
//                    break;
//                case "2":
//                    cmas=rvvod(omas, kmas);
//                    break;
//                case "3":
//                    try {
//                        cmas=txtvvod();
//                    }
//                    catch (lab1.Exceptions e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "4":
//                    try{
//                        cmas=xmlvvod();
//                    }
//                    catch (lab1.Exceptions e)
//                    {
//                        e.printStackTrace();
//                    }
//                    break;
//                default:
//                    return;
//            }
//            printmas(cmas);
//        }
//    }

    public static Child[] kvvod() throws IOException {
        System.out.println("?????????????? ???????????????????? ??????????????: ");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        Child.count=0;
        Child[] cmas = new Child[n];
        for (int i=0; i<n; i++) {
            cmas[i] = new Child();
            System.out.println("?????????????? ??????: ");
            cmas[i].setName(reader.readLine());
            System.out.println("?????????????? ???????? ???????????????? (????????-????-????): ");
            cmas[i].setBdate(reader.readLine());
            System.out.println("?????????????? ?????? ????????????: ");
            cmas[i].setOcode(Integer.parseInt(reader.readLine()));
            System.out.println("?????????????? ?????? ??????????????: ");
            cmas[i].setKcode(Integer.parseInt(reader.readLine()));
        }
        return cmas;
    }

    public static Child[] rvvod(Otryad[] omas, Komnata[] kmas) throws IOException {
        System.out.println("?????????????? ???????????????????? ??????????????: ");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        Child.count=0;
        Child[] cmas = new Child[n];
        for(int i=0; i<n; i++) {
            cmas[i] = new Child();
        }
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        Random rng = new Random(LocalDateTime.now().getSecond());
        for(int i=0; i<n; i++) {
            cmas[i].setName(generateString(rng, characters, (int) Math.round(Math.random() * 6 + 3)));
            cmas[i].setBdate(LocalDate.now().minusDays(Math.round(Math.random() * 1000 + 3000)).toString());
            cmas[i].setOcode(omas[(int) Math.round(Math.random() * (omas.length - 1))].getCode());
            cmas[i].setKcode(kmas[(int) Math.round(Math.random() * (kmas.length - 1))].getCode());
        }
        return cmas;
    }

    public static Child[] txtvvod() throws Exceptions {
        Child.count=0;
        try(FileReader f = new FileReader("C:/Users/wowki/Desktop/Java/test/Lab1/src/temp.txt")) {
            //FileReader fr = new FileReader(f);
            BufferedReader freader = new BufferedReader(f);
            freader.mark(100000);
            int count = 0;
            String s = freader.readLine();
            String[] s1;
            while (s != null) {
                count++;
                s = freader.readLine();
            }
            Child[] cmas = new Child[count];
            freader.reset();
            for (int i = 0; i < count; i++) {
                s = freader.readLine();
                s1 = s.split("; ");
                cmas[i] = new Child(s1[0], s1[1], Integer.parseInt(s1[2]), Integer.parseInt(s1[3]));
            }
            return cmas;
        }
        catch (IOException e) {
            throw new Exceptions("???? ?????????????? ?????????????? ????????");
        }
    }

//    public static lab1.Child[] xmlvvod() throws lab1.Exceptions {
//        lab1.Child.count=0;
//        try(FileReader f = new FileReader("C:/Users/wowki/Desktop/Java/test/Lab1/src/temp.xml")) {
//            //FileReader fr = new FileReader(f);
//            BufferedReader freader = new BufferedReader(f);
//            StringBuilder sb = new StringBuilder();
//            String s = freader.readLine();
//            while (s != null) {
//                sb.append(s);
//                s = freader.readLine();
//            }
//            String s1 = sb.toString();
//            String[] smas1 = s1.split("\s*<.+?>");
//            List<String> list = new ArrayList<String>(Arrays.asList(smas1));
//            list.removeIf(n -> (n == ""));
//            String[] smas2 = list.toArray(new String[list.size()]);
//            int n = smas2.length / 4;
//            lab1.Child[] cmas = new lab1.Child[n];
//            for (int i = 0; i < n; i++) {
//                cmas[i] = new lab1.Child(smas2[4 * i], smas2[4 * i + 1], Integer.parseInt(smas2[4 * i + 2]), Integer.parseInt(smas2[4 * i + 3]));
//            }
//            return cmas;
//        }
//        catch (IOException e) {
//            throw new lab1.Exceptions("???? ?????????????? ?????????????? ????????");
//        }
//    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static void printmas(Child[] cmas) {
        System.out.format("|%8s| %30s| %10s| %8s| %8s|\n", "??????", "??????", "???????? ????????.", "??????????", "??????????????");
        for (Child c:cmas) {
            c.print();
        }
    }
}