package com.sprawdzanie;

import com.taliakart.*;

import java.util.ArrayList;
import java.util.List;

public class RoyalFlush {

    private GUITalia guiTalia;

    private List<Karta> lista;

    private List<Karta> royalFlushPik;
    private List<Karta> royalFlushKier;
    private List<Karta> royalFlushKaro;
    private List<Karta> royalFlushTrefl;

    private List<Karta> kartyGraczStol;

    private int[] licznik;


    public RoyalFlush(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        royalFlush();

        kartyGraczStol();
    }

    public void royalFlush() {

        royalFlushPik = new ArrayList<Karta>();
        royalFlushKier = new ArrayList<Karta>();
        royalFlushKaro = new ArrayList<Karta>();
        royalFlushTrefl = new ArrayList<Karta>();

        royalFlushPik.add(new Karta(Kolor.PIK, Figura.DZIESIATKA));
        royalFlushPik.add(new Karta(Kolor.PIK, Figura.WALET));
        royalFlushPik.add(new Karta(Kolor.PIK, Figura.DAMA));
        royalFlushPik.add(new Karta(Kolor.PIK, Figura.KROL));
        royalFlushPik.add(new Karta(Kolor.PIK, Figura.AS));

        royalFlushKier.add(new Karta(Kolor.KIER, Figura.DZIESIATKA));
        royalFlushKier.add(new Karta(Kolor.KIER, Figura.WALET));
        royalFlushKier.add(new Karta(Kolor.KIER, Figura.DAMA));
        royalFlushKier.add(new Karta(Kolor.KIER, Figura.KROL));
        royalFlushKier.add(new Karta(Kolor.KIER, Figura.AS));

        royalFlushKaro.add(new Karta(Kolor.KARO, Figura.DZIESIATKA));
        royalFlushKaro.add(new Karta(Kolor.KARO, Figura.WALET));
        royalFlushKaro.add(new Karta(Kolor.KARO, Figura.DAMA));
        royalFlushKaro.add(new Karta(Kolor.KARO, Figura.KROL));
        royalFlushKaro.add(new Karta(Kolor.KARO, Figura.AS));

        royalFlushTrefl.add(new Karta(Kolor.TREFL, Figura.DZIESIATKA));
        royalFlushTrefl.add(new Karta(Kolor.TREFL, Figura.WALET));
        royalFlushTrefl.add(new Karta(Kolor.TREFL, Figura.DAMA));
        royalFlushTrefl.add(new Karta(Kolor.TREFL, Figura.KROL));
        royalFlushTrefl.add(new Karta(Kolor.TREFL, Figura.AS));
    }

    public void kartyGraczStol() {

        licznik = new int[4];

        kartyGraczStol = new ArrayList<Karta>();

        if (guiTalia.getListaPlayer1() != null) {
            graczPierwszy();
        }
        if (guiTalia.getListaPlayer2() != null) {
            graczDrugi();
        }
        if (guiTalia.getListaPlayer3() != null) {
            graczTrzeci();
        }
        if (guiTalia.getListaPlayer4() != null) {
            graczCzwarty();
        }
        if (guiTalia.getListaPlayer5() != null) {
            graczPiaty();
        }
        if (guiTalia.getListaPlayer6() != null) {
            graczSzosty();
        }
        if (guiTalia.getListaPlayer7() != null) {
            graczSiodmy();
        }
        if (guiTalia.getListaPlayer8() != null) {
            graczOsmy();
        }


    }

    public void graczPierwszy() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer1());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz pierwszy Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz pierwszy Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz pierwszy Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz pierwszy Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczDrugi() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer2());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz drugi Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz drugi Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz drugi Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz drugi Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczTrzeci() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer3());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz trzeci Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz trzeci Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz trzeci Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz trzeci Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczCzwarty() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer4());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz czwarty Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz czwarty Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz czwarty Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz czwarty Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczPiaty() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer4());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz piąty Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz piąty Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz piąty Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz piąty Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczSzosty() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer4());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz szósty Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz szósty Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz szósty Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz szósty Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczSiodmy() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer4());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz siódmy Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz siódmy Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz siódmy Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz siódmy Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }

    public void graczOsmy() {

        kartyGraczStol.addAll(guiTalia.getListaFlop());
        kartyGraczStol.addAll(guiTalia.getListaTurnOrRiver());
        kartyGraczStol.addAll(guiTalia.getListaPlayer4());

        for (Karta k : kartyGraczStol) {
            if (k.equals(Kolor.PIK)) {
                licznik[0] += 1;
            } else if (k.equals(Kolor.KIER)) {
                licznik[1] += 1;
            } else if (k.equals(Kolor.KARO)) {
                licznik[2] += 1;
            } else if (k.equals(Kolor.TREFL))
                licznik[3] += 1;
        }
        if (licznik[0] >= 5) {

            licznik[0] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushPik) {
                    if (k.equals(r)) {
                        licznik[0] += 1;
                    }
                }
            }
            if (licznik[0] == 5)
                System.out.println("Gracz ósmy Royal Flush PIK");

        } else if (licznik[1] >= 5) {

            licznik[1] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKier) {
                    if (k.equals(r)) {
                        licznik[1] += 1;
                    }
                }
            }
            if (licznik[1] == 5)
                System.out.println("Gracz ósmy Royal Flush Kier");

        } else if (licznik[2] >= 5) {

            licznik[2] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[2] += 1;
                    }
                }
            }
            if (licznik[2] == 5)
                System.out.println("Gracz ósmy Royal Flush Karo");

        } else if (licznik[3] >= 5) {

            licznik[3] = 0;

            for (Karta k : kartyGraczStol) {
                for (Karta r : royalFlushKaro) {
                    if (k.equals(r)) {
                        licznik[3] += 1;
                    }
                }
            }
            if (licznik[3] == 5)
                System.out.println("Gracz ósmy Royal Flush Trefl");

        }
        for (Karta kar : kartyGraczStol)
            kartyGraczStol.remove(kar);

        for (int i = 0; i < licznik.length; i++)
            licznik[i] = 0;
    }
}
