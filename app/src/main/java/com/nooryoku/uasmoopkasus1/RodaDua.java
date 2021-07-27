package com.nooryoku.uasmoopkasus1;

public class RodaDua {
    private String jenis;
    private String engine;
    private String gear;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getEngine() {
        return "- Buka penutup mesin.\n" +
                "- Cek kondisi mesin.\n" +
                "- Ganti oli mesin";
    }

    public String getGear() {
        if(getJenis().equals("Sport Bike")){
            return "- Cek kabel kopling.\n" +
                    "- Cek Mekanisme gear change";
        }
        else {
            return "- Cek sistem CVT";
        }
    }
}
