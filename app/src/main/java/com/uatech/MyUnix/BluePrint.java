package com.uatech.MyUnix;

import java.util.ArrayList;


public class BluePrint {

    //Map map = new HashMap();
    //static ArrayList<String> list = new ArrayList<>();

    static Node rootNode = new Node("root");
    static Node currentNode = rootNode;

    static void treeReset() { currentNode = rootNode;}

    static void shift(int no)
    {
        //currentNode = rootNode;
        System.out.println("Inside shift");
        System.out.println(currentNode.name);
        Node temp = currentNode;
        currentNode = currentNode.child.get(no);
        currentNode.prev = temp;
        System.out.println(currentNode.name);
        //Log.d("GGSIPU childrens", currentNode.child.get(0).name);
    }

    static void backTraversal()
    {
        currentNode = currentNode.prev;
    }

    static
    {
        Node collegeOrUniv;
        Node course;
        Node sem;
        Node subject;

        rootNode.child.add(new Node("GGSIPU"));                                               //root0 GGSIPU
            collegeOrUniv = rootNode.child.get(rootNode.child.size()-1);
            collegeOrUniv.description = "Guru Gobind Singh Indraprastha University";
            collegeOrUniv.url = ""+R.drawable.ipu_logo;

            //rootNode.child.get(0).child.add(new Node("B.tech(CSE)"));
            collegeOrUniv.child.add( new Node("B.tech(ECE)"));
                course = collegeOrUniv.child.get(collegeOrUniv.child.size()-1);
                course.description = "Electronics and Communication Engineering";
                course.url = ""+R.drawable.e;

                /*course.child.add( new Node("Sem 1"));
                    sem = course.child.get(course.child.size()-1);

                    sem.child.add( new Node("Applied Physics I"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1KFxJAxzmAhZq_eJXSJX4J3UFymaZTT4m";

                        subject.child.add(new Node("2018"));

                        subject.child.add(new Node("2017"));

                    sem.child.add( new Node("Chemistry"));
                    sem.child.add( new Node("Applied Mathematics - I"));
                    sem.child.add( new Node("Fundamentals of Computer")); */
                //course.child.add( new Node("Sem 2"));
                //course.child.add( new Node("Sem 3"));
                course.child.add( new Node("Sem 4"));
                    sem = course.child.get(course.child.size()-1);

                    sem.child.add( new Node("AM - IV"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Applied Mathematics - IV";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1noV6n21DaNICC5A7XXMzyyAfcX6fRcfW";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1r6TsgAV0aQWNqKpxuOpAwK2flRetf3o_";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1boypoUECBddSCwyrEgHpXPJRCpOGH4k-";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1G_BvS4SlDBdd4fLEhB4JEQ7N_482ubnd";

                    sem.child.add( new Node("AN - II"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Analog Electronics - II";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1_1ni84ncbBB76hXsMP6OXbMwG_-ihnCD";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1XGPDsUQ_pqWy6Qs8YbrNfY-ow1UjrpQH";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1dozqXEK3Uja4xpkqSSBNut9AOYc-oAye";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=10HOvdqI6h3FIg0bpaNvuxuHyjUYIatHg";

                    sem.child.add( new Node("COA"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Computer Organisation and Architecture";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=15MiTZ2bbF8Nwbgka_sMhubouTkE8lKC2";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=10UVjF1eWdIAbZkVobc2IAVAZbxPKRyMR";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1Ofpzeny_dILYzQbdrLOr0bEyUd90CIC9";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=15OalR4dTwA4enEYuiKY_DcQfrA-dbHdc";

                    sem.child.add( new Node("CS"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Communication and System";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1WQEi6xCIG456pTiKh0e4czGqBKViEFmg";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1Ht_OAnRRM7TyDhWcum-Qs4kCC401-8PU";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1fVwSnABQwGgx9ZlrBs59ZK0s3H6cQkx4";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1HD4m5y9m2SFyeE_5C5ietO3lf-8G7Kkq";

                    sem.child.add( new Node("NAS"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Network Analysis and Synthesis";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1GbsOZaTB6ipVxK9-ABITtXjaJubPjCP3";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=15aAI_nHiaJhpRkYXW1VZYAk--n0F53LC";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=16XtA895y3ypMiD_qZyasOnaawGjc3DKk";

                    sem.child.add( new Node("EMFT"));
                        subject = sem.child.get(sem.child.size()-1);
                        subject.description = "Electromagnet Field Theory";

                        subject.child.add(new Node("2019"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1ztHS1zHjGGmXSvLU6Z7SeiFGIphkaZvc";

                        subject.child.add(new Node("2018"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1w8lbsmm0yDLGKHVEB0R9AUlbnEoUA_eM";

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1Xs7P8zAHm6ClxLwNwIlx_eejI0sFqAJO";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1nv_kziwmb_94SZ9W_5g-6KVsMfUoBGWa";

                        subject.child.add(new Node("2015"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1xc5XfImMUalZoclfBh629LFgG_eYjcOi";

                //course.child.add( new Node("Sem 5"));
                //course.child.add( new Node("Sem 6"));
                //course.child.add( new Node("Sem 7"));
                //course.child.add( new Node("Sem 8"));

            //collegeOrUniv.child.add( new Node("B.tech(ECE)"));
            //collegeOrUniv.child.add( new Node("B.tech(EEE)"));
            //collegeOrUniv.child.add( new Node("B.tech(ME)"));
            //collegeOrUniv.child.add( new Node("B.tech(Civil)"));

        rootNode.child.add(new Node("MDU"));                                                  //root1 MDU
            //Node mdu = rootNode.child.get(1);
            collegeOrUniv = rootNode.child.get(rootNode.child.size()-1);
            collegeOrUniv.description = "Maharashi Dayanand University";
            collegeOrUniv.url = ""+R.drawable.mdu_logo;

            collegeOrUniv.child.add(new Node("B.tech(Civil)"));
                course = collegeOrUniv.child.get(collegeOrUniv.child.size()-1);
                course.url = ""+R.drawable.c;

                course.child.add(new Node("Sem 1"));
                    sem = course.child.get(course.child.size()-1);
                    sem.child.add(new Node("BE (Basic of Engineering)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url= "https://drive.google.com/open?id=1XZPgp11aKSeEISWkQlVTtRYrJ_mEmqyb";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1slDd12oBJBY2HWmzISrtaDtiBpuc4iRU";

                        subject.child.add(new Node("2015"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=154oFK1TXWXsVWWPQ0AMSlBsG_480iaOL";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1V4jmBy5fHrUVdj0W_cu3xcmLspnSuUMz";
                    sem.child.add(new Node("BME (Basic of Mechanical Engineering)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1V-TJJmdj2dM4lL2UAL0FGlGb3q_87I-u";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=16aoBvUOBUCaBzbvrwWYXbgS965qs6AX8";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1lm-zggvEpnI4cgLGXLX-3OL7TO_QXntK";
                    sem.child.add(new Node("Chemistry"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1K4N5ylONywU7pItC4v1gygMB7pcUcQLd";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1BiumLmfFatWYp4bC3L6SwXZjEmRji9rH";
                    sem.child.add(new Node("EC (Essential of Communication)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=11zkIA0TOnUvwUBKT8JPUBh3ur_aB_AQf";

                        subject.child.add(new Node("2015"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1VxDEboDpPx1A6hh09T3C2oYDKkBvUSTV";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1iggjF_H1EWw5qF4qdy9RgHigV4v_-IOq";

                        subject.child.add(new Node("2013"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1-c-cEGyzWSO1Bqmx2exCCpfgk1yZc4lN";
                    sem.child.add(new Node("EME (Element of Mechanical Engineering)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2013"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=14qkZYQHLq-eHe793d8tjmUdf6LWoqfCf";

                        subject.child.add(new Node("2012"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1GFCwIlz9SRiBmneY-kUewN35FxmAfl6b";

                        subject.child.add(new Node("2011"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1mM3dzIcsrQKX2rdheu-qoZcOAE-yGuK6";
                    sem.child.add(new Node("ET (Electrical Technology)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1KFxJAxzmAhZq_eJXSJX4J3UFymaZTT4m";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1DC4dQE2hezTg2ti1lST8na6M_Qsa4Wmq";
                    sem.child.add(new Node("FCPIC (Fundamentals of Computer and Programming in C)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=19UqC2_o0EOZlDlCEcfPYE2qfY2Xhg7ET";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1BmeAEPHCWevJ36ZtsDkOMVxyj7bvPYEm";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=18xvni7beEtp4dwGQUCFV5HKnuNybd4YX";
                    sem.child.add(new Node("Maths 1"));
                        subject= sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=11TWNNpszXFpOoypfuh26kui3Oeki1FWH";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/file/d/1UbZ656hwsQIUmFoIYn-G18RLQrpjDYn-/view?usp=sharing";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1D2ObNGk2-kja7rwFUQtgyxsU2Sa5Arb6";
                    sem.child.add(new Node("MP (Manufacturing Process)"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2011"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1qLTE2BppNcvcH7Trng4BdCjWiKCKAYu_";
                    sem.child.add(new Node("Physics"));
                        subject = sem.child.get(sem.child.size()-1);

                        subject.child.add(new Node("2017"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1yDFdkNN7dMAbY6agCbvPlbDcqOCqDB_q";

                        subject.child.add(new Node("2016"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1DB_wAvWpzqN_n30-ljD4K1xem2mkfktt";

                        subject.child.add(new Node("2015"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1Bs8N7y_pO-Ead2zDIEuVdg2oL7YyTKN6";

                        subject.child.add(new Node("2014"));
                        subject.child.get(subject.child.size()-1).url = "https://drive.google.com/open?id=1wRzthnZqJ_glMeYNUg7ol2lCurD3v6oA";
                //mdu_civil.child.add(new Node("Sem 2"));
                course.child.add(new Node("Sem 3"));
                course.child.add(new Node("Sem 4"));
                course.child.add(new Node("Sem 5"));
                course.child.add(new Node("Sem 6"));
                //mdu_sem_civil.child.add(new Node("Sem 7"));
                //mdu_sem_civil.child.add(new Node("Sem 8"));

        //rootNode.child.add(new Node("VIT"));                                                      //root2
            //CollegeOrUniv = rootNode.child.get(2);
    }
}

class Node
{
    //SortedMap<String, Node> childrens = new TreeMap<String, Node>();
    ArrayList<Node> child = new ArrayList<>();
    Node prev = null;
    String name;
    String description;
    String url;

    Node(String name)
    {
        this.name = name;
    }   // Constructor
}
