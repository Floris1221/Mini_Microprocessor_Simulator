import java.io.Serializable;

public class Zadanie implements Serializable {



        int[] rejestr_y = new int[16];
        static int decimalY;
        int decimalwej1;
        int decimalwej2;
        String operacja;
        String pokonwersjiH="";
        String pokonwersjiL="";
        String zapisanyRozkaz;
        String s1;
        String s2;


        Zadanie(String s1, String s2, String operacja,String zapisanyRozkaz){
            this.zapisanyRozkaz=zapisanyRozkaz;
            this.operacja=operacja;
            this.s1 = s1;
            this.s2=s2;
            wypisz();

        }


        public void wykonaj_operacje(){
            if(s1.equals("A"))
                decimalwej1=Main.okno.decimalA;
            else if(s1.equals("B")){
                decimalwej1=Main.okno.decimalB;
            }
            else if(s1.equals("C")){
                decimalwej1=Main.okno.decimalC;
            }
            else if(s1.equals("D")){
                decimalwej1=Main.okno.decimalD;
            }

            if(s2.equals("A"))
                decimalwej2=Main.okno.decimalA;
            else if(s2.equals("B")){
                decimalwej2=Main.okno.decimalB;
            }
            else if(s2.equals("C")){
                decimalwej2=Main.okno.decimalC;
            }
            else if(s2.equals("D")){
                decimalwej2=Main.okno.decimalD;
            }

            if(operacja.equals("MOV")){
                decimalwej2 = decimalwej1;
                System.out.println(decimalwej2);
                zamiana_na_binarny(decimalwej2);
                konwersja();
                przypisanie();


            }
            if(operacja.equals("ADD")){
                decimalY = decimalwej1 + decimalwej2;
                System.out.println(decimalY);
                zamiana_na_binarny(decimalY);
                konwersja();
                przypisanie();

            }
            if(operacja.equals("SUB")){
                decimalY = decimalwej1 - decimalwej2;
                System.out.println(decimalY);
                zamiana_na_binarny(decimalY);
                konwersja();
                przypisanie();
            }

        }

        public void zamiana_na_binarny(int a){
            int j=0;
            for(int i=15; i>=0;i--){
                if((a&0b1 << i) != 0b0)
                    rejestr_y[j] = 1;
                else
                    rejestr_y[j] = 0;
                j++;
            }
        }


        public void konwersja(){
            for (int i=0; i<8;i++)
            pokonwersjiH= pokonwersjiH+ rejestr_y[i];
            for (int i=8; i<16;i++)
                pokonwersjiL= pokonwersjiL+ rejestr_y[i];

        }

        public void przypisanie(){
            switch (zapisanyRozkaz) {
                case "A":
                    Oknogl.tekst[0][0].setText(pokonwersjiH);
                    Oknogl.tekst[0][1].setText(pokonwersjiL);
                    Oknogl.Wpisz1.doClick();
                    break;
                case "B":
                    Oknogl.tekst[1][0].setText(pokonwersjiH);
                    Oknogl.tekst[1][1].setText(pokonwersjiL);
                    Oknogl.Wpisz3.doClick();
                    break;
                case "C":
                    Oknogl.tekst[3][0].setText(pokonwersjiH);
                    Oknogl.tekst[3][1].setText(pokonwersjiL);
                    Oknogl.Wpisz2.doClick();
                    break;
                case "D":
                    Oknogl.tekst[4][0].setText(pokonwersjiH);
                    Oknogl.tekst[4][1].setText(pokonwersjiL);
                    Oknogl.Wpisz4.doClick();
                    break;
            }
        }

    public void wypisz(){
        Main.okno.textarea.setText(Main.okno.textarea.getText()+"Komenda "+": Rejestr "+s1+"      "+operacja+"      Rejestr "+s2+"       na Rejestr "+zapisanyRozkaz+ "\n");

    }

    }

