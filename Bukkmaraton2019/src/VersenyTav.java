class VersenyTav {
    private String rajtszam;
    private String kategoria;
    private String nev;
    private String egyesulet;
    private String ido;

    public VersenyTav(String rajtszam, String kategoria, String nev, String egyesulet, String ido) {
        this.rajtszam = rajtszam;
        this.kategoria = kategoria;
        this.nev = nev;
        this.egyesulet = egyesulet;
        this.ido = ido;
    }

    public String getRajtszam() {
        return rajtszam;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getNev() {
        return nev;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public String getIdo() {
        return ido;
    }

    public String getTav() {
        return rajtszam.substring(0, 1);
    }

    public int getIdoInSeconds() {
        String[] splitIdő = ido.split(":");
        int ora = Integer.parseInt(splitIdő[0]);
        int perc = Integer.parseInt(splitIdő[1]);
        int masodperc = Integer.parseInt(splitIdő[2]);
        return ora * 3600 + perc * 60 + masodperc;
    }
}
